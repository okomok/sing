

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import sing.Test._
import scala.language.existentials
import junit.framework.{Assert => JAssert}
import sing.Test.CompileError._


class PeanoLiteralTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val _bs = Peano_(3)
         val bs: bs = _bs.self
        type bs     = _bs.self
        assertEq(bs, Succ(Succ(Succ(Zero))))
        assertEq[bs, Succ[Succ[Succ[Zero]]]]
    }

    def testNil {
        val _bs = Peano_(0)
         val bs: bs = _bs.self
        type bs     = _bs.self
        assertEq(bs, Zero)
        assertEq[bs, Zero]
    }

    def testThrow {
        expectError(IllegalArgument) {"""
            val bs = Peano_(-1)
        """}
/*
        expectError(IllegalArgument) {
            dummy[ Peano_(-1) ]
        }
*/
    }

    def testTrivial2 {
         val bs = Peano_(42).self
         JAssert.assertEquals(42, bs.unsing)
    }
}
