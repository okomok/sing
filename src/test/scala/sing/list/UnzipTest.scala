

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._


class UnzipTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    assertFalse(scala.Nil eq Nil)

    def testTrivial {
        val i = new java.lang.Integer(10)

        type l1 = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Nil
        val l1: l1 = Box(3) :: Box("hello") :: Box(i) :: Nil

        type l2 = Box[java.lang.Integer] :: Box[Char] :: Box[Int] :: Nil
        val l2: l2 = Box(i) :: Box('a') :: Box(12) :: Nil

        type z = l1#zip[l2]
        val z: z = l1.zip(l2)
        free.assertSame[Tuple2[Box[Int], Box[java.lang.Integer]] :: Tuple2[Box[String], Box[Char]] :: Tuple2[Box[java.lang.Integer], Box[Int]] :: Nil, z#force]

        type k = z#unzip
        val k: k = z.unzip
        free.assertSame[Tuple2[Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Nil, Box[java.lang.Integer] :: Box[Char] :: Box[Int] :: Nil], list.force2[k]]

        assertEquals(l1, k._1)
        assertEquals(l2, k._2)
    }

    def testNil {
        type l1 = Nil
        val l1: l1 = Nil

        type l2 = Nil
        val l2: l2 = Nil

        type z = l1#zip[l2]
        val z: z = l1.zip(l2)
        free.assertSame[Nil, z#force]

        type k = z#unzip
        val k: k = z.unzip
        free.assertSame[Tuple2[Nil, Nil], list.force2[k]]

        assertEquals(Tuple2(Nil, Nil), k)
    }
}
