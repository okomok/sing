

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


trait Dependent1Impl[T] {
    protected def term_impl(c: Context)(x: c.Expr[T]): c.Expr[Unspecified]
    protected def type_impl(c: Context)(x: c.Expr[T]): c.Tree

    // `macro` can't see this...
    final def dep_impl(c: Context)(x: c.Expr[T]): c.Expr[Unspecified] = {
        import c.universe._

        val v = term_impl(c)(x).tree
        val t = type_impl(c)(x)

        val ret = q"""
            new ${here(c)}.DependentType {
                override  val apply: apply = $v
                override type apply        = $t
            }
        """

        c.Expr[Unspecified](ret)
    }
}
