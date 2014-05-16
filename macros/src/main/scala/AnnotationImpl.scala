

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


trait AnnotationImpl {
    val c: Context
    protected def annot_tree_impl(ts: List[c.Tree]): List[c.Tree]

    import c.universe._

    final def annot_impl(annottees: c.Tree*): c.Tree = {
        Block(annot_tree_impl(annottees.toList), q"()")
    }
}
