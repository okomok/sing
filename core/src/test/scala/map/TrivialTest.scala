

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class TrivialTest extends org.scalatest.junit.JUnit3Suite {

    def testSingle {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering
        type s = map.sorted[o]#put[_3, Box[Int]]
        val s: s = map.sorted(o).put(_3, Box(3))

        AssertInvariant(s)

        weak.assertSame[nat.dense._1, s#size]
        weak.assertSame[_3, s#key]
        weak.assertSame[Box[Int], s#value]
        weak.assertSame[map.sorted[o], s#left]
        weak.assertSame[map.sorted[o], s#right]
        weak.assertSame[o, s#ord]
        ()
    }

    def testPut {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = map.sorted[o]#put[_3, Box[Int]]#put[_5, Box[Char]]#put[_1, Box[String]]
        val m: m = map.sorted(o).put(_3, Box(3)).put(_5, Box('c')).put(_1, Box("wow"))

        AssertInvariant(m)

        weak.assertSame[nat.dense._3, m#size]

        type v8 = m#get[_8]
        val v8: v8 = m.get(_8)
        weak.assertSame[None, v8]

        type v5 = m#get[_5]#get
        val v5: v5 = m.get(_5).get
        weak.assertSame[Box[Char], v5]
        assertEquals('c', v5.unsing)
    }

    def testContains {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = map.sorted[o]#put[_3, Box[Int]]#put[_5, Box[Char]]#put[_1, Box[String]]
        val m: m = map.sorted(o).put(_3, Box(3)).put(_5, Box('c')).put(_1, Box("wow"))

        weak.assertSame[`false`, m#contains[_9]]
        weak.assertSame[`true`, m#contains[_5]]
    }

    def testSorted1 {
        type m = map.sorted1[_3, Box[Int]]#put[_5, Box[Char]]#put[_1, Box[String]]
        val m: m = map.sorted1(_3, Box(3)).put(_5, Box('c')).put(_1, Box("wow"))

        weak.assertSame[`false`, m#contains[_9]]
        weak.assertSame[`true`, m#contains[_5]]
    }

    def testUnsing {
        type m   = map.sorted[nat.naturalOrdering]#put[_3, _4]#put[_1, _2]#put[_5, _6]
        val m: m = map.sorted(nat.naturalOrdering).put(_3, _4).put(_1, _2).put(_5, _6)
        assertEquals(Predef.Map(1 -> 2, 3 -> 4, 5 -> 6), m.unsing)
    }

    def testDupePut {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = map.sorted[o]#put[_3, Box[Int]]#put[_5, Box[Char]]#put[_1, Box[String]]
        val m: m = map.sorted(o).put(_3, Box(3)).put(_5, Box('c')).put(_1, Box("wow"))

        type v5 = m#get[_5]#get
        val v5: v5 = m.get(_5).get
        weak.assertSame[Box[Char], v5]
        assertEquals('c', v5.unsing)

        type m2 = m.put[_5, Box[String]]
        val m2: m2 = m.put(_5, Box("hw"))
        weak.assertSame[Box[String], m2#get[_5]#get]
        assertEquals("hw", m2.get(_5).get.unsing)
    }

}
