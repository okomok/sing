

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import Peano.Literal._
import junit.framework.Assert._


class FoldTest extends org.scalatest.junit.JUnit3Suite {

    case class Plus() extends AsFunction2 {
        override type self = Plus
        override  def apply[x <: Any, y <: Any](x: x, y: y): apply[x, y] = x.asNat plus y.asNat
        override type apply[x <: Any, y <: Any] = x#asNat#plus[y#asNat]
    }

    case class Sub() extends AsFunction2 {
        override type self = Sub
        override  def apply[x <: Any, y <: Any](x: x, y: y): apply[x, y] = x.asNat minus y.asNat
        override type apply[x <: Any, y <: Any] = x#asNat# minus[y#asNat]
    }

    def testReduceLeft {
        type xs = _15 :: _1 :: _2 :: _3 :: _4 :: Nil
        val xs: xs = _15 :: _1 :: _2 :: _3 :: _4 :: Nil
        val u: xs#reduceLeft[Sub] = xs.reduceLeft(Sub())
        Test.assertEq[_5, xs#reduceLeft[Sub]]
        assertEquals(_5, u)
    }

    def testReduceRight {
        type xs = _1 :: _2 :: _3 :: _4 :: Nil
        val xs: xs = _1 :: _2 :: _3 :: _4 :: Nil
        val u: xs#reduceRight[Plus] = xs.reduceRight(Plus())
        Test.assertEq[_10, xs#reduceRight[Plus]]
        assertEquals(_10, u)
    }

    def testReduceRightRight {
        type xs = _15 :: _1 :: _2 :: _3 :: _4 :: Nil
        val xs: xs = _15 :: _1 :: _2 :: _3 :: _4 :: Nil
        try {
            val u: xs#reduceRight[Sub] = xs.reduceRight(Sub())
            fail("never come here")
        } catch {
            case _ : Throwable =>
        }
        ()
    }

}
