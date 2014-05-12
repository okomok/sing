

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object WeakTypeOf extends Dependent1Impl[Any] {
    def apply(x: Any): Unspecified = macro impl

    def impl(c: Context)(x: c.Expr[Any]): c.Expr[Unspecified] = dep_impl(c)(x)

    override protected def term_impl(c: Context)(x: c.Expr[Any]): c.Expr[Unspecified] = {
        c.typecheck(x.tree)
        x
    }

    override protected def type_impl(c: Context)(x: c.Expr[Any]): c.Tree = {
        import c.universe._

        c.typecheck(x.tree)
        TypeTree(x.tree.tpe)
    }
}
