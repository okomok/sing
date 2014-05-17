

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


final class singmethod extends StaticAnnotation {
    def macroTransform(annottees: scala.Any*): scala.Any = macro SingmethodImpl.annotMacro
}


final class SingmethodImpl(override val c: Context) extends AnnotationMacroImpl {
    import c.universe._

    override protected def annotMacroImpl(ts: scala.List[c.Tree]): scala.List[c.Tree] = {
        ts.flatMap {
            case t @ TypeDef(mods, name, tparams, rhs) => {
                val sparams = singparams(tparams)
                val targs = typeargs(tparams)

                val term = toTerm(rhs)
                val typ = if (targs.isEmpty) tq"$name" else tq"$name[..$targs]"

                val termmethod = if (tparams.isEmpty) {
                    val lazymods = AddLazyFlag(c)(mods)
                    q"$lazymods val ${name.toTermName}: $typ = $term" // memoized to follow the typeMacro behavior.
                } else {
                    q"$mods def ${name.toTermName}[..$tparams](..$sparams): $typ = $term"
                }

                scala.List(t, termmethod)
            }
            case t => scala.List(t)
        }
    }

    // [n <: N, m <: M,...] --> (n: n, m: m,...)
    private def singparams(tparams: scala.List[TypeDef]): scala.List[ValDef] = {
        tparams.map { case TypeDef(mods, name, tpt, rhs) =>
            ValDef(mods, name.toTermName, Ident(name), EmptyTree)
        }
    }

    // [n <: N, m <: M,...] --> [n, m,...]
    private def typeargs(tparams: scala.List[TypeDef]): scala.List[Ident] = {
        tparams.map { case TypeDef(_, name, _, _) =>
            Ident(name)
        }
    }

    // [n <: N, m <: M,...] --> (n, m,...)
    private def termargs(tparams: scala.List[TypeDef]): scala.List[Ident] = {
        tparams.map { case TypeDef(_, name, _, _) =>
            Ident(name.toTermName)
        }
    }

    // k[n#m[s]] --> k(n.m(s))
    private def toTerm(rhs: c.Tree): c.Tree = {
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
                Apply(toTerm(f), args.map{ a => toTerm(a) })
            }
            case SelectFromTypeTree(x, m) => {
                Select(toTerm(x), m.toTermName)
            }
            case Select(x, m) => {
                Select(x, m.toTermName)
            }
        }
    }
}
