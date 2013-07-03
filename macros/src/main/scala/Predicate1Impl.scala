

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


trait Predicate1Impl {
    protected def impl(c: Context)(x: c.Type): Boolean

    final def term_impl[x](c: Context)(x: c.Expr[x])(implicit tx: c.WeakTypeTag[x]): c.Expr[Any] = {
        import c.universe._

        val res = if (_impl(c)(tx)) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }

        c.Expr[Any](res)
    }

    final def type_impl[x](c: Context)(implicit tx: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._

        val res = if (_impl(c)(tx)) {
            tq"${sing_(c)}.`true`"
        } else {
            tq"${sing_(c)}.`false`"
        }

        res
    }

    def _impl[x](c: Context)(tx: c.WeakTypeTag[x]): Boolean = {
        import c.universe._

        val x = tx.tpe
        impl(c)(x)
    }
}
