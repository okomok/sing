

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


trait AnnotationImpl {
    final def annot_impl(c: Context)(annottees: c.Expr[Unspecified]*): c.Expr[Unspecified] = {
        import c.universe._
        c.Expr[Unspecified](Block(annot_tree_impl(c)(annottees.map(_.tree).toList), Literal(Constant(()))))
    }

    protected def annot_tree_impl(c: Context)(ts: List[c.Tree]): List[c.Tree]
}
