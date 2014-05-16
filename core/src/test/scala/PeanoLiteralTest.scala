

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._

import scala.language.existentials
import junit.framework.{Assert => JAssert}
import sing.CompileError._


class PeanoLiteralTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val _bs = Peano_(3)
         val bs: bs = _bs.apply
        type bs     = _bs.apply
        AssertEq(bs, Succ(Succ(Succ(Zero))))
        AssertEq[bs, Succ[Succ[Succ[Zero]]]]
    }

    def testNil {
        val _bs = Peano_(0)
         val bs: bs = _bs.apply
        type bs     = _bs.apply
        AssertEq(bs, Zero)
        AssertEq[bs, Zero]
    }

    def testThrow {
        ExpectError(IllegalArgument) {"""
            val bs = Peano_(-1)
        """}
/*
        ExpectError(IllegalArgument) {
            dummy[ Peano_(-1) ]
        }
*/
    }

    def testTrivial2 {
         val bs = Peano_(42).apply
         JAssert.assertEquals(42, bs.unsing)
    }
}
