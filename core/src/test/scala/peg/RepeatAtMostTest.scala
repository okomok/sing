

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._
import peg.term


class RepeatAtMostTest extends org.scalatest.junit.JUnit3Suite {

    def testNilInput {
        type xs    = Nil
        val xs: xs = Nil
        type p   = term[_1]#repeat[_0, _0]
        val p: p = term(_1).repeat(_0, _0)
        type r = p#matches[xs]
        val r: r = p.matches(xs)
        free.assert[r]
        assertTrue(r.unsing)
    }

    def testTrivial {
        type xs    = _1 :: _1 :: _1 :: _1 :: _3 :: Nil
        val xs: xs = _1 :: _1 :: _1 :: _1 :: _3 :: Nil
        type p   = term[_1]#repeat[_0, _3]
        val p: p = term(_1).repeat(_0, _3)
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        free.assert[r#successful]
        assertTrue(r.successful.unsing)
        free.assertSame[_1 :: _1 :: _1 :: Nil, r#get#force]
        assertEquals(_1 :: _1 :: _1 :: Nil, r.get)
        free.assertSame[_1 :: _3 :: Nil, r#next#force]
        assertEquals(_1 :: _3 :: Nil, r.next)
    }

    def testAlwaysSuccess {
        type xs    = _4 :: _1 :: _1 :: _1 :: _3 :: Nil
        val xs: xs = _4 :: _1 :: _1 :: _1 :: _3 :: Nil
        type p   = term[_1]#repeat[_0, _3]
        val p: p = term(_1).repeat(_0, _3)
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        free.assert[r#successful]
        assertTrue(r.successful.unsing)
        free.assertSame[Nil, r#get#force]
        assertEquals(Nil, r.get)
        free.assertSame[xs, r#next#force]
        assertEquals(xs, r.next)
    }

}
