

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import scala.reflect.macros.TypecheckException


object ExpectError {
    def apply(r: String)(x: String): Unit = macro impl

    // For some reason, typed and untyped macro can't be mixed.
    def impl(c: Context)(r: c.Expr[String])(x: c.Expr[String]): c.Expr[Unit] = {
        import c.universe._

        val pos = c.enclosingPosition

        val rgx = r match {
            case Expr(Literal(Constant(s: String))) => s
            case _ => CompileError.illegalArgument(c)(show(r) + " is not constant literal.")
        }

        val Expr(Literal(Constant(code: String))) = x

        try {
            c.typecheck(c.parse("{" + code + "}"))
            CompileError.unexpectedCompile(c)(show(x))
        } catch {
            case e: TypecheckException => {
                if (!e.getMessage.matches(rgx)) {
                    CompileError.unexpectedError(c)(show(x) + "\ndue to\n" + e.getMessage)
                }
            }
        }

        LiteralUnit(c)
    }
}
