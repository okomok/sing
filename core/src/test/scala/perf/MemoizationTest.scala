

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest.singtest
package perf


import com.github.okomok
import okomok.sing._
import Dense._
import Test._


trait MemoizationTest {

    type N = _1

    trait Diff {
        type diff = makro.ConstantTypeOf.apply(
            makro.Benchmark {
                dummy[SlowFibonacci.fibonacci[N]]
            }
            -
            makro.Benchmark {
                dummy[FastFibonacci.fibonacci[N]]
            }
        )
       // echo[diff]
    }

}
