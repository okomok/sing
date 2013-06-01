

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._
import Peg.fromList


class NotTest extends org.scalatest.junit.JUnit3Suite {

    def testNil {
        type xs    = Nil
        val xs: xs = Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#not
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).not
        type r = p#matches[xs]
        val r: r = p.matches(xs)
        Weak.assert[r]
        assertTrue(r.unsing)
    }

    def testTrivial {
        type xs    = _4 :: _3 :: _5 :: _9 :: Nil
        val xs: xs = _4 :: _3 :: _5 :: _9 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#not
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).not
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Weak.assert[r#successful]
        assertTrue(r.successful.unsing)
        Weak.assertSame[Nil, r#get#force]
        assertEquals(Nil, r.get)
        Weak.assertSame[xs, r#next]
        assertEquals(xs, r.next)
    }

    def testFail {
        type xs    = _3 :: _5 :: _9 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#not
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).not
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Weak.assertNot[r#successful]
        assertFalse(r.successful.unsing)
        Weak.assertSame[xs, r#next]
        assertEquals(xs, r.next)
    }

    def testFail2 {
        type xs    = _3 :: _5 :: _9 :: _4 :: _1 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: _4 :: _1 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#not
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).not
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Weak.assertNot[r#successful]
        assertFalse(r.successful.unsing)
        Weak.assertSame[xs, r#next]
        assertEquals(xs, r.next)
    }

    def testNilNil {
        type xs    = Nil
        val xs: xs = Nil
        type p   = fromList[Nil]#not
        val p: p = fromList(Nil).not
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Weak.assertNot[r#successful]
        assertFalse(r.successful.unsing)
    }

}
