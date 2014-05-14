

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

        val tempname = c.freshName()
        val tempdef: c.Tree = q"val $tempname = ${here(c)}.WeakTypeOf(this)"
        val selfdef: c.Tree = q"type self = $tempname.apply"

        tempdef :: selfdef :: ts
    }
}
