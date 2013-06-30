

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


trait Assert2Impl {
    protected def impl(c: Context)(x: c.Type, y: c.Type): Unit

    final def term_impl_[x, y](c: Context)(implicit tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): c.Expr[Unit] = {
        import c.universe._

        _impl(c)(tx, ty)
        reify(())
    }

    final def term_impl[x, y](c: Context)(x: c.Expr[x], y: c.Expr[y])(implicit tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): c.Expr[Unit] = {
        import c.universe._

        _impl(c)(tx, ty)
        reify(())
    }

    final def type_impl[x, y](c: Context)(implicit tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): c.Tree = {
        import c.universe._

        _impl(c)(tx, ty)
        tq"_root_.scala.Unit"
    }

    private def _impl[x, y](c: Context)(tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): Unit = {
        import c.universe._

        val x = weakTypeOf(tx)
        val y = weakTypeOf(ty)
        impl(c)(x, y)
    }
}
