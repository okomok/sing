

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class SplitAtTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        type u = xs#splitAt[_3]
        val u: u = xs.splitAt(_3)
        weak.assertSame[Tuple2[_5 :: _6 :: _7 :: Nil, _8 :: _9 :: Nil], list.force2[u]]
        assertEquals(Tuple2(_5 :: _6 :: _7 :: Nil, _8 :: _9 :: Nil), u)
    }


    def testTakeAll {
        type xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        type u = xs#splitAt[_10#plus[_10]]
        val u: u = xs.splitAt(_10 plus _10)
        weak.assertSame[Tuple2[_5 :: _6 :: _7 :: _8 :: _9 :: Nil, Nil], list.force2[u]]
        assertEquals(Tuple2(_5 :: _6 :: _7 :: _8 :: _9 :: Nil, Nil), u)
    }

    def testTakeNothing {
        type xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        type u = xs#splitAt[_0]
        val u: u = xs.splitAt(_0)
        weak.assertSame[Tuple2[Nil, _5 :: _6 :: _7 :: _8 :: _9 :: Nil], list.force2[u]]
        assertEquals(Tuple2(Nil, _5 :: _6 :: _7 :: _8 :: _9 :: Nil), u)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        type u = xs#splitAt[_3]
        val u: u = xs.splitAt(_3)
        weak.assertSame[Tuple2[Nil, Nil], list.force2[u]]
        assertEquals(Tuple2(Nil, Nil), u)
    }
}
