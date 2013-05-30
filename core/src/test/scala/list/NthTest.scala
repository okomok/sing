

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class NthTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val u: xs#nth[_2] = xs.nth(_2)
        weak.assertSame[_7, xs#nth[_2]]
        assertEquals(_7, u)
    }

/*
    def testTrivial {
        type xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val u: xs#nthOption[_2] = xs.nthOption(_2)
        weak.assertSame[Some[_7], xs#nthOption[_2]]
        assertEquals(Some(_7), u)
    }

    def testTrivialNone {
        type xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val u: xs#nthOption[_10] = xs.nthOption(_10)
        weak.assertSame[None, xs#nthOption[_10]]
        assertEquals(None, u)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        val u: xs#nthOption[_10] = xs.nthOption(_10)
        weak.assertSame[None, xs#nthOption[_10]]
        assertEquals(None, u)
    }
*/
}
