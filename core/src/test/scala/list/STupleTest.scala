

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import Peano.Literal._
import scala.language.existentials


class STupleTest extends org.scalatest.junit.JUnit3Suite {
    import junit.framework.Assert._
    // assertFalse(scala.Nil eq Nil)

    def testFrom {
        val t: (Int, String, java.lang.Integer) = (3, "hello", new java.lang.Integer(10))
        val l = List.fromSTuple(t)

        assertSame(t._2, l.nth(_1).unsing)
    }

    def testTo {
        val l = Box(3) :: Box("hello") :: Box(new java.lang.Integer(10)) :: Nil

        val t: (Int, String, java.lang.Integer) = l.toSTuple

        assertSame(t._2, l.nth(_1).unsing)
    }
}
