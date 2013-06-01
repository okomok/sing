

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._


class EqualsTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testTrivial {
        type l = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: Nil
        val l1: l = _Box(3) :: _Box("hello") :: _Box(new java.lang.Integer(10)) :: Nil
        val l2: l = _Box(3) :: _Box("hello") :: _Box(new java.lang.Integer(10)) :: Nil
        val l3 = _Box(3) :: _Box("helll") :: _Box(new java.lang.Integer(10)) :: Nil
        val l4 = _Box(3) :: _Box("hello") :: _Box(new java.lang.Integer(10)) :: _Box(2.0) :: Nil

        assertEquals(l2, l1)
        AssertNotEquals(Nil, l1)
        assertEquals(Nil, Nil)
        AssertNotEquals(l3, l1)
        AssertNotEquals(l4, l1)
    }
}
