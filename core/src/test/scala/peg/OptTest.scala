

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._
import peg.fromList


class OptTest extends org.scalatest.junit.JUnit3Suite {

    def testNilInput {
        type xs    = Nil
        val xs: xs = Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#opt
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).opt
        type r = p#matches[xs]
        val r: r = p.matches(xs)
        weak.assert[r]
        assertTrue(r.unsing)
    }

    def testOneInput {
        type xs    = _3 :: _5 :: _9 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#opt
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).opt
        type r = p#matches[xs]
        val r: r = p.matches(xs)
        weak.assert[r]
        assertTrue(r.unsing)
    }

    def testParseNoConsume {
        type xs    = _4 :: _3 :: _5 :: _9 :: Nil
        val xs: xs = _4 :: _3 :: _5 :: _9 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#opt
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).opt
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        weak.assert[r#successful]
        assertTrue(r.successful.unsing)
        weak.assertSame[None, r#get]
        assertEquals(None, r.get)
        weak.assertSame[xs, r#next]
        assertEquals(xs, r.next)
    }

    def testParseConsume {
        type xs    = _3 :: _5 :: _9 :: _10 :: _11 :: Nil
        val xs: xs = _3 :: _5 :: _9 :: _10 :: _11 :: Nil
        type p   = fromList[_3 :: _5 :: _9 :: Nil]#opt
        val p: p = fromList(_3 :: _5 :: _9 :: Nil).opt
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        weak.assert[r#successful]
        assertTrue(r.successful.unsing)
        weak.assertSame[Some[_3 :: _5 :: _9 :: Nil], r#get]
        assertEquals(Some(_3 :: _5 :: _9 :: Nil), r.get)
        weak.assertSame[_10 :: _11 :: Nil, r#next]
        assertEquals(_10 :: _11 :: Nil, r.next)
    }

}
