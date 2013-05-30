

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import junit.framework.Assert._
import nat.peano.Literal._
import nat.Peano


class OrderingTest extends org.scalatest.junit.JUnit3Suite {

    def testLT {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type r = o#compare[_1, _3]
        val r: r = o.compare(_1, _3)
        free.assertSame[ordering.LT, r]
        assertEquals(-1, r.unsing)
        assertSame(ordering.LT, r)
        assertEquals(ordering.LT, r)
    }

    def testGT {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type r = o#compare[_4, _2]
        val r: r = o.compare(_4, _2)
        free.assertSame[ordering.GT, r]
        assertEquals(1, r.unsing)
        assertSame(ordering.GT, r)
        assertEquals(ordering.GT, r)
    }

    def testEQ {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type r = o#compare[_5, _5]
        val r: r = o.compare(_5, _5)
        free.assertSame[ordering.EQ, r]
        assertEquals(0, r.unsing)
        assertSame(ordering.EQ, r)
        assertEquals(ordering.EQ, r)
    }

    def testMatchLT {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type r = o#`match`[_5, _6, const0[_0], const0[_1], const0[_2]]
        val r: r = o.`match`(_5, _6, const0(_0), const0(_1), const0(_2))
        free.assertSame[_0, r]
        assertEquals(_0, r)
    }

    def testMatchGT {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type r = o#`match`[_7, _6, const0[_0], const0[_1], const0[_2]]
        val r: r = o.`match`(_7, _6, const0(_0), const0(_1), const0(_2))
        free.assertSame[_1, r]
        assertEquals(_1, r)
    }

    def testMatchEQ {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type r = o#`match`[_7, _7, const0[_0], const0[_1], const0[_2]]
        val r: r = o.`match`(_7, _7, const0(_0), const0(_1), const0(_2))
        free.assertSame[_2, r]
        assertEquals(_2, r)
    }

}
