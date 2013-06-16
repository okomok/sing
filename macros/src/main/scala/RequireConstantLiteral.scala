

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


private object RequireConstantLiteral {
    def apply(c: Context)(x: c.Expr[_]): Unit = {
        import c.universe._

        x.tree match {
            case Literal(Constant(_)) => ()
            case _ => c.abort(c.enclosingPosition, "constant literal is required")
        }
    }
}
