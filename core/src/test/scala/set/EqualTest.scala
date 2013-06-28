

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
        type m   = SortedSet.empty[Nat.naturalOrdering]#add[_4]#add[_3]#add[_1]#add[_2]#add[_5]#add[_0]
        val m: m = SortedSet.empty(Nat.naturalOrdering).add(_4).add(_3).add(_1).add(_2).add(_5).add(_0)

        type m2   = SortedSet.empty[Nat.naturalOrdering]#add[_3]#add[_4]#add[_0]#add[_2]#add[_5]#add[_1]
        val m2: m2 = SortedSet.empty(Nat.naturalOrdering).add(_3).add(_4).add(_0).add(_2).add(_5).add(_1)

        Test.cassertEq[`true`, m#equal[m]]
        Test.cassertEq[`true`, m#equal[m2]]
        Test.cassertEq[`true`, m2#equal[m]]
        assertEquals(`true`, m.equal(m2))
    }

    def testTrivial2 {
        type m   = SortedSet.empty[Nat.naturalOrdering]#add[_4]#add[_8]#add[_1]#add[_2]#add[_5]#add[_0]
        val m: m = SortedSet.empty(Nat.naturalOrdering).add(_4).add(_8).add(_1).add(_2).add(_5).add(_0)

        type m2   = SortedSet.empty[Nat.naturalOrdering]#add[_3]#add[_4]#add[_0]#add[_2]#add[_5]#add[_1]
        val m2: m2 = SortedSet.empty(Nat.naturalOrdering).add(_3).add(_4).add(_0).add(_2).add(_5).add(_1)

        Test.cassertEq[`false`, m#equal[m2]]
        Test.cassertEq[`false`, m2#equal[m]]
        assertEquals(`false`, m.equal(m2))
    }

    def testTrivialDifferentSize {
        type m   = SortedSet.empty[Nat.naturalOrdering]#add[_4]#add[_3]#add[_1]#add[_2]#add[_5]
        val m: m = SortedSet.empty(Nat.naturalOrdering).add(_4).add(_3).add(_1).add(_2).add(_5)

        type m2   = SortedSet.empty[Nat.naturalOrdering]#add[_3]#add[_4]#add[_0]#add[_2]#add[_5]#add[_1]
        val m2: m2 = SortedSet.empty(Nat.naturalOrdering).add(_3).add(_4).add(_0).add(_2).add(_5).add(_1)

        Test.cassertEq[`false`, m#equal[m2]]
        Test.cassertEq[`false`, m2#equal[m]]
        assertEquals(`false`, m.equal(m2))
    }

    def testTrivialEmpty {
        type m   = SortedSet.empty[Nat.naturalOrdering]
        val m: m = SortedSet.empty(Nat.naturalOrdering)

        type m2   = SortedSet.empty[Nat.naturalOrdering]
        val m2: m2 = SortedSet.empty(Nat.naturalOrdering)

        Test.cassertEq[`true`, m#equal[m]]
        Test.cassertEq[`true`, m#equal[m2]]
        Test.cassertEq[`true`, m2#equal[m]]
        assertEquals(`true`, m.equal(m2))
    }

}
