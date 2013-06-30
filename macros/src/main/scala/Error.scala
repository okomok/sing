

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Error {
     def apply: Unit = macro term_impl
    type apply             = macro type_impl

    def term_impl(c: Context): c.Expr[Unit] = {
        import c.universe._
        _impl(c)
        reify(())
    }

    def type_impl(c: Context): c.Tree = {
        import c.universe._
        _impl(c)
        tq"_root_.scala.Unit"
    }

    private def _impl(c: Context) {
        import c.universe._
        c.abort(c.enclosingPosition, "compile-error expectedly.")
    }
}
