

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object AssertNotSame {
    def apply[x, y]: scala.Unit             = macro term_impl_[x, y]
    def apply[x, y](x: x, y: y): scala.Unit = macro term_impl[x, y]
   type apply[x, y]                         = macro type_impl[x, y]

    def term_impl_[x, y](c: Context)(implicit xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]): c.Expr[scala.Unit] = {
        import c.universe._
        _impl(c)(xt, yt)
        reify(())
    }

    def term_impl[x, y](c: Context)(x: c.Expr[x], y: c.Expr[y])(implicit xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]): c.Expr[scala.Unit] = {
        import c.universe._
        _impl(c)(xt, yt)
        reify(())
    }

    def type_impl[x, y](c: Context)(implicit xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]): c.Tree = {
        import c.universe._
        _impl(c)(xt, yt)
        tq"scala.Unit"
    }

    private def _impl[x, y](c: Context)(xt: c.WeakTypeTag[x], yt: c.WeakTypeTag[y]) {
        import c.universe._
        if (weakTypeOf(xt) =:= weakTypeOf(yt)) {
            c.abort(c.enclosingPosition, show(weakTypeOf(xt)) + " is the same type as " + show(weakTypeOf(yt)) + " unexpectedly.")
        }
    }
}
