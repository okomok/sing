

// Copyright Shunsuke Sogame 2008-2014.
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
        val _diff = typeOf(
            makro.Benchmark {"""
                dummy[SlowFibonacci.fibonacci[N]]
            """}
            -
            makro.Benchmark {"""
                dummy[FastFibonacci.fibonacci[N]]
            """}
        )
        type diff = _diff.self
       // echo[diff]
    }

}
