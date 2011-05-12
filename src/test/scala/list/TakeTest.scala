

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._


class TakeTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testTrivial {
        val i = new java.lang.Integer(10)
        val lst = Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Box(12) :: Nil
        val a = lst.take(_0)
        val b: Box[Int] :: Box[String] :: Nil = lst.take(_2).force
        val c = lst.take(_5)
        assertEquals(Nil, a)
        assertEquals(Box(3) :: Box("hello") :: Nil, b)
        assertEquals(Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Box(12) :: Nil, c)
    }

    def testTooMany {
        val i = new java.lang.Integer(10)
        type lst = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Box[Char] :: Box[Int] :: Nil
        val lst: lst = Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Box(12) :: Nil
        val s: lst#take[_10] = lst.take(_10)
        val k: lst = s.force
        assertEquals(lst, k)
    }
}


object TakeTezt {
    import free.{ assert, assertSame }

    trait testTrivial {
        type lst = Box[Int] :: Box[String] :: Box[Double] :: Box[Char] :: Box[Float] :: Nil
        assertSame[Nil, lst#take[_0]#force]
        assertSame[Box[Int] :: Box[String] :: Nil, lst#take[_2]#force]
        assertSame[Box[Int] :: Box[String] :: Box[Double] :: Box[Char] :: Box[Float] :: Nil, lst#take[_5]#force]
    }
}
