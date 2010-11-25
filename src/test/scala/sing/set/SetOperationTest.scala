

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._


class SetOperationTest extends org.scalatest.junit.JUnit3Suite {

    type m1    = set.sorted[nat.naturalOrdering]#add[_4]#add[_3]#add[_1]#add[_2]#add[_5]#add[_0]
    val m1: m1 = set.sorted(nat.naturalOrdering).add(_4).add(_3).add(_1).add(_2).add(_5).add(_0)

    type m2    = set.sorted[nat.naturalOrdering]#add[_3]#add[_8]#add[_0]#add[_2]#add[_9]#add[_1]
    val m2: m2 = set.sorted(nat.naturalOrdering).add(_3).add(_8).add(_0).add(_2).add(_9).add(_1)

    def testIntersect {
        type a   = set.sorted[nat.naturalOrdering]#add[_0]#add[_2]#add[_1]#add[_3]
        val a: a = set.sorted(nat.naturalOrdering).add(_0).add(_2).add(_1).add(_3)
        free.assertSame[`true`, m1#intersect[m2]#equal[a]]
        assertEquals(a, m1.intersect(m2))
    }

    def testDiff {
        type a   = set.sorted[nat.naturalOrdering]#add[_4]#add[_5]
        val a: a = set.sorted(nat.naturalOrdering).add(_4).add(_5)
        free.assertSame[`true`, m1#diff[m2]#equal[a]]
        assertEquals(a, m1.diff(m2))
    }

    def testUnion {
        type a   = set.sorted[nat.naturalOrdering]#add[_4]#add[_1]#add[_5]#add[_0]#add[_2]#add[_8]#add[_3]#add[_9]
        val a: a = set.sorted(nat.naturalOrdering).add(_4).add(_1).add(_5).add(_0).add(_2).add(_8).add(_3).add(_9)
        free.assertSame[`true`, m1#union[m2]#equal[a]]
        assertEquals(a, m1.union(m2))
    }

}
