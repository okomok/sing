

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._


class FilterTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    assertFalse(scala.Nil eq Nil)

    class not2 extends Function1 {
        override type self = not2
        override  def apply[x <: Any](x: x): apply[x] = x.asNat nequal _2
        override type apply[x <: Any] = x#asNat# nequal[_2]
    }
    val not2 = new not2

    def testTrivial {
        type xs = _2 :: _3 :: _4 :: _2 :: _5 :: _6 :: _2 :: Nil
        val xs: xs = _2 :: _3 :: _4 :: _2 :: _5 :: _6 :: _2 :: Nil
        val u: xs#filter[not2] = xs.filter(not2)
        //println(u)
        val v: _3 :: _4 :: _5 :: _6 :: Nil = u.force
        assertEquals(_3 :: _4 :: _5 :: _6 :: Nil, v)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        val u: xs#filter[not2] = xs.filter(not2)
        val v: Nil = u.force
        ()
    }
}

