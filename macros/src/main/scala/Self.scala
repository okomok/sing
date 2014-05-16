

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


class Self extends StaticAnnotation {
    def macroTransform(annottees: Any*): Unspecified = macro Self.annot_impl
}

object Self extends AnnotationImpl {
    override protected def annot_tree_impl(c: Context)(ts: List[c.Tree]): List[c.Tree] = {
        import c.universe._

        ts.flatMap {
            case TypeDef(mods, name, tparams, rhs) => {
                val v = TermName(c.freshName())
                val termdef = q"val $v = ${here(c)}.WeakTypeOf(this)"
                val typedef = TypeDef(mods, name, tparams, tq"${Ident(v)}.self")
                List(termdef, typedef)
            }
            case t => List(t)
        }
    }
}
