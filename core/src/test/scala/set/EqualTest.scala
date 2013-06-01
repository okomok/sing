

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._


class EqualTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type m   = Set.sorted[Nat.naturalOrdering]#add[_4]#add[_3]#add[_1]#add[_2]#add[_5]#add[_0]
        val m: m = Set.sorted(Nat.naturalOrdering).add(_4).add(_3).add(_1).add(_2).add(_5).add(_0)

        type m2   = Set.sorted[Nat.naturalOrdering]#add[_3]#add[_4]#add[_0]#add[_2]#add[_5]#add[_1]
        val m2: m2 = Set.sorted(Nat.naturalOrdering).add(_3).add(_4).add(_0).add(_2).add(_5).add(_1)

        Weak.assertSame[`true`, m#equal[m]]
        Weak.assertSame[`true`, m#equal[m2]]
        Weak.assertSame[`true`, m2#equal[m]]
        assertEquals(`true`, m.equal(m2))
    }

    def testTrivial2 {
        type m   = Set.sorted[Nat.naturalOrdering]#add[_4]#add[_8]#add[_1]#add[_2]#add[_5]#add[_0]
        val m: m = Set.sorted(Nat.naturalOrdering).add(_4).add(_8).add(_1).add(_2).add(_5).add(_0)

        type m2   = Set.sorted[Nat.naturalOrdering]#add[_3]#add[_4]#add[_0]#add[_2]#add[_5]#add[_1]
        val m2: m2 = Set.sorted(Nat.naturalOrdering).add(_3).add(_4).add(_0).add(_2).add(_5).add(_1)

        Weak.assertSame[`false`, m#equal[m2]]
        Weak.assertSame[`false`, m2#equal[m]]
        assertEquals(`false`, m.equal(m2))
    }

    def testTrivialDifferentSize {
        type m   = Set.sorted[Nat.naturalOrdering]#add[_4]#add[_3]#add[_1]#add[_2]#add[_5]
        val m: m = Set.sorted(Nat.naturalOrdering).add(_4).add(_3).add(_1).add(_2).add(_5)

        type m2   = Set.sorted[Nat.naturalOrdering]#add[_3]#add[_4]#add[_0]#add[_2]#add[_5]#add[_1]
        val m2: m2 = Set.sorted(Nat.naturalOrdering).add(_3).add(_4).add(_0).add(_2).add(_5).add(_1)

        Weak.assertSame[`false`, m#equal[m2]]
        Weak.assertSame[`false`, m2#equal[m]]
        assertEquals(`false`, m.equal(m2))
    }

    def testTrivialEmpty {
        type m   = Set.sorted[Nat.naturalOrdering]
        val m: m = Set.sorted(Nat.naturalOrdering)

        type m2   = Set.sorted[Nat.naturalOrdering]
        val m2: m2 = Set.sorted(Nat.naturalOrdering)

        Weak.assertSame[`true`, m#equal[m]]
        Weak.assertSame[`true`, m#equal[m2]]
        Weak.assertSame[`true`, m2#equal[m]]
        assertEquals(`true`, m.equal(m2))
    }

}
