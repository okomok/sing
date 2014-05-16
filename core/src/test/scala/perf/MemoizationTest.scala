

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest.singtest
package perf


import com.github.okomok
import okomok.sing._
import Dense._



trait MemoizationTest {

    type N = _1

    trait Diff {
        val _diff = TypeOf(
            Benchmark {"""
                dummy[SlowFibonacci.fibonacci[N]]
            """}
            -
            Benchmark {"""
                dummy[FastFibonacci.fibonacci[N]]
            """}
        )
        type diff = _diff.apply
       // echo[diff]
    }

}
