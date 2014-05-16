

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._

import sing.Dense._
import scala.language.existentials
import junit.framework.{Assert => JAssert}
import sing.CompileError._


class BinaryLiteralTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val _bs = Binary_("101")
         val bs: bs = _bs.apply
        type bs     = _bs.apply
        AssertEq(bs, _1B D_:: _0B D_:: _1B D_:: DNil)
        AssertEq[bs, _1B D_:: _0B D_:: _1B D_:: DNil]
    }

    def testNil {
        val _bs = Binary_("")
         val bs: bs = _bs.apply
        type bs     = _bs.apply
        AssertEq(bs, DNil)
        AssertEq[bs, DNil]

        val _bs_ = Binary_("00")
         val bs_ : bs_ = _bs_.apply
        type bs_       = _bs_.apply
        AssertEq(bs_, DNil)
        AssertEq[bs_, DNil]
    }

    def testTrailingZero {
        val _bs = Binary_("000101")
         val bs: bs = _bs.apply
        type bs     = _bs.apply
        AssertEq(bs, _1B D_:: _0B D_:: _1B D_:: DNil)
        AssertEq[bs, _1B D_:: _0B D_:: _1B D_:: DNil]
    }

    def testThrow {
        ExpectError(IllegalArgument) {"""
            val bs = Binary_("a0")
        """}
/*
        ExpectError(IllegalArgument) {
            dummy[ Binary_("a0") ]
        }
*/
    }

    def testTrivial2 {
         val bs = Binary_("101010").apply
         JAssert.assertEquals(42, bs.unsing)
    }
}
