

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import Peano.Literal._
import junit.framework.Assert._


class SpanTest extends org.scalatest.junit.JUnit3Suite {

    case class Lt8() extends AsFunction1 {
        override type self = Lt8
        override  def apply[x <: Any](x: x): apply[x] = x.asNat lt _8
        override type apply[x <: Any] = x#asNat#lt[_8]
    }

    def testTrivial {
        type xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        type u = xs#span[Lt8]
        val u: u = xs.span(Lt8())
        Test.assertSame[Tuple2[_5 :: _6 :: _7 :: Nil, _8 :: _9 :: Nil], List.force2[u]]
        assertEquals(Tuple2(_5 :: _6 :: _7 :: Nil, _8 :: _9 :: Nil), u)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        type u = xs#span[Lt8]
        val u: u = xs.span(Lt8())
        Test.assertSame[Tuple2[Nil, Nil], List.force2[u]]
        assertEquals(Tuple2(Nil, Nil), u)
    }

    def testTakeAll {
        type xs = _4 :: _5 :: _6 :: _7 :: Nil
        val xs: xs = _4 :: _5 :: _6 :: _7 :: Nil
        type u = xs#span[Lt8]
        val u: u = xs.span(Lt8())
        Test.assertSame[Tuple2[xs, Nil], List.force2[u]]
        assertEquals(Tuple2(xs, Nil), u)
    }

    def testTakeNothing {
        type xs = _9 :: _5 :: _6 :: _7 :: _1 :: _9 :: Nil
        val xs: xs = _9 :: _5 :: _6 :: _7 :: _1 :: _9 :: Nil
        type u = xs#span[Lt8]
        val u: u = xs.span(Lt8())
        Test.assertSame[Tuple2[Nil, xs], List.force2[u]]
        assertEquals(Tuple2(Nil, xs), u)
    }

}
