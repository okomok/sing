

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.{Context, TypecheckException}


object ExpectErrorOf {
    def apply(r: String)(x: _): scala.Unit = macro impl

    // For some reason, typed and untyped macro can't be mixed.
    def impl(c: Context)(r: c.Tree)(x: c.Tree): c.Expr[scala.Unit] = {
        import c.universe._

        val pos = c.enclosingPosition

        val rgx = c.typeCheck(r) match {
            case Literal(Constant(s: String)) => s
            case _ => c.abort(pos, show(r) + " is not constant")
        }

        try {
            c.typeCheck(x)
            c.abort(pos, show(x) + " compiles unexpectedly")
        } catch {
            case e: TypecheckException => {
                if (!e.getMessage.matches(rgx)) {
                    c.abort(pos, show(x) + " doesn't compile unexpectedly - " + e.getMessage)
                }
            }
        }

        reify(())
    }
}
