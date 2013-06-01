

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._
import Peg.fromList


class FromListTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = _3 :: _5 :: _9 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]
        val p: p = fromList(_3 :: _5 :: _9 :: Nil)
        type r = p#matches[xs]
        val r: r = p.matches(xs)
        Weak.assert[r]
        assertTrue(r.unsing)
    }

    def testParse {
        type xs    = _3 :: _5 :: _9 :: _1 :: _4 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: _1 :: _4 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]
        val p: p = fromList(_3 :: _5 :: _9 :: Nil)
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Weak.assert[r#successful]
        assertTrue(r.successful.unsing)
        Weak.assertSame[_3 :: _5 :: _9 :: Nil, r#get#force]
        assertEquals(_3 :: _5 :: _9 :: Nil, r.get)
        Weak.assertSame[_1 :: _4 :: Nil, r#next#force]
        assertEquals(_1 :: _4 :: Nil, r.next)
    }

    def testParseFail {
        type xs    = _3 :: _5 :: _9 :: _1 :: _4 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: _1 :: _4 :: Nil
        type p   = fromList[_3 :: _5 :: _2 :: Nil]
        val p: p = fromList(_3 :: _5 :: _2 :: Nil)
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Weak.assertNot[r#successful]
        assertFalse(r.successful.unsing)
        Weak.assertSame[xs, r#next#force]
        assertEquals(xs, r.next)
    }

    def testNilNil {
        type xs    = Nil
        val xs: xs = Nil
        type p   = fromList[Nil]
        val p: p = fromList(Nil)
        type r = p#matches[xs]
        val r: r = p.matches(xs)
        Weak.assert[r]
        assertTrue(r.unsing)
    }

    def testNil {
        type xs    = _3 :: _5 :: _9 :: _1 :: _4 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: _1 :: _4 :: Nil
        type p   = fromList[Nil]
        val p: p = fromList(Nil)
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Weak.assert[r#successful]
        assertTrue(r.successful.unsing)
        Weak.assertSame[Nil, r#get#force]
        assertEquals(Nil, r.get)
        Weak.assertSame[xs, r#next#force]
        assertEquals(xs, r.next)
    }
}
