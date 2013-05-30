

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class TrivialTest extends org.scalatest.junit.JUnit3Suite {

    def testAdd {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = set.sorted[o]#add[_3]#add[_5]#add[_1]
        val m: m = set.sorted(o).add(_3).add(_5).add(_1)

        free.assertSame[nat.dense._3, m#size]

        type v8 = m#contains[_8]
        val v8: v8 = m.contains(_8)
        free.assertSame[`false`, v8]

        type v5 = m#contains[_5]
        val v5: v5 = m.contains(_5)
        free.assertSame[`true`, v5]
    }

    def testContains {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = set.sorted[o]#add[_3]#add[_5]#add[_1]
        val m: m = set.sorted(o).add(_3).add(_5).add(_1)

        free.assertSame[`false`, m#contains[_9]]
        free.assertSame[`true`, m#contains[_5]]
    }

    def testSorted1 {
        type m = set.sorted1[_3]#add[_5]#add[_1]
        val m: m = set.sorted1(_3).add(_5).add(_1)

        free.assertSame[`false`, m#contains[_9]]
        free.assertSame[`true`, m#contains[_5]]
    }

    def testUnsing {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = set.sorted[o]#add[_3]#add[_5]#add[_1]
        val m: m = set.sorted(o).add(_3).add(_5).add(_1)

        assertEquals(Predef.Set(1, 3, 5), m.unsing)
    }

}
