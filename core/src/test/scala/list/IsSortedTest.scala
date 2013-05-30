

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class IsSortedTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = _2 :: _6 :: _7 :: _8 :: _9 :: _9 :: _10 :: Nil
        val xs: xs = _2 :: _6 :: _7 :: _8 :: _9 :: _9 :: _10 :: Nil
        type u   = xs#isSortedWith[nat.naturalOrdering]
        val u: u = xs.isSortedWith(nat.naturalOrdering)
        weak.assert[u]
        assertEquals(`true`, u)
    }

    def testTrivialOne {
        type xs = _5 :: Nil
        val xs: xs = _5 :: Nil
        type u   = xs#isSortedWith[nat.naturalOrdering]
        val u: u = xs.isSortedWith(nat.naturalOrdering)
        weak.assert[u]
        assertEquals(`true`, u)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        type u   = xs#isSortedWith[nat.naturalOrdering]
        val u: u = xs.isSortedWith(nat.naturalOrdering)
        weak.assert[u]
        assertEquals(`true`, u)
    }

    def testTrivialNot {
        type xs    = _2 :: _6 :: _7 :: _5 :: _9 :: _9 :: _10 :: Nil
        val xs: xs = _2 :: _6 :: _7 :: _5 :: _9 :: _9 :: _10 :: Nil
        type u   = xs#isSortedWith[nat.naturalOrdering]
        val u: u = xs.isSortedWith(nat.naturalOrdering)
        weak.assertNot[u]
        assertEquals(`false`, u)
    }

}
