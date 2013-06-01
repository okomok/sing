

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._
import peg.fromList


class AndTest extends org.scalatest.junit.JUnit3Suite {

    def testFail1 {
        type xs    = Nil
        val xs: xs = Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#and
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).and
        type r = p#matches[xs]
        val r: r = p.matches(xs)
        Weak.assertNot[r]
        assertFalse(r.unsing)
    }

    def testFail2 {
        type xs    = _4 :: _3 :: _5 :: _9 :: Nil
        val xs: xs = _4 :: _3 :: _5 :: _9 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#and
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).and
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Weak.assertNot[r#successful]
        assertFalse(r.successful.unsing)
        Weak.assertSame[xs, r#next]
        assertEquals(xs, r.next)
    }

    def testNoConsume1 {
        type xs    = _3 :: _5 :: _9 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#and
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).and
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Weak.assert[r#successful]
        assertTrue(r.successful.unsing)
        Weak.assertSame[xs, r#get#force]
        assertEquals(xs, r.get)
        Weak.assertSame[xs, r#next]
        assertEquals(xs, r.next)
    }

    def testNoConsume2 {
        type xs    = _3 :: _5 :: _9 :: _4 :: _1 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: _4 :: _1 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#and
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).and
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Weak.assert[r#successful]
        assertTrue(r.successful.unsing)
        Weak.assertSame[_3 :: _5 :: _9 :: Nil, r#get#force]
        assertEquals(_3 :: _5 :: _9 :: Nil, r.get)
        Weak.assertSame[xs, r#next]
        assertEquals(xs, r.next)
    }

}
