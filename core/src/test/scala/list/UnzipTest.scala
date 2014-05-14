

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._


class UnzipTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testTrivial {
        val i = new java.lang.Integer(10)

        type l1 = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: Nil
        val l1: l1 = _Box(3) :: _Box("hello") :: _Box(i) :: Nil

        type l2 = _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil
        val l2: l2 = _Box(i) :: _Box('a') :: _Box(12) :: Nil

        type z = l1#zip[l2]
        val z: z = l1.zip(l2)
        Test.assertEq[Tuple2[_Box[Int], _Box[java.lang.Integer]] :: Tuple2[_Box[String], _Box[Char]] :: Tuple2[_Box[java.lang.Integer], _Box[Int]] :: Nil, z#force]

        type k = z#unzip
        val k: k = z.unzip
        Test.assertEq[Tuple2[_Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: Nil, _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil], List.force2[k]]

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
        Test.assertEq[Nil, z#force]

        type k = z#unzip
        val k: k = z.unzip
        Test.assertEq[Tuple2[Nil, Nil], List.force2[k]]

        assertEquals(Tuple2(Nil, Nil), k)
    }
}
