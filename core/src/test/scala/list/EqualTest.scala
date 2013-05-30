

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import okomok.sing.{assert => dassert}
import nat.peano.Literal._
import junit.framework.Assert._


class EqualTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: _8 :: Nil
        val xs: xs = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: _8 :: Nil

        type ys = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: _8 :: Nil
        val ys: ys = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: _8 :: Nil

        type u = xs#equal[xs]
        val u: u = xs.equal(ys)
        free.assertSame[`true`, u]
        assertEquals(`true`, u)
    }

    def testTrivialOne {
        type xs = _8 :: Nil
        val xs: xs = _8 :: Nil

        type ys = _8 :: Nil
        val ys: ys = _8 :: Nil

        type u = xs#equal[ys]
        val u: u = xs.equal(ys)
        free.assertSame[`true`, u]
        assertEquals(`true`, u)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil

        type ys = Nil
        val ys: ys = Nil

        type u = xs#equal[ys]
        val u: u = xs.equal(ys)
        free.assertSame[`true`, u]
        assertEquals(`true`, u)
    }

    def testDifferenceSize {
        type xs = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: Nil
        val xs: xs = _9 :: _2 :: _6 :: _10 :: _7 :: _9 ::  Nil

        type ys = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: _8 :: Nil
        val ys: ys = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: _8 :: Nil

        type u = xs#equal[ys]
        val u: u = xs.equal(ys)
        free.assertSame[`false`, u]
        assertEquals(`false`, u)
    }

    def testDifferenceSize2 {
        type xs = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: _8 :: Nil
        val xs: xs = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: _8 :: Nil

        type ys = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: Nil
        val ys: ys = _9 :: _2 :: _6 :: _10 :: _7 :: _9 :: Nil

        type u = xs#equal[ys]
        val u: u = xs.equal(ys)
        free.assertSame[`false`, u]
        assertEquals(`false`, u)
    }
}
