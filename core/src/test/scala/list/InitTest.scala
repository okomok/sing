

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._


class InitTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)


    trait testMeta {
        type initInit[l <: List] = l#init#init
        type l = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil
        weak.assertSame[_Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: Nil, initInit[l]#force]
    }

    def testTrivial {
        val i = new java.lang.Integer(10)
        type l = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil
        val l: l = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil

        val li: l#init = l.init
        val lii: _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: Nil = li.force
        val A = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: Nil
        assertEquals(A, lii)
    }

    def testTrivial2 {
        val i = new java.lang.Integer(10)
        type l = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: Nil
        val l: l = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: Nil

        val li: l#init = l.init
        val lii: _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: Nil = li.force
        val A = _Box(3) :: _Box("hello") :: _Box(i) :: Nil
        assertEquals(A, lii)
    }

    def testOne {
        type l = _Box[Int] :: Nil
        val l: l = _Box(12) :: Nil

        val li: l#init = l.init
        val lii: Nil = li.force
        assertSame(Nil, lii)
    }
}
