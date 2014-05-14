

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import sing.Test._
import sing.Dense._
import scala.language.existentials
import junit.framework.{Assert => JAssert}
import sing.Test.CompileError._


class NatLiteralTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val _bs = Nat_(5)
         val bs: bs = _bs.self
        type bs     = _bs.self
        assertEq(bs, _1B D_:: _0B D_:: _1B D_:: DNil)
        assertEq[bs, _1B D_:: _0B D_:: _1B D_:: DNil]
    }

    def testNil {
        val _bs = Nat_(0)
         val bs: bs = _bs.self
        type bs     = _bs.self
        assertEq(bs, DNil)
        assertEq[bs, DNil]
    }

    def testThrow {
        expectError(IllegalArgument) {"""
            val bs = Nat_(-1).self
        """}
/*
        expectError(IllegalArgument) {
            dummy[ Nat_(-1) ]
        }
*/
    }

    def testTrivial2 {
         val _bs = Nat_(42)
         val  bs: bs = _bs.self
         type bs     = _bs.self
         JAssert.assertEquals(42, bs.unsing)

         val _Nat10 = Nat_(10)
         type n = bs#plus[_Nat10.self]
         val _Nat52 = Nat_(52)
         assertEq[_Nat52.self, n]
    }
}
