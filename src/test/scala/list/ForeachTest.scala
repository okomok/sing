

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._


class ForeachTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    assertFalse(scala.Nil eq Nil)

    def testTrivial {
        type xs = Box[Int] :: Box[String] :: Box[Char] :: Nil
        val xs: xs = Box(3) :: Box("hello") :: Box('a') :: Nil

        val r = new java.util.ArrayList[String]
        class AddString extends Function1 {
            override type self = AddString
            override  def apply[x <: Any](x: x) = { r.add(x.toString); Unit }
            override type apply[x <: Any] = Unit
        }
        val u: Unit = xs.foreach(new AddString)

        assertEquals("[sing.3, sing.hello, sing.a]", r.toString)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil

        val r = new java.util.ArrayList[String]
        class AddString extends Function1 {
            override type self = AddString
            override  def apply[x <: Any](x: x) = { r.add(x.toString); Unit }
            override type apply[x <: Any] = Unit
        }
        val u: Unit = xs.foreach(new AddString)

        assertTrue(r.isEmpty)
    }
}

