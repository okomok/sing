

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package listtest


import com.github.okomok

import okomok.sing._
import Peano.Literal._


class DropTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testTrivial {
        val i = new java.lang.Integer(10)
        val lst = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil
        val a = _Box(i) :: _Box('a') :: _Box(12) :: Nil
        val s = lst.drop(_0)
        val b: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil = lst.drop(_2).force
        val c = lst.drop(_5)
        assertEquals(a, b)
        assertEquals(_Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil, s)
        assertEquals(_Box(i) :: _Box('a') :: _Box(12) :: Nil, b)
        assertEquals(Nil, c)
    }

    def testTooMany {
        val i = new java.lang.Integer(10)
        type lst = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil
        val lst: lst = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil
        val s: lst#drop[_10#plus[_10]] = lst.drop(_10 plus _10)
        val k: Nil = s.force
        ()
    }
}


object DropTezt {
    import Test.assertEq

    trait testTrivial {
        type lst = _Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: _Box[Float] :: Nil
        assertEq[_Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: _Box[Float] :: Nil, lst#drop[_0]#force]
        assertEq[_Box[Double] :: _Box[Char] :: _Box[Float] :: Nil, lst#drop[_2]#force]
        assertEq[Nil, lst#drop[_5]#force]
        assertEq[Nil, lst#drop[_10]#force]
    }
}
