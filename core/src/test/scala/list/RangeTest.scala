

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import okomok.sing.{assert => dassert}
import nat.dense.Literal._
import junit.framework.Assert._


class RangeTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type rs = list.range[_3, _10]
        val rs: rs = list.range(_3, _10)
        weak.assert[rs#equalWith[_3 :: _4 :: _5 :: _6 :: _7 :: _8 :: _9 :: Nil, nat.naturalOrdering]]
        assertEquals(_3 :: _4 :: _5 :: _6 :: _7 :: _8 :: _9 :: Nil, rs)
    }

    def testEmpty {
        type rs = list.range[_10, _10]
        val rs: rs = list.range(_10, _10)
        weak.assert[rs#isEmpty]
        assertEquals(Nil, rs)
    }

}
