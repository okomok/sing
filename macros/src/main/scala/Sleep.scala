

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Sleep {
     def apply(x: Long): scala.Unit = macro term_impl
    type apply(x: Long)             = macro type_impl

    def term_impl(c: Context)(x: c.Expr[Long]): c.Expr[scala.Unit] = {
        import c.universe._
        _impl(c)(x)
        reify(())
    }

    def type_impl(c: Context)(x: c.Expr[Long]): c.Tree = {
        import c.universe._
        _impl(c)(x)
        tq"scala.Unit"
    }

    private def _impl(c: Context)(x: c.Expr[Long]): Unit = {
        import c.universe._
        x.tree match {
            case Literal(Constant(ms: Long)) => Thread.sleep(ms)
            case t => c.abort(c.enclosingPosition, "not Long literal: " + show(t))
        }
    }
}
