

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


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
        val res = Template(RemoveMacroApplication(c)(parents), self, body ++ termMethodize(c)(body))
        // println(res)
        res
    }

    private def termMethodize(c: Context)(body: List[c.Tree]): List[c.Tree] = {
        import c.universe._

        object WithSingmethodAnnotation {
            def unapply(annotations: List[c.Tree]): Boolean = {
                annotations.find {
                    ann => IsSingmethodAnnotation(c)(ann)
                }.isDefined
            }
        }

        body.collect {
            case TypeDef(mods @ Modifiers(_, _, WithSingmethodAnnotation()), name, tparams, rhs) => {
                val vparams = tparams.map {
                    case TypeDef(mods, name, tpt, rhs) => {
                        ValDef(mods, name.toTermName, Ident(name), rhs)
                    }
                }

                val targs = tparams.map { case TypeDef(_, name, _, _) =>
                    Ident(name)
                }

                val term = toTerm(c)(rhs)
                if (tparams.isEmpty) {
                    val lazymods = AddLazyFlag(c)(mods)
                    q"$lazymods val ${name.toTermName}: $name = $term" // easily memoized
                } else {
                    q"$mods def $name[..$tparams](..$vparams): $name[..$targs] = $term"
                }
            }

            // todo..
        }
    }

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
