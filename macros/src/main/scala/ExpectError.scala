

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.{Context, TypecheckException}


object ExpectError {
    def apply(r: String)(x: _): Unit = macro impl

    // For some reason, typed and untyped macro can't be mixed.
    def impl(c: Context)(r: c.Tree)(x: c.Tree): c.Expr[Unit] = {
        import c.universe._

        val pos = c.enclosingPosition

        val rgx = c.typeCheck(r) match {
            case Literal(Constant(s: String)) => s
            case _ => CompileError.illegalArgument(c)(show(r) + " is not constant literal.")
        }

        try {
            c.typeCheck(x)
            CompileError.unexpectedCompile(c)(show(x))
        } catch {
            case e: TypecheckException => {
                if (!e.getMessage.matches(rgx)) {
                    CompileError.unexpectedError(c)(show(x) + "\ndue to\n" + e.getMessage)
                }
            }
        }

        reify(())
    }
}
