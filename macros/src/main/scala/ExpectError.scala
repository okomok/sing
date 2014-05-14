

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import scala.reflect.macros.TypecheckException


object ExpectError {
    def apply(r: String)(x: String): Unit = macro impl

    def impl(c: Context)(r: c.Tree)(x: c.Tree): c.Tree = {
        import c.universe._

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
