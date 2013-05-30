

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._


class STupleTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testFrom {
        val t: (Int, String, java.lang.Integer) = (3, "hello", new java.lang.Integer(10))

        type l = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Nil
        val l: l = list.fromSTuple(t)

        assertSame(t._2, l.nth(_1).unsing)
    }

    def testTo {
        type l = Box[Int] :: Box[String] :: Box[java.lang.Integer] :: Nil
        val l: l = Box(3) :: Box("hello") :: Box(new java.lang.Integer(10)) :: Nil

        val t: (Int, String, java.lang.Integer) = l.toSTuple

        assertSame(t._2, l.nth(_1).unsing)
    }
}
