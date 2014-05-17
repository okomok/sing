

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import scala.reflect.macros.TypecheckException


/**
 * Expects a specified compile-error.
 */
object ExpectError {
    def apply(r: String)(x: String): scala.Unit = macro ExpectErrorImpl.termMacro
}


final class ExpectErrorImpl(val c: Context) {
    import c.universe._

    def termMacro(r: c.Tree)(x: c.Tree): c.Tree = {
        val rgx = ExtractString(c)(r)
        val code = ExtractString(c)(x)

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

        q"()"
    }
}
