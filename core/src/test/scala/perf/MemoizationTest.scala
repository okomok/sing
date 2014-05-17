

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
        val b1 = Benchmark {"dummy[SlowFibonacci.fibonacci[N]]"}
        val b2 = Benchmark {"dummy[FastFibonacci.fibonacci[N]]"}
        type b1 = b1.unwrap
        type b2 = b2.unwrap
        type diff = b2#minus[b1]
       // echo[diff]
    }
}
