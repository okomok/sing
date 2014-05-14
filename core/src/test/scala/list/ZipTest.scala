

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._


class ZipTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testTrivial {
        val i = new java.lang.Integer(10)
        type l1 = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: Nil
        val l1: l1 = _Box(3) :: _Box("hello") :: _Box(i) :: Nil

        type l2 = _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: Nil
        val l2: l2 = _Box(i) :: _Box('a') :: _Box(12) :: Nil

        val _z: l1#zip[l2] = l1.zip(l2)
        val z: Tuple2[_Box[Int], _Box[java.lang.Integer]] :: Tuple2[_Box[String], _Box[Char]] :: Tuple2[_Box[java.lang.Integer], _Box[Int]] :: Nil = _z.force

        val a = Tuple2(_Box(3), _Box(i)) :: Tuple2(_Box("hello"), _Box('a')) :: Tuple2(_Box(i), _Box(12)) :: Nil
        assertEquals(a, z)
    }

    def testNil {
        type l1 = Nil
        val l1: l1 = Nil

        type l2 = Nil
        val l2: l2 = Nil

        val _z: l1#zip[l2] = l1.zip(l2)
        val z: Nil = _z.force

        val a = Nil
        assertEquals(a, z)
    }

    def testLonger {
        val i = new java.lang.Integer(10)
        type l1 = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: Nil
        val l1: l1 = _Box(3) :: _Box("hello") :: _Box(i) :: Nil

        type l2 = _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: _Box[String] :: Nil
        val l2: l2 = _Box(i) :: _Box('a') :: _Box(12) :: _Box("ignored") :: Nil

        val _z: l1#zip[l2] = l1.zip(l2)
        val z: Tuple2[_Box[Int], _Box[java.lang.Integer]] :: Tuple2[_Box[String], _Box[Char]] :: Tuple2[_Box[java.lang.Integer], _Box[Int]] :: Nil = _z.force

        val a = Tuple2(_Box(3), _Box(i)) :: Tuple2(_Box("hello"), _Box('a')) :: Tuple2(_Box(i), _Box(12)) :: Nil
        assertEquals(a, z)
    }

    def testShorter {
        val i = new java.lang.Integer(10)
        type l1 = _Box[Int] :: _Box[String] :: _Box[java.lang.Integer] :: Nil
        val l1: l1 = _Box(3) :: _Box("hello") :: _Box(i) :: Nil

        type l2 = _Box[java.lang.Integer] :: _Box[Char] :: _Box[Int] :: _Box[String] :: Nil
        val l2: l2 = _Box(i) :: _Box('a') :: _Box(12) :: _Box("ignored") :: Nil

        val _z: l2#zip[l1] = l2.zip(l1)
        val z: Tuple2[_Box[java.lang.Integer], _Box[Int]] :: Tuple2[_Box[Char], _Box[String]] :: Tuple2[_Box[Int], _Box[java.lang.Integer]] :: Nil = _z.force

        val a = Tuple2(_Box(i), _Box(3)) :: Tuple2(_Box('a'), _Box("hello")) :: Tuple2(_Box(12), _Box(i)) :: Nil
        assertEquals(a, z)
    }
}
