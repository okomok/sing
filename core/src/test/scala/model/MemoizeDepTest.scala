

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package modeltest


import com.github.okomok
import okomok.sing._
import okomok.sing.{assert => dassert}
import junit.framework.Assert._


import okomok.sing.Dense.Literal._
import okomok.sing.Dense.{::, _1B, _0B}
// import SlowFibonacci._
import FastFibonacci._


class MemoizeDepTest {

    trait Bar[t] {
        type kk = t
    }


    trait testMemoize {
        type t1 = fibonacci[_13]
        type t2 = Bar[fibonacci[_13]]
        type t3 = Bar[Bar[fibonacci[_13]]]
    }

}

