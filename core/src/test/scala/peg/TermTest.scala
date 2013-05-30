

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._
import peg.term


class TermTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = _3 :: Nil
        val xs: xs = _3 :: Nil
        type r = term[_3]#matches[xs]
        val r: r = term(_3).matches(xs)
        free.assert[r]
        assertTrue(r.unsing)
    }

    def testTrivial2 {
        type xs    = _7 :: Nil
        val xs: xs = _7 :: Nil
        type r = term[_3]#matches[xs]
        val r: r = term(_3).matches(xs)
        free.assertNot[r]
        assertFalse(r.unsing)
    }

    def testFail {
        type xs    = Nil
        val xs: xs = Nil
        type r = term[_5]#matches[xs]
        val r: r = term(_5).matches(xs)
        free.assertNot[r]
        assertFalse(r.unsing)
    }

    def testParse {
        type xs    = _3 :: _5 :: _6 :: Nil
        val xs: xs = _3 :: _5 :: _6 :: Nil
        type r = term[_3]#parse[xs]
        val r: r = term(_3).parse(xs)
        free.assert[r#successful]
        free.assertSame[_3, r#get]
        free.assertSame[_5 :: _6 :: Nil, r#next#force]
        assertEquals(_3, r.get)
        assertEquals(_5 :: _6 :: Nil, r.next)
    }

    def testParseFail {
        type xs    = _3 :: _5 :: _6 :: Nil
        val xs: xs = _3 :: _5 :: _6 :: Nil
        type r = term[_2]#parse[xs]
        val r: r = term(_2).parse(xs)
        free.assertNot[r#successful]
        free.assertSame[_3 :: _5 :: _6 :: Nil, r#next#force]
        assertEquals(_3 :: _5 :: _6 :: Nil, r.next)
    }

}
