

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import Peano.Literal._
import junit.framework.Assert._


class TrivialTest extends org.scalatest.junit.JUnit3Suite {

    def testSingle {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering
        type s = Map.sorted[o]#put[_3, _Box[Int]]
        val s: s = Map.sorted(o).put(_3, _Box(3))

        AssertInvariant(s)

        Weak.assertSame[Dense._1, s#size]
        Weak.assertSame[_3, s#key]
        Weak.assertSame[_Box[Int], s#value]
        Weak.assertSame[Map.sorted[o], s#left]
        Weak.assertSame[Map.sorted[o], s#right]
        Weak.assertSame[o, s#ord]
        ()
    }

    def testPut {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type m = Map.sorted[o]#put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = Map.sorted(o).put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        AssertInvariant(m)

        Weak.assertSame[Dense._3, m#size]

        type v8 = m#get[_8]
        val v8: v8 = m.get(_8)
        Weak.assertSame[None, v8]

        type v5 = m#get[_5]#get
        val v5: v5 = m.get(_5).get
        Weak.assertSame[_Box[Char], v5]
        assertEquals('c', v5.unsing)
    }

    def testContains {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type m = Map.sorted[o]#put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = Map.sorted(o).put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        Weak.assertSame[`false`, m#contains[_9]]
        Weak.assertSame[`true`, m#contains[_5]]
    }

    def testSorted1 {
        type m = Map.sorted1[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = Map.sorted1(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        Weak.assertSame[`false`, m#contains[_9]]
        Weak.assertSame[`true`, m#contains[_5]]
    }

    def testUnsing {
        type m   = Map.sorted[Nat.naturalOrdering]#put[_3, _4]#put[_1, _2]#put[_5, _6]
        val m: m = Map.sorted(Nat.naturalOrdering).put(_3, _4).put(_1, _2).put(_5, _6)
        assertEquals(Predef.Map(1 -> 2, 3 -> 4, 5 -> 6), m.unsing)
    }

    def testDupePut {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type m = Map.sorted[o]#put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = Map.sorted(o).put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        type v5 = m#get[_5]#get
        val v5: v5 = m.get(_5).get
        Weak.assertSame[_Box[Char], v5]
        assertEquals('c', v5.unsing)

        type m2 = m.put[_5, _Box[String]]
        val m2: m2 = m.put(_5, _Box("hw"))
        Weak.assertSame[_Box[String], m2#get[_5]#get]
        assertEquals("hw", m2.get(_5).get.unsing)
    }

}
