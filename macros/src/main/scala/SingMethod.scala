

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


class SingMethod extends StaticAnnotation {
    def macroTransform(annottees: Any*): Unspecified = macro SingMethod.annot_impl
}

object SingMethod extends AnnotationImpl {
    override protected def annot_tree_impl(c: Context)(ts: List[c.Tree]): List[c.Tree] = {
        import c.universe._
        singize(c)(ts)
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

        body.flatMap {
            case t @ TypeDef(mods, name, tparams, rhs) => {
                val sparams = singparams(c)(tparams)
                val targs = typeargs(c)(tparams)

                val term = toTerm(c)(rhs)
                val typ = if (targs.isEmpty) tq"$name" else tq"$name[..$targs]"

                val termmethod = if (tparams.isEmpty) {
                    val lazymods = AddLazyFlag(c)(mods)
                    q"$lazymods val ${name.toTermName}: $typ = $term" // memoized to follow the typemethod behavior.
                } else {
                    q"$mods def ${name.toTermName}[..$tparams](..$sparams): $typ = $term"
                }

                List(t, termmethod)
            }
            case t => List(t)
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
