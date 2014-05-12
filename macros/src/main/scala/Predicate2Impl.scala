

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


trait Predicate2Impl {
    protected def impl(c: Context)(x: c.Type, y: c.Type): Boolean

    final def term_impl[x, y](c: Context)(x: c.Expr[x], y: c.Expr[y])(implicit tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): c.Expr[Unspecified] = {
        import c.universe._

        val res = if (_impl(c)(tx, ty)) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }

        c.Expr[Unspecified](res)
    }

    final def type_impl[x, y](c: Context)(implicit tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): c.Tree = {
        import c.universe._

        val res = if (_impl(c)(tx, ty)) {
            tq"${sing_(c)}.`true`"
        } else {
            tq"${sing_(c)}.`false`"
        }

        res
    }


    def _impl[x, y](c: Context)(tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): Boolean = {
        import c.universe._

        val x = tx.tpe
        val y = ty.tpe
        impl(c)(x, y)
    }
}
