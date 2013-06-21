

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
        type s = SortedMap.empty[o]#put[_3, _Box[Int]]
        val s: s = SortedMap.empty(o).put(_3, _Box(3))

        AssertInvariant(s)

        Test.cassertSame[Dense._1, s#size]
        Test.cassertSame[_3, s#key]
        Test.cassertSame[_Box[Int], s#value]
        Test.cassertSame[SortedMap.empty[o], s#left]
        Test.cassertSame[SortedMap.empty[o], s#right]
        Test.cassertSame[o, s#ord]
        ()
    }

    def testPut {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type m = SortedMap.empty[o]#put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = SortedMap.empty(o).put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        AssertInvariant(m)

        Test.cassertSame[Dense._3, m#size]

        type v8 = m#get[_8]
        val v8: v8 = m.get(_8)
        Test.cassertSame[None, v8]

        type v5 = m#get[_5]#get
        val v5: v5 = m.get(_5).get
        Test.cassertSame[_Box[Char], v5]
        assertEquals('c', v5.unsing)
    }

    def testContains {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type m = SortedMap.empty[o]#put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = SortedMap.empty(o).put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        Test.cassertSame[`false`, m#contains[_9]]
        Test.cassertSame[`true`, m#contains[_5]]
    }

    def testSorted1 {
        type m = SortedMap.put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = SortedMap.put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        Test.cassertSame[`false`, m#contains[_9]]
        Test.cassertSame[`true`, m#contains[_5]]
    }

    def testUnsing {
        type m   = SortedMap.empty[Nat.naturalOrdering]#put[_3, _4]#put[_1, _2]#put[_5, _6]
        val m: m = SortedMap.empty(Nat.naturalOrdering).put(_3, _4).put(_1, _2).put(_5, _6)
        assertEquals(Predef.Map(1 -> 2, 3 -> 4, 5 -> 6), m.unsing)
    }

    def testDupePut {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type m = SortedMap.empty[o]#put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = SortedMap.empty(o).put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))

        type v5 = m#get[_5]#get
        val v5: v5 = m.get(_5).get
        Test.cassertSame[_Box[Char], v5]
        assertEquals('c', v5.unsing)

        type m2 = m.put[_5, _Box[String]]
        val m2: m2 = m.put(_5, _Box("hw"))
        Test.cassertSame[_Box[String], m2#get[_5]#get]
        assertEquals("hw", m2.get(_5).get.unsing)
    }

}
