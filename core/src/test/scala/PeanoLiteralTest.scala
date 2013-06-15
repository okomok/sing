

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import sing.Test._
import scala.language.existentials
import junit.framework.{Assert => JAssert}


class PeanoLiteralTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
         val bs: bs = Peano_(3)
        type bs     = Peano_(3)
        assertSame(bs, Succ(Succ(Succ(Zero))))
        assertSame[bs, Succ[Succ[Succ[Zero]]]]
    }

    def testNil {
         val bs: bs = Peano_(0)
        type bs     = Peano_(0)
        assertSame(bs, Zero)
        assertSame[bs, Zero]
    }

    def testThrow {
        expectError {
            val bs = Peano_(-1)
        }

        expectError {
            unused[ Peano_(-1) ]
        }
    }

    def testTrivial2 {
         val bs = Peano_(42)
         JAssert.assertEquals(42, bs.unsing)
    }
}
