

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import sing.Test._
import sing.Dense._
import scala.language.existentials
import junit.framework.{Assert => JAssert}


class BinaryLiteralTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
         val bs: bs = Binary_("101")
        type bs     = Binary_("101")
        assertSame(bs, _1B D_:: _0B D_:: _1B D_:: DNil)
        assertSame[bs, _1B D_:: _0B D_:: _1B D_:: DNil]
    }

    def testNil {
         val bs: bs = Binary_("")
        type bs     = Binary_("")
        assertSame(bs, DNil)
        assertSame[bs, DNil]

         val bs_ : bs = Binary_("00")
        type bs_      = Binary_("00")
        assertSame(bs_, DNil)
        assertSame[bs_, DNil]
    }

    def testTrailingZero {
         val bs: bs = Binary_("000101")
        type bs     = Binary_("000101")
        assertSame(bs, _1B D_:: _0B D_:: _1B D_:: DNil)
        assertSame[bs, _1B D_:: _0B D_:: _1B D_:: DNil]
    }

    def testThrow {
        expectError {
            val bs = Binary_("a0")
        }

        expectError {
            dummy[ Binary_("a0") ]
        }
    }

    def testTrivial2 {
         val bs = Binary_("101010")
         JAssert.assertEquals(42, bs.unsing)
    }
}
