

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Echo {
     def apply[x]: scala.Unit       = macro term_impl_[x]
     def apply[x](x: x): scala.Unit = macro term_impl[x]
    type apply[x]                   = macro type_impl[x]

    def term_impl_[x](c: Context)(implicit xt: c.WeakTypeTag[x]): c.Expr[scala.Unit] = {
        import c.universe._
        _impl(c)(xt)
        reify(())
    }

    def term_impl[x](c: Context)(x: c.Expr[x])(implicit xt: c.WeakTypeTag[x]): c.Expr[scala.Unit] = {
        import c.universe._
        _impl(c)(xt)
        reify(())
    }

    def type_impl[x](c: Context)(implicit xt: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._
        _impl(c)(xt)
        tq"scala.Unit"
    }

    private def _impl[x](c: Context)(xt: c.WeakTypeTag[x]) {
        import c.universe._
        val t = weakTypeOf(xt)
        val nt = t.normalize
        c.echo(c.enclosingPosition, "type: " + show(t) + ", tree: " + showRaw(t) + ", normalized type: " + show(nt) + ", normalized tree: " + showRaw(nt))
    }
}
