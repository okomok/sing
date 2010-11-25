

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._


class InitTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    assertFalse(scala.Nil eq Nil)


    trait testMeta {
        type initInit[l <: List] = l#init#init
        type l = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Box[Char] :: Box[Int] :: Nil
        free.assertSame[Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Nil, initInit[l]#force]
    }

    def testTrivial {
        val i = new java.lang.Integer(10)
        type l = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Box[Char] :: Box[Int] :: Nil
        val l: l = Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Box(12) :: Nil

        val li: l#init = l.init
        val lii: Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Box[Char] :: Nil = li.force
        val A = Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Nil
        assertEquals(A, lii)
    }

    def testTrivial2 {
        val i = new java.lang.Integer(10)
        type l = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Box[Char] :: Nil
        val l: l = Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Nil

        val li: l#init = l.init
        val lii: Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Nil = li.force
        val A = Box(3) :: Box("hello") :: Box(i) :: Nil
        assertEquals(A, lii)
    }

    def testOne {
        type l = Box[Int] :: Nil
        val l: l = Box(12) :: Nil

        val li: l#init = l.init
        val lii: Nil = li.force
        assertSame(Nil, lii)
    }
}
