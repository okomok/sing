

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest.singtest
package perf


import com.github.okomok
import okomok.sing._
import Dense._



trait StructuralComplexityTezt {

    trait not2 extends AsFunction1 {
        override type self = not2
        override type apply[x <: Any] = x#asNat#nequal[_2]
    }

    final val N = 1
    val _NatN = Nat_(N)
    type xs = List.range[_0, _NatN.apply]#force

    val _diff = TypeOf(
        Benchmark {"""
             dummy[ xs#filter[not2]#force ]
        """}
    )
    type diff = _diff.apply
    // echo[diff]
}
