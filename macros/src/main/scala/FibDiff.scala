

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object FibDiff {

    type apply(n: Int) = macro impl

    def impl(c: Context)(n: c.Expr[Int]): c.Tree = {
        import c.universe._

        tq"""
            ${here(c)}.ConstantTypeOf.apply(
                ${here(c)}.Benchmark {
                    dummy[${perf_(c)}.SlowFibonacci.fibonacci[${sing_(c)}.Dense_($n)]]
                }
                -
                ${here(c)}.Benchmark {
                    dummy[${perf_(c)}.FastFibonacci.fibonacci[${sing_(c)}.Dense_($n)]]
                }
            )
        """
    }
}
