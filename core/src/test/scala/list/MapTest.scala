

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import Peano.Literal._


class MapTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    class mkString extends AsFunction1 {
        override type self = mkString
        override  def apply[x <: Any](x: x): apply[x] = _Box(x.unsing.toString)
        override type apply[x <: Any] = _Box[String]
    }
    val mkString = new mkString

    def testTrivial {
        type xs = _Box[Int] :: _Box[String] :: _Box[Char] :: Nil
        val xs: xs = _Box(3) :: _Box("hello") :: _Box('a') :: Nil
        val u: xs#map[mkString] = xs.map(mkString)
        val v: _Box[String] :: _Box[String] :: _Box[String] :: Nil = u.force
        assertEquals(_Box("3") :: _Box("hello") :: _Box("a") :: Nil, v)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        val u: xs#map[mkString] = xs.map(mkString)
        val v: Nil = u.force
        ()
    }
}


class MapNatTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    class add2 extends AsFunction1 {
        override type self = add2
        override  def apply[x <: Any](x: x): apply[x] = x.asNat plus _2
        override type apply[x <: Any] = x#asNat#plus[_2]
    }
    val add2 = new add2

    def testTrivial {
        type xs = _3 :: _4 :: _5 :: _6 :: Nil
        val xs: xs = _3 :: _4 :: _5 :: _6 :: Nil
        val u: xs#map[add2] = xs.map(add2)
        val v: _5 :: _6 :: _7 :: _8 :: Nil = u.force
        assertEquals(_5 :: _6 :: _7 :: _8 :: Nil, v)
    }
}

