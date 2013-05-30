

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._
import peg.dot


class DotTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = _3 :: Nil
        val xs: xs = _3 :: Nil
        type r = dot#matches[xs]
        val r: r = dot.matches(xs)
        free.assert[r]
        assertTrue(r.unsing)
    }

    def testTrivial2 {
        type xs    = _7 :: Nil
        val xs: xs = _7 :: Nil
        type r = dot#matches[xs]
        val r: r = dot.matches(xs)
        free.assert[r]
        assertTrue(r.unsing)
    }

    def testFail {
        type xs    = Nil
        val xs: xs = Nil
        type r = dot#matches[xs]
        val r: r = dot.matches(xs)
        free.assert[r#not]
        assertFalse(r.unsing)
    }

    def testParse {
        type xs    = _3 :: _5 :: _6 :: Nil
        val xs: xs = _3 :: _5 :: _6 :: Nil
        type r = dot#parse[xs]
        val r: r = dot.parse(xs)
        free.assert[r#successful]
        free.assertSame[_3, r#get]
        free.assertSame[_5 :: _6 :: Nil, r#next#force]
        assertEquals(_3, r.get)
        assertEquals(_5 :: _6 :: Nil, r.next)
    }

}
