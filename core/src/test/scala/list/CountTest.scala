

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._


class CountTest extends org.scalatest.junit.JUnit3Suite {

    case class Lt8() extends Function1 {
        override type self = Lt8
        override  def apply[x <: Any](x: x): apply[x] = x.asNat lt _8
        override type apply[x <: Any] = x#asNat#lt[_8]
    }

    def testTrivial {
        type xs = _5 :: _6 :: _10 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _10 :: _7 :: _8 :: _9 :: Nil
        val u: xs#count[Lt8] = xs.count(Lt8())
        weak.assertSame[_3, xs#count[Lt8]]
        assertEquals(_3, u)
    }

    def testTrivialToZero {
        type xs = _9 :: _10 :: _8 :: _9 :: Nil
        val xs: xs = _9 :: _10 :: _8 :: _9 :: Nil
        val u: xs#count[Lt8] = xs.count(Lt8())
        weak.assertSame[_0, xs#count[Lt8]]
        assertEquals(_0, u)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        val u: xs#count[Lt8] = xs.count(Lt8())
        weak.assertSame[_0, xs#count[Lt8]]
        assertEquals(_0, u)
    }

}
