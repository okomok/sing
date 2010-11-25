

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._


//import junit.framework.Assert._

//import boolean.Operator._


class AssertTest extends org.scalatest.junit.JUnit3Suite {

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
        free.assert[`true`]
        free.assertNot[`false`]
        free.assert[`true`# equal [`true`]]
        free.assertNot[`true`# nequal [`true`]]
    }

}
