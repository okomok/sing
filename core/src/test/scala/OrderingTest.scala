

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import junit.framework.Assert._
import Peano.Literal._


class OrderingTest extends org.scalatest.junit.JUnit3Suite {

    def testLT {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type r = o#compare[_1, _3]
        val r: r = o.compare(_1, _3)
        Test.assertEq[LT, r]
        assertEquals(-1, r.unsing)
        assertSame(LT, r)
        assertEquals(LT, r)
    }

    def testGT {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type r = o#compare[_4, _2]
        val r: r = o.compare(_4, _2)
        Test.assertEq[GT, r]
        assertEquals(1, r.unsing)
        assertSame(GT, r)
        assertEquals(GT, r)
    }

    def testEQ {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type r = o#compare[_5, _5]
        val r: r = o.compare(_5, _5)
        Test.assertEq[EQ, r]
        assertEquals(0, r.unsing)
        assertSame(EQ, r)
        assertEquals(EQ, r)
    }

    def testMatchLT {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type r = o#`match`[_5, _6, Const[_0], Const[_1], Const[_2]]
        val r: r = o.`match`(_5, _6, Const(_0), Const(_1), Const(_2))
        Test.assertEq[_0, r]
        assertEquals(_0, r)
    }

    def testMatchGT {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type r = o#`match`[_7, _6, Const[_0], Const[_1], Const[_2]]
        val r: r = o.`match`(_7, _6, Const(_0), Const(_1), Const(_2))
        Test.assertEq[_1, r]
        assertEquals(_1, r)
    }

    def testMatchEQ {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type r = o#`match`[_7, _7, Const[_0], Const[_1], Const[_2]]
        val r: r = o.`match`(_7, _7, Const(_0), Const(_1), Const(_2))
        Test.assertEq[_2, r]
        assertEquals(_2, r)
    }

}
