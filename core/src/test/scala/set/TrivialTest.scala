

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import Peano.Literal._
import junit.framework.Assert._


class TrivialTest extends org.scalatest.junit.JUnit3Suite {

    def testAdd {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type m = SortedSet.empty[o]#add[_3]#add[_5]#add[_1]
        val m: m = SortedSet.empty(o).add(_3).add(_5).add(_1)

        Test.assertEq[Dense._3, m#size]

        type v8 = m#contains[_8]
        val v8: v8 = m.contains(_8)
        Test.assertEq[`false`, v8]

        type v5 = m#contains[_5]
        val v5: v5 = m.contains(_5)
        Test.assertEq[`true`, v5]
    }

    def testContains {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type m = SortedSet.empty[o]#add[_3]#add[_5]#add[_1]
        val m: m = SortedSet.empty(o).add(_3).add(_5).add(_1)

        Test.assertEq[`false`, m#contains[_9]]
        Test.assertEq[`true`, m#contains[_5]]
    }

    def testSorted1 {
        type m = SortedSet.add[_3]#add[_5]#add[_1]
        val m: m = SortedSet.add(_3).add(_5).add(_1)

        Test.assertEq[`false`, m#contains[_9]]
        Test.assertEq[`true`, m#contains[_5]]
    }

    def testUnsing {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type m = SortedSet.empty[o]#add[_3]#add[_5]#add[_1]
        val m: m = SortedSet.empty(o).add(_3).add(_5).add(_1)

        assertEquals(Predef.Set(1, 3, 5), m.unsing)
    }

}
