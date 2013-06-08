

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Sings {

    type apply = macro impl

    def impl(c: Context): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"
        val Template(parents, self, body) = c.enclosingTemplate
        val res = Template(RemoveMacro(c)(parents), self, singize(c)(body))
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
                    q"$lazymods val ${name.toTermName}: $name = $term" // memoized to follow the typemethod behavior.
                } else {
                    val tp = tq"$name[..$targs]"
                    // Scalac needs asInstanceOf for complicated expressions.
                    val term_ = if (term.isEmpty) term else q"$term.asInstanceOf[$tp]"
                    q"$mods def $name[..$tparams](..$sparams): $tp = $term_"
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
                        ValDef(ConstructorParamMods(c), name, tpt, rhs)
                    }
                    // val ClassDef(_, _, _, Template(_, _, sparamsbody)) = q"class $name(..$sparams)"
                    ClassDef(mods, name, tparams, Template(parents, self, sparamsbody ++ List(ConstructorTree(c)(sparams)) ++ RemoveDefaultConstructor(c)(body)))
                }

                val termmethod = if (tparams.isEmpty) {
                    val obj = TermName("_TermOf" + name.toString)
                    q"""
                        object $obj {
                            val apply: $name = new $name
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
