

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


class New extends StaticAnnotation {
    def macroTransform(annottees: Any*): Unspecified = macro New.annot_impl
}

object New extends AnnotationImpl {
    override protected def annot_tree_impl(c: Context)(ts: List[c.Tree]): List[c.Tree] = {
        import c.universe._

        val name = c.macroApplication match {
            case Apply(Select(Apply(_, List(Literal(Constant(s: String)))), _), _) => s
            case _ => c.abort(c.enclosingPosition, "A string of type name is required")
        }

        val implName = TypeName("As" + name)

        val mixin: c.Tree = tq"${sing_(c)}.$implName"
        val tempname = c.freshName()
        val tempdef: c.Tree = q"val $tempname = ${here(c)}.WeakTypeOf(this)"
        val selfdef: c.Tree = q"override type self = $tempname.apply"

        ts match {
            case List(q"object $name extends $parent { ..$body }") => {
                val ret = q"""
                    object $name extends $parent with $mixin {
                        $tempdef
                        $selfdef
                        ..$body
                    }
                """
                List(ret)
            }
        }
    }
}
