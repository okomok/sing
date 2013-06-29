

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Check {
     def apply[x](x: x) = macro term_impl[x]
    type apply[x]       = macro type_impl[x]

    def term_impl[x](c: Context)(x: c.Expr[x])(implicit tx: c.WeakTypeTag[x]): c.Expr[x] = {
        import c.universe._

        _impl(c)(tx)
        x
    }

    def type_impl[x](c: Context)(implicit tx: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._

        _impl(c)(tx)
        tq"${weakTypeOf[x]}"
    }

    def _impl[x](c: Context)(tx: c.WeakTypeTag[x]): Unit = {
        import c.universe._

        val t = weakTypeOf(tx)
        if (IsAbstract._impl(c)(tx)) {
            c.abort(c.enclosingPosition, show(t) + " is abstract type: " + show(t.normalize))
        } else if (t <:< weakTypeOf[Nothing]) {
            c.abort(c.enclosingPosition, show(t) + " is Nothing type: " + show(t.normalize))
        }
    }
}
