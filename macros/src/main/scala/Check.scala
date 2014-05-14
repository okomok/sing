

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Check {
    def apply[x](x: x): Unspecified = macro term_impl[x]

    def term_impl[x](c: Context)(x: c.Expr[x])(implicit tx: c.WeakTypeTag[x]): c.Expr[x] = {
        import c.universe._

        _impl(c)(tx)
        x
    }

    def type_impl[x](c: Context)(implicit tx: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._

        _impl(c)(tx)
        tq"${tx.tpe}"
    }

    def _impl[x](c: Context)(tx: c.WeakTypeTag[x]): Unit = {
        import c.universe._

        val t = tx.tpe

        // order matters
        if (t <:< weakTypeOf[Nothing]) {
            CompileError.nothingType (c)(show(t) + ", which is expanded to " + show(t.dealias))
        } else if (IsAbstract._impl(c)(tx)) {
            CompileError.abstractType(c)(show(t) + ", which is expanded to " + show(t.dealias))
        }
    }
}
