

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import sing.Test._
import sing.Dense._
import scala.language.existentials
import junit.framework.{Assert => JAssert}


class NatLiteralTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
         val bs: bs = Nat_(5)
        type bs     = Nat_(5)
        assertSame(bs, _1B D_:: _0B D_:: _1B D_:: DNil)
        assertSame[bs, _1B D_:: _0B D_:: _1B D_:: DNil]
    }

    def testNil {
         val bs: bs = Nat_(0)
        type bs     = Nat_(0)
        assertSame(bs, DNil)
        assertSame[bs, DNil]
    }

    def testThrow {
        expectError {
            val bs = Nat_(-1)
        }

        expectError {
            dummy[ Nat_(-1) ]
        }
    }

    def testTrivial2 {
         val bs = Nat_(42)
         JAssert.assertEquals(42, bs.unsing)

         type n = Nat_(42)#plus[Nat_(10)]
         assertSame[Nat_(52), n]
    }
}
