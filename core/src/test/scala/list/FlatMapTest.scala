

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._


class FlatMapTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    class oops extends AsFunction1 {
        override type self = oops
        override  def apply[x <: Any](x: x): apply[x] = x :: _Box("oops") :: Nil
        override type apply[x <: Any] = x :: _Box[String] :: Nil
    }
    val oops = new oops

    def testTrivial {
        type xs = _Box[Int] :: _Box[String] :: _Box[Char] :: Nil
        val xs: xs = _Box(3) :: _Box("hello") :: _Box('a') :: Nil
        val u: xs#flatMap[oops] = xs.flatMap(oops)
        val v: _Box[Int] :: _Box[String] :: _Box[String] :: _Box[String] :: _Box[Char] :: _Box[String] :: Nil = u.force
        assertEquals(_Box(3) :: _Box("oops") :: _Box("hello") :: _Box("oops") :: _Box('a') :: _Box("oops")  :: Nil, v)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        val u: xs#flatMap[oops] = xs.flatMap(oops)
        val v: Nil = u.force
        ()
    }
}
