

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Sleep {
     def apply(x: Long): Unit = macro term_impl
    type apply(x: Long)       = macro type_impl

    def term_impl(c: Context)(x: c.Expr[Long]): c.Expr[Unit] = {
        import c.universe._
        _impl(c)(x)
        reify(())
    }

    def type_impl(c: Context)(x: c.Expr[Long]): c.Tree = {
        import c.universe._
        _impl(c)(x)
        tq"_root_.scala.Unit"
    }

    private def _impl(c: Context)(x: c.Expr[Long]): Unit = {
        import c.universe._
        x.tree match {
            case Literal(Constant(ms: Long)) => Thread.sleep(ms)
            case t => CompileError.illegalArgument(c)(show(t) + " is not Long literal.")
        }
    }
}
