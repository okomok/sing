

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

        val Template(parents, _, oldbody) = c.enclosingTemplate
        val body = singize(c)(oldbody)

        Template(removeMacro(c)(parents), emptyValDef, body)
    }

    def removeMacro(c: Context)(parents: List[c.Tree]): List[c.Tree] = {
        parents.filter { x =>
            !x.equalsStructure(c.macroApplication)
        }
    }

    private def singize(c: Context)(body: List[c.Tree]) : List[c.Tree] = {
        import c.universe._

        body.flatMap { t =>
            if (isSingmethodAnnotated(c)(t)) {
                val (te, ty) = singDef(c)(t)
                List(te, ty)
            } else {
                List(t)
            }
        }
    }

    // How to do it precisely?
    private def isSingmethodAnnotation(c: Context)(an: c.Tree): Boolean = {
        import c.universe._

        an match {
            case Apply(Select(New(Ident(TypeName(tn))), _), _) => {
                tn.reverse.take(10).reverse == "singmethod"
            }
            case _ => false
        }
    }

    private def isSingmethodAnnotated(c: Context)(t: c.Tree): Boolean = {
        import c.universe._

        t match {
            case DefDef(mods, _, _, _, _, _) =>
                mods.annotations.find { (an: c.Tree) =>
                    isSingmethodAnnotation(c)(an)
                }.isDefined
            case _ => false
        }
    }

    private def removeSingmethodAnnotation(c: Context)(mods: c.universe.Modifiers): c.universe.Modifiers = {
        import c.universe._

        val Modifiers(flags, privateWithin, annotations) = mods

        val ans = annotations.filter { an =>
            !isSingmethodAnnotation(c)(an)
        }

        Modifiers(flags, privateWithin, ans)
    }

    private def singDef(c: Context)(dd: c.Tree): (c.Tree, c.Tree) = {
        import c.universe._

        val DefDef(oldmods, name, _, oldvparams :: _, _, rhs) =  dd

        val vparams = oldvparams.map { case ValDef(mods, name, tpt, rhs) =>
            ValDef(mods, name, Ident(name.toTypeName), rhs)
        }

        val tparams = oldvparams.map { case ValDef(mods, name, tpt, rhs) =>
            TypeDef(mods, name.toTypeName, Nil, TypeBoundsTree(EmptyTree, tpt))
        }

        val targs = oldvparams.map { case ValDef(mods, name, tpt, rhs) =>
            Ident(name.toTypeName)
        }

        val typ = toType(c)(rhs)
        val term = toTerm(c)(typ) // to strip TypeApply

        val mods = removeSingmethodAnnotation(c)(oldmods)

        val termmethod = q"$mods def $name[..$tparams](..$vparams): ${name.toTypeName}[..$targs] = $term"
        val typemethod = q"type ${name.toTypeName}[..$tparams] = $typ"

        (termmethod, typemethod)
    }

    private def toType(c: Context)(term: c.Tree): c.Tree = {
        import c.universe._

        term match {
            case Ident(x) => {
                Ident(x.toTypeName)
            }
            case Apply(f, args) => {
                AppliedTypeTree(toType(c)(f), args.map{ a => toType(c)(a) })
            }
            case TypeApply(f, _) => {
                toType(c)(f)
            }
            case Select(x, m) => {
                SelectFromTypeTree(toType(c)(x), m.toTypeName)
            }
        }
    }

    private def toTerm(c: Context)(term: c.Tree): c.Tree = {
        import c.universe._

        term match {
            case Ident(x) => {
                Ident(x.toTermName)
            }
            case AppliedTypeTree(f, args) => {
                Apply(toTerm(c)(f), args.map{ a => toTerm(c)(a) })
            }
            case SelectFromTypeTree(x, m) => {
                Select(toTerm(c)(x), m.toTermName)
            }
        }
    }

}
