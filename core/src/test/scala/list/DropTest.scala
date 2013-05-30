

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._


class DropTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testTrivial {
        val i = new java.lang.Integer(10)
        val lst = Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Box(12) :: Nil
        val a = Box(i) :: Box('a') :: Box(12) :: Nil
        val s = lst.drop(_0)
        val b: Box[java.lang.Integer] :: Box[Char] :: Box[Int] :: Nil = lst.drop(_2).force
        val c = lst.drop(_5)
        assertEquals(a, b)
        assertEquals(Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Box(12) :: Nil, s)
        assertEquals(Box(i) :: Box('a') :: Box(12) :: Nil, b)
        assertEquals(Nil, c)
    }

    def testTooMany {
        val i = new java.lang.Integer(10)
        type lst = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Box[Char] :: Box[Int] :: Nil
        val lst: lst = Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Box(12) :: Nil
        val s: lst#drop[_10#plus[_10]] = lst.drop(_10 plus _10)
        val k: Nil = s.force
        ()
    }
}


object DropTezt {
    import free.{ assert, assertSame }

    trait testTrivial {
        type lst = Box[Int] :: Box[String] :: Box[Double] :: Box[Char] :: Box[Float] :: Nil
        assertSame[Box[Int] :: Box[String] :: Box[Double] :: Box[Char] :: Box[Float] :: Nil, lst#drop[_0]#force]
        assertSame[Box[Double] :: Box[Char] :: Box[Float] :: Nil, lst#drop[_2]#force]
        assertSame[Nil, lst#drop[_5]#force]
        assertSame[Nil, lst#drop[_10]#force]
    }
}
