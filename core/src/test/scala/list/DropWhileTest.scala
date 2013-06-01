

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class DropWhileTest extends org.scalatest.junit.JUnit3Suite {

    case class Lt8() extends Function1 {
        override type self = Lt8
        override  def apply[x <: Any](x: x): apply[x] = x.asNat lt _8
        override type apply[x <: Any] = x#asNat#lt[_8]
    }

    def testTrivial {
        type xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val u: xs#dropWhile[Lt8] = xs.dropWhile(Lt8())
        Weak.assertSame[_8 :: _9 :: Nil, xs#dropWhile[Lt8]#force]
        assertEquals(_8 :: _9 :: Nil, u)
    }

    def testTrivialToAll {
        type xs = _9 :: _5 :: _6 :: _7 :: _1 :: _9 :: Nil
        val xs: xs = _9 :: _5 :: _6 :: _7 :: _1 :: _9 :: Nil
        val u: xs#dropWhile[Lt8] = xs.dropWhile(Lt8())
        Weak.assertSame[_9 :: _5 :: _6 :: _7 :: _1 :: _9 :: Nil, xs#dropWhile[Lt8]#force]
        assertEquals(_9 :: _5 :: _6 :: _7 :: _1 :: _9 :: Nil, u)
    }

    def testTrivialToNil {
        type xs = _4 :: _5 :: _6 :: _7 :: Nil
        val xs: xs = _4 :: _5 :: _6 :: _7 :: Nil
        val u: xs#dropWhile[Lt8] = xs.dropWhile(Lt8())
        Weak.assertSame[Nil, xs#dropWhile[Lt8]#force]
        assertEquals(Nil, u)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        val u: xs#dropWhile[Lt8] = xs.dropWhile(Lt8())
        Weak.assertSame[Nil, xs#dropWhile[Lt8]#force]
        assertEquals(Nil, u)
    }

}
