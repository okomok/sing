

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._


class SliceTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    assertFalse(scala.Nil eq Nil)

    def testSlice {
        val i = new java.lang.Integer(10)

        type Lst1 = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Box[Char] :: Box[Int] :: Nil
        val lst1: Lst1 = Box(3) :: Box("hello") :: Box(i) :: Box('a') :: Box(12) :: Nil;

        type Lst2 = Box[String] :: Nil
        val lst2: Lst2 = Box("hello") :: Nil;

        type Lst3 = Nil
        val lst3: Lst3 = Nil;
        {
            val e: Lst1#slice[_0, _2] = lst1.slice(_0, _2)
            val e_ : Box[Int]::Box[String]::Nil = e.force
            assertEquals(Box(3)::Box("hello")::Nil, e_)
        }

        {
            val e: Lst1#slice[_1, _5] = lst1.slice(_1, _5)
            val e_ : Box[String] :: Box[java.lang.Integer] :: Box[Char] :: Box[Int] :: Nil = e.force
            assertEquals(Box("hello") :: Box(i) :: Box('a') :: Box(12) :: Nil, e_)
        }

        {
            val e: Lst1#slice[_2, _4] = lst1.slice(_2, _4)
            val e_ : Box[java.lang.Integer] :: Box[Char] :: Nil = e.force
            assertEquals(Box(i) :: Box('a') :: Nil, e_)
        }
        {
            val e: Lst2#slice[_0, _0] = lst2.slice(_0, _0)
            val e_ : Nil = e.force
            assertEquals(Nil, e_)
        }
        {
            val e: Lst2#slice[_0, _1] = lst2.slice(_0, _1)
            val e_ : Box[String] :: Nil = e.force
            assertEquals(Box("hello") :: Nil, e_)
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
    import free.{ assert, assertSame }

    trait testSlice {
        type lst = Box[Int] :: Box[String] :: Box[Double] :: Box[Char] :: Box[Float] :: Nil
        assertSame[Nil, lst#slice[_2, _2]#force]
        assertSame[Box[String] :: Box[Double] :: Box[Char] :: Nil, lst#slice[_1, _4]#force]
    }
}
