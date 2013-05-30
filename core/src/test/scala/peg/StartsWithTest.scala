

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._


class StartsWithTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = _3 :: _4 :: _5 :: _6 :: Nil
        val xs: xs = _3 :: _4 :: _5 :: _6 :: Nil
        type ys    = _3 :: _4 :: _5 :: Nil
        val ys: ys = _3 :: _4 :: _5 :: Nil
        type r   = peg.StartsWith.apply[xs, ys, None]
        val r: r = peg.StartsWith.apply(xs, ys, None)
        weak.assert[r#isEmpty#not]
        weak.assertSame[ys, r#get#asProduct2#_1#asList#force]
        weak.assertSame[_6 :: Nil, r#get#asProduct2#_2#asList#force]
        assertEquals(ys, r.get.asProduct2._1)
        assertEquals(_6 :: Nil, r.get.asProduct2._2)
    }

    def testNil {
        type xs    = _3 :: _4 :: _5 :: _6 :: Nil
        val xs: xs = _3 :: _4 :: _5 :: _6 :: Nil
        type ys    = Nil
        val ys: ys = Nil
        type r   = peg.StartsWith.apply[xs, ys, None]
        val r: r = peg.StartsWith.apply(xs, ys, None)
        weak.assert[r#isEmpty#not]
        weak.assertSame[Nil, r#get#asProduct2#_1#asList#force]
        weak.assertSame[xs, r#get#asProduct2#_2#asList#force]
        assertEquals(Nil, r.get.asProduct2._1)
        assertEquals(xs, r.get.asProduct2._2)
    }

    def testNilNil {
        type xs    = Nil
        val xs: xs = Nil
        type ys    = Nil
        val ys: ys = Nil
        type r   = peg.StartsWith.apply[xs, ys, None]
        val r: r = peg.StartsWith.apply(xs, ys, None)
        weak.assert[r#isEmpty#not]
        weak.assertSame[Nil, r#get#asProduct2#_1#asList#force]
        weak.assertSame[Nil, r#get#asProduct2#_2#asList#force]
        assertEquals(Nil, r.get.asProduct2._1)
        assertEquals(Nil, r.get.asProduct2._2)
    }

    def testNone {
        type xs    = _3 :: _4 :: _5 :: _6 :: Nil
        val xs: xs = _3 :: _4 :: _5 :: _6 :: Nil
        type ys    = _5 :: _6 :: Nil
        val ys: ys = _5 :: _6 :: Nil
        type r   = peg.StartsWith.apply[xs, ys, None]
        val r: r = peg.StartsWith.apply(xs, ys, None)
        weak.assert[r#isEmpty]
        assertEquals(None, r)
    }

    def testAll {
        type xs    = _3 :: _4 :: _5 :: _6 :: Nil
        val xs: xs = _3 :: _4 :: _5 :: _6 :: Nil
        type ys    = _3 :: _4 :: _5 :: _6 :: Nil
        val ys: ys = _3 :: _4 :: _5 :: _6 :: Nil
        type r   = peg.StartsWith.apply[xs, ys, None]
        val r: r = peg.StartsWith.apply(xs, ys, None)
        weak.assert[r#isEmpty#not]
        weak.assertSame[xs, r#get#asProduct2#_1#asList#force]
        weak.assertSame[Nil, r#get#asProduct2#_2#asList#force]
        assertEquals(xs, r.get.asProduct2._1)
        assertEquals(Nil, r.get.asProduct2._2)
    }

}
