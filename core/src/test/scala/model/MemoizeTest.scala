

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package modeltest


import com.github.okomok
import okomok.sing._
import okomok.sing.{assert => dassert}
import junit.framework.Assert._


import okomok.sing.nat.dense.Literal._
import okomok.sing.nat.dense.{Nil, ::, _1B, _0B}
import FastFibonacci._


class MemoizeTest {

    trait testMemoize {
        type t = fibonacci[_15#plus[_12]]
        free.assertSame[`true`, t# equal[_0B ::_1B ::_0B ::_0B ::_0B ::_0B ::_1B ::_0B ::_1B ::_1B ::_1B ::_1B ::_1B ::_1B ::_1B ::_1B ::_0B ::_1B :: Nil]]
    }

}

