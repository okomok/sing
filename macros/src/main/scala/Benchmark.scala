

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Benchmark {
    def apply(x: Any): Unspecified = macro impl

    def impl(c: Context)(x: c.Tree): c.Expr[Unspecified] = {
        import c.universe._

        val start = System.currentTimeMillis
        val res1 = c.typecheck(x)
        val elapsed = System.currentTimeMillis - start
//        c.echo(c.enclosingPosition, "elapsed: " + elapsed + "ms")
        c.Expr[Unspecified](Literal(Constant(elapsed)))
    }
}
