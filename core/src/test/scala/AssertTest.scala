

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._


//import junit.framework.Assert._

//import boolean.Operator._


object _Assert {
      def apply[c <: Boolean](c: c): apply[c] = `if`(c, Const(Unit), Else(c)).apply
     type apply[c <: Boolean]                 = `if`[c, Const[Unit], Else[c]]#apply

     case class Else[c <: Boolean](c: c) extends AsFunction0 {
         override type self = Else[c]
         override  def apply: apply = throw new AssertionError("sing.assert")
         override type apply        = _Assert.apply[c]
     }
}

class AssertTest extends org.scalatest.junit.JUnit3Suite {

    type k = _Assert.apply[`true`]

    def testTrivial {
        okomok.sing.assert(`true`)
        try {
            okomok.sing.assert(`false`)
            fail("never come here")
        } catch {
            case _: AssertionError =>
        }
    }

    def testTrivial2 {
        okomok.sing.assert(`true` nequal `false`)
        try {
            okomok.sing.assert(`true` equal `false`)
            fail("never come here")
        } catch {
            case _: AssertionError =>
        }
    }
    def testNotTrivial {
        assertNot(`false`)
        try {
            assertNot(`true`)
            fail("never come here")
        } catch {
            case _: AssertionError =>
        }
    }

    def testNotTrivial2 {
        assertNot(`true` equal `false`)
        try {
            assertNot(`true` nequal `false`)
            fail("never come here")
        } catch {
            case _: AssertionError =>
        }
    }

    trait testMeta {
        AssertTrue[`true`]
        AssertFalse[`false`]
        AssertTrue[`true`# equal [`true`]]
        AssertFalse[`true`# nequal [`true`]]
    }

}
