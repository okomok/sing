

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
         val bs: bs = binary("101")
        type bs     = binary("101")
        assertSame(bs, _1B D_:: _0B D_:: _1B D_:: DNil)
        assertSame[bs, _1B D_:: _0B D_:: _1B D_:: DNil]
    }

    def testNil {
         val bs: bs = binary("")
        type bs     = binary("")
        assertSame(bs, DNil)
        assertSame[bs, DNil]

         val bs_ : bs = binary("00")
        type bs_      = binary("00")
        assertSame(bs_, DNil)
        assertSame[bs_, DNil]
    }

    def testTrailingZero {
         val bs: bs = binary("000101")
        type bs     = binary("000101")
        assertSame(bs, _1B D_:: _0B D_:: _1B D_:: DNil)
        assertSame[bs, _1B D_:: _0B D_:: _1B D_:: DNil]
    }

    def testThrow {
        expectError {
            val bs = binary("a0")
        }

        expectError {
            unused[ binary("a0") ]
        }
    }

    def testTrivial2 {
         val bs = binary("101010")
         JAssert.assertEquals(42, bs.unsing)
    }
}
