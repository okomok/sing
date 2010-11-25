

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._


class EqualTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type m   = set.sorted[nat.naturalOrdering]#add[_4]#add[_3]#add[_1]#add[_2]#add[_5]#add[_0]
        val m: m = set.sorted(nat.naturalOrdering).add(_4).add(_3).add(_1).add(_2).add(_5).add(_0)

        type m2   = set.sorted[nat.naturalOrdering]#add[_3]#add[_4]#add[_0]#add[_2]#add[_5]#add[_1]
        val m2: m2 = set.sorted(nat.naturalOrdering).add(_3).add(_4).add(_0).add(_2).add(_5).add(_1)

        free.assertSame[`true`, m#equal[m]]
        free.assertSame[`true`, m#equal[m2]]
        free.assertSame[`true`, m2#equal[m]]
        assertEquals(`true`, m.equal(m2))
    }

    def testTrivial2 {
        type m   = set.sorted[nat.naturalOrdering]#add[_4]#add[_8]#add[_1]#add[_2]#add[_5]#add[_0]
        val m: m = set.sorted(nat.naturalOrdering).add(_4).add(_8).add(_1).add(_2).add(_5).add(_0)

        type m2   = set.sorted[nat.naturalOrdering]#add[_3]#add[_4]#add[_0]#add[_2]#add[_5]#add[_1]
        val m2: m2 = set.sorted(nat.naturalOrdering).add(_3).add(_4).add(_0).add(_2).add(_5).add(_1)

        free.assertSame[`false`, m#equal[m2]]
        free.assertSame[`false`, m2#equal[m]]
        assertEquals(`false`, m.equal(m2))
    }

    def testTrivialDifferentSize {
        type m   = set.sorted[nat.naturalOrdering]#add[_4]#add[_3]#add[_1]#add[_2]#add[_5]
        val m: m = set.sorted(nat.naturalOrdering).add(_4).add(_3).add(_1).add(_2).add(_5)

        type m2   = set.sorted[nat.naturalOrdering]#add[_3]#add[_4]#add[_0]#add[_2]#add[_5]#add[_1]
        val m2: m2 = set.sorted(nat.naturalOrdering).add(_3).add(_4).add(_0).add(_2).add(_5).add(_1)

        free.assertSame[`false`, m#equal[m2]]
        free.assertSame[`false`, m2#equal[m]]
        assertEquals(`false`, m.equal(m2))
    }

    def testTrivialEmpty {
        type m   = set.sorted[nat.naturalOrdering]
        val m: m = set.sorted(nat.naturalOrdering)

        type m2   = set.sorted[nat.naturalOrdering]
        val m2: m2 = set.sorted(nat.naturalOrdering)

        free.assertSame[`true`, m#equal[m]]
        free.assertSame[`true`, m#equal[m2]]
        free.assertSame[`true`, m2#equal[m]]
        assertEquals(`true`, m.equal(m2))
    }

}
