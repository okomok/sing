

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import Peano.Literal._


class SliceTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testSlice {
        val i = new java.lang.Integer(10)

        type Lst1 = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil
        val lst1: Lst1 = _Box(3) :: _Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil;

        type Lst2 = _Box[String] :: Nil
        val lst2: Lst2 = _Box("hello") :: Nil;

        type Lst3 = Nil
        val lst3: Lst3 = Nil;
        {
            val e: Lst1#slice[_0, _2] = lst1.slice(_0, _2)
            val e_ : _Box[Int]::_Box[String]::Nil = e.force
            assertEquals(_Box(3)::_Box("hello")::Nil, e_)
        }

        {
            val e: Lst1#slice[_1, _5] = lst1.slice(_1, _5)
            val e_ : _Box[String] :: _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil = e.force
            assertEquals(_Box("hello") :: _Box(i) :: _Box('a') :: _Box(12) :: Nil, e_)
        }

        {
            val e: Lst1#slice[_2, _4] = lst1.slice(_2, _4)
            val e_ : _Box[java.lang.Integer] :: _Box[Char] :: Nil = e.force
            assertEquals(_Box(i) :: _Box('a') :: Nil, e_)
        }
        {
            val e: Lst2#slice[_0, _0] = lst2.slice(_0, _0)
            val e_ : Nil = e.force
            assertEquals(Nil, e_)
        }
        {
            val e: Lst2#slice[_0, _1] = lst2.slice(_0, _1)
            val e_ : _Box[String] :: Nil = e.force
            assertEquals(_Box("hello") :: Nil, e_)
        }

        {
            val e: Lst2#slice[_0, _0] = lst2.slice(_0, _0)
            val e_ : Nil = e.force
            assertEquals(Nil, e_)
        }
        ()
    }
}


object SliceTezt {
    trait testSlice {
        type lst = _Box[Int] :: _Box[String] :: _Box[Double] :: _Box[Char] :: _Box[Float] :: Nil
        AssertEq[Nil, lst#slice[_2, _2]#force]
        AssertEq[_Box[String] :: _Box[Double] :: _Box[Char] :: Nil, lst#slice[_1, _4]#force]
    }
}
