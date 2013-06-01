

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._
import peg.eps


class EpsTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = Nil
        val xs: xs = Nil
        type r = eps#matches[xs]
        val r: r = eps.matches(xs)
        Weak.assert[r]
        assertTrue(r.unsing)
    }

    def testTrivial2 {
        type xs    = _7 :: Nil
        val xs: xs = _7 :: Nil
        type r = eps#matches[xs]
        val r: r = eps.matches(xs)
        Weak.assertNot[r]
        assertFalse(r.unsing)
    }

    def testParse {
        type xs    = _3 :: _5 :: _6 :: Nil
        val xs: xs = _3 :: _5 :: _6 :: Nil
        type r = eps#parse[xs]
        val r: r = eps.parse(xs)
        Weak.assert[r#successful]
        Weak.assertSame[Nil, r#get]
        Weak.assertSame[xs, r#next#force]
        assertEquals(Nil, r.get)
        assertEquals(_3 :: _5 :: _6 :: Nil, r.next)
    }

}
