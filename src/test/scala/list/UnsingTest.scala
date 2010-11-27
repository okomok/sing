

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._


class UnsingTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    assertFalse(scala.Nil eq Nil)

    def testTrivial {
        val i = new java.lang.Integer(10)
        type l = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Box[Char] :: Box[Int] :: Nil
        val l: l = Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Box(12) :: Nil

        val r: l#unsing = l.unsing
        val k: scala.collection.immutable.List[scala.Any] = r
        val nil: scala.collection.immutable.List[scala.Any] = scala.collection.immutable.Nil
        assertEquals(3 :: "hello" :: i :: 'a' :: 12 :: nil, k)
        ()
    }

    def testNil {
        type l = Nil
        val l: l = Nil
        val r: l#unsing = l.unsing
        val k: scala.collection.immutable.List[scala.Any] = r
        assertEquals(scala.collection.immutable.Nil, k)
        ()
    }
}

