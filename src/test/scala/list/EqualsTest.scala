

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._


class EqualsTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testTrivial {
        type l = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Nil
        val l1: l = Box(3) :: Box("hello") :: Box(new java.lang.Integer(10)) :: Nil
        val l2: l = Box(3) :: Box("hello") :: Box(new java.lang.Integer(10)) :: Nil
        val l3 = Box(3) :: Box("helll") :: Box(new java.lang.Integer(10)) :: Nil
        val l4 = Box(3) :: Box("hello") :: Box(new java.lang.Integer(10)) :: Box(2.0) :: Nil

        assertEquals(l2, l1)
        AssertNotEquals(Nil, l1)
        assertEquals(Nil, Nil)
        AssertNotEquals(l3, l1)
        AssertNotEquals(l4, l1)
    }
}
