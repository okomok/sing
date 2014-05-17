

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._

import sing.Dense._
import scala.language.existentials
import junit.framework.{Assert => JAssert}
import sing.CompileError._


class NatLiteralTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val _bs = Nat_(5)
         val bs: bs = _bs.unwrap
        type bs     = _bs.unwrap
        AssertEq(bs, _1B D_:: _0B D_:: _1B D_:: DNil)
        AssertEq[bs, _1B D_:: _0B D_:: _1B D_:: DNil]
    }

    def testNil {
        val _bs = Nat_(0)
         val bs: bs = _bs.unwrap
        type bs     = _bs.unwrap
        AssertEq(bs, DNil)
        AssertEq[bs, DNil]
    }

    def testThrow {
        ExpectError(IllegalArgument) {"""
            val bs = Nat_(-1).apply
        """}
/*
        ExpectError(IllegalArgument) {
            dummy[ Nat_(-1) ]
        }
*/
    }

    def testTrivial2 {
         val _bs = Nat_(42)
         val  bs: bs = _bs.unwrap
         type bs     = _bs.unwrap
         JAssert.assertEquals(42, bs.unsing)

         val _Nat10 = Nat_(10)
         type n = bs#plus[_Nat10.unwrap]
         val _Nat52 = Nat_(52)
         AssertEq[_Nat52.unwrap, n]
    }
}
