

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import okomok.sing.{assert => dassert}
import Peano.Literal._
import junit.framework.Assert._


class OrderingTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil

        type ys    = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val ys: ys = _5 :: _6 :: _7 :: _8 :: _9 :: Nil

        Weak.assert[List.lexicographicalOrdering[Nat.naturalOrdering]#equiv[xs, ys]]
        dassert(List.lexicographicalOrdering(Nat.naturalOrdering).equiv(xs, ys))
    }

    def testTrivial2 {
        type xs    = Nil
        val xs: xs = Nil

        type ys    = Nil
        val ys: ys = Nil

        Weak.assert[List.lexicographicalOrdering[Nat.naturalOrdering]#equiv[xs, ys]]
        dassert(List.lexicographicalOrdering(Nat.naturalOrdering).equiv(xs, ys))
    }

    def testNilYS {
        type xs    = Nil
        val xs: xs = Nil

        type ys    = _5 :: _6 :: Nil
        val ys: ys = _5 :: _6 :: Nil

        Weak.assert[List.lexicographicalOrdering[Nat.naturalOrdering]#lt[xs, ys]]
        dassert(List.lexicographicalOrdering(Nat.naturalOrdering).lt(xs, ys))
    }

    def testXSNil {
        type xs    = _7 :: _8 :: Nil
        val xs: xs = _7 :: _8 :: Nil

        type ys    = Nil
        val ys: ys = Nil

        Weak.assert[List.lexicographicalOrdering[Nat.naturalOrdering]#gt[xs, ys]]
        dassert(List.lexicographicalOrdering(Nat.naturalOrdering).gt(xs, ys))
    }

    def testLonger {
        type xs    = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: _8 :: _9 :: Nil

        type ys    = _5 :: _6 :: _7 :: Nil
        val ys: ys = _5 :: _6 :: _7 :: Nil

        Weak.assert[List.lexicographicalOrdering[Nat.naturalOrdering]#gt[xs, ys]]
        dassert(List.lexicographicalOrdering(Nat.naturalOrdering).gt(xs, ys))
    }

    def testShorter {
        type xs    = _5 :: _6 :: _7 :: Nil
        val xs: xs = _5 :: _6 :: _7 :: Nil

        type ys    = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val ys: ys = _5 :: _6 :: _7 :: _8 :: _9 :: Nil

        Weak.assert[List.lexicographicalOrdering[Nat.naturalOrdering]#lt[xs, ys]]
        dassert(List.lexicographicalOrdering(Nat.naturalOrdering).lt(xs, ys))
    }

    def testComplicated {
        type xs    = _5 :: _7 :: _7 :: Nil
        val xs: xs = _5 :: _7 :: _7 :: Nil

        type ys    = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val ys: ys = _5 :: _6 :: _7 :: _8 :: _9 :: Nil

        Weak.assert[List.lexicographicalOrdering[Nat.naturalOrdering]#gt[xs, ys]]
        dassert(List.lexicographicalOrdering(Nat.naturalOrdering).gt(xs, ys))
    }

    def testComplicated2 {
        type xs    = _5 :: _7 :: _7 :: Nil
        val xs: xs = _5 :: _7 :: _7 :: Nil

        type ys    = _5 :: _6 :: _7 :: _8 :: _9 :: Nil
        val ys: ys = _5 :: _6 :: _7 :: _8 :: _9 :: Nil

        Weak.assert[List.lexicographicalOrdering[Nat.naturalOrdering]#lt[ys, xs]]
        dassert(List.lexicographicalOrdering(Nat.naturalOrdering).lt(ys, xs))
    }

}
