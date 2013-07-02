

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package listtest


import com.github.okomok

import okomok.sing._
import Peano.Literal._


class TakeTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testTrivial {
        val i = new java.lang.Integer(10)
        val lst = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil
        val a = lst.take(_0)
        val b: _Box[Int] :: _Box[String] :: Nil = lst.take(_2).force
        val c = lst.take(_5)
        assertEquals(Nil, a)
        assertEquals(_Box(3) :: _Box("hello") :: Nil, b)
        assertEquals(_Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil, c)
    }

    def testTooMany {
        val i = new java.lang.Integer(10)
        type lst = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil
        val lst: lst = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil
        val s: lst#take[_10] = lst.take(_10)
        val k: lst = s.force
        assertEquals(lst, k)
    }
}


object TakeTezt {
    import Test.assertEq

    trait testTrivial {
        type lst = _Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: _Box[Float] :: Nil
        assertEq[Nil, lst#take[_0]#force]
        assertEq[_Box[Int] :: _Box[String] :: Nil, lst#take[_2]#force]
        assertEq[_Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: _Box[Float] :: Nil, lst#take[_5]#force]
    }
}
