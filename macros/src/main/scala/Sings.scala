

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


// Special thanks to: https://github.com/leonardschneider/macrogen


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Sings {

    type apply = macro apply

    def apply(c: Context): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"
        val Template(parents, self, body) = c.enclosingTemplate
        val res = Template(RemoveMacroApplication(c)(parents), self, singize(c)(body))
        //println(res)
        res
    }

    // [n <: N, m <: M,...] --> (n: n, m: m,...)
    private def singparams(c: Context)(tparams: List[c.universe.TypeDef]): List[c.universe.ValDef] = {
        import c.universe._
        tparams.map { case TypeDef(mods, name, tpt, rhs) =>
            ValDef(mods, name.toTermName, Ident(name), EmptyTree)
        }
    }

    // [n <: N, m <: M,...] --> [n, m,...]
    private def typeargs(c: Context)(tparams: List[c.universe.TypeDef]): List[c.universe.Ident] = {
        import c.universe._

        tparams.map { case TypeDef(_, name, _, _) =>
            Ident(name)
        }
    }

    // [n <: N, m <: M,...] --> (n, m,...)
    private def termargs(c: Context)(tparams: List[c.universe.TypeDef]): List[c.universe.Ident] = {
        import c.universe._

        tparams.map { case TypeDef(_, name, _, _) =>
            Ident(name.toTermName)
        }
    }

    private def constructorParamMods(c: Context): c.Modifiers = {
        import c.universe._

        val ClassDef(_, _, _, Template(_, _, body)) = q"class Foo(i : Int)"

        body.collect{ case ValDef(mods, TermName("i"), _, _) =>
            mods
        }.head
    }

    private def makeConstructor(c: Context)(sparams: List[c.universe.ValDef]): List[c.Tree] = {
        import c.universe._
        val ClassDef(_, _, _, Template(_, _, body)) = q"class X(..$sparams)"
        List(body.last)
    }

    private def removeNullaryConstructor(c: Context)(from: List[c.Tree]) = {
        import c.universe._

        val ClassDef(_, _, _, Template(_, _, body)) = q"class i"

        from.filter { t =>
            !t.equalsStructure(body.head)
        }
    }

    private def singize(c: Context)(body: List[c.Tree]): List[c.Tree] = {
        import c.universe._
        import Flag._

        object WithSingmethodAnnotation {
            def unapply(annotations: List[c.Tree]): Boolean = {
                annotations.find {
                    an => IsSingmethodAnnotation(c)(an)
                }.isDefined
            }
        }

        body.flatMap {
            case t @ TypeDef(mods @ Modifiers(_, _, WithSingmethodAnnotation()), name, tparams, rhs) => {
                val sparams = singparams(c)(tparams)
                val targs = typeargs(c)(tparams)
                val term = toTerm(c)(rhs)
                val termmethod = if (tparams.isEmpty) {
                    val lazymods = AddLazyFlag(c)(mods)
                    q"$lazymods val ${name.toTermName}: $name = $term" // easily memoized
                } else {
                    q"$mods def $name[..$tparams](..$sparams): $name[..$targs] = $term"
                }

                List(t, termmethod)
            }

            case t @ ClassDef(mods @ Modifiers(_, _, WithSingmethodAnnotation()), name, tparams, Template(parents, self, body)) => {
                val sparams = singparams(c)(tparams)
                val targs = typeargs(c)(tparams)
                val vargs = termargs(c)(tparams)

                val typemethod = if (tparams.isEmpty) {
                    t
                } else {
                    val sparamsbody = sparams.map { case ValDef(mods, name, tpt, rhs) =>
                        ValDef(constructorParamMods(c), name, tpt, rhs)
                    }
                    // val ClassDef(_, _, _, Template(_, _, sparamsbody)) = q"class $name(..$sparams)"
                    ClassDef(mods, name, tparams, Template(parents, self, sparamsbody ++ makeConstructor(c)(sparams) ++ removeNullaryConstructor(c)(body)))
                }

                val termmethod = if (tparams.isEmpty) {
                    val obj = TermName("TermOf" + name.toString)
                    q"""
                        object $obj {
                            val term: $name = new $name
                       }
                    """
                } else {
                    val obj = name.toTermName
                    q"""
                        object $obj {
                            def apply[..$tparams](..$sparams): $name[..$targs] = new $name[..$targs](..$vargs)
                        }
                    """
                }

                List(typemethod, termmethod)
            }

            case t => {
                List(t)
            }
        }
    }

    // k[n#m[s]] --> k(n.m(s))
    private def toTerm(c: Context)(rhs: c.Tree): c.Tree = {
        import c.universe._

        rhs match {
            case EmptyTree => {
                EmptyTree
            }
            case TypeBoundsTree(lo, hi) => { // abstract types
                EmptyTree
            }
            case Ident(x) => {
                Ident(x.toTermName)
            }
            case AppliedTypeTree(f, args) => {
                Apply(toTerm(c)(f), args.map{ a => toTerm(c)(a) })
            }
            case SelectFromTypeTree(x, m) => {
                Select(toTerm(c)(x), m.toTermName)
            }
            case Select(x, m) => {
                Select(x, m.toTermName)
            }
        }
    }
}
