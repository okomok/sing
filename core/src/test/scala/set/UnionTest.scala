

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._


class UnionTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type m   = SortedSet.empty[Nat.naturalOrdering]#add[_4]#add[_5]#add[_0]
        val m: m = SortedSet.empty(Nat.naturalOrdering).add(_4).add(_5).add(_0)

        type m2 =    SortedSet.empty[Nat.naturalOrdering]#add[_3]#add[_1]#add[_2]
        val m2: m2 = SortedSet.empty(Nat.naturalOrdering).add(_3).add(_1).add(_2)

        type um = m#union[m2]
        val um: um = m.union(m2)

        Test.cassertEq[`true`, SortedSet.empty[Nat.naturalOrdering]#add[_4]#add[_3]#add[_5]#add[_0]#add[_1]#add[_2]#equal[um]]
        assertEquals(SortedSet.empty(Nat.naturalOrdering).add(_4).add(_3).add(_5).add(_0).add(_1).add(_2), um)
   }

    def testEmpty {
        type m   = SortedSet.empty[Nat.naturalOrdering]
        val m: m = SortedSet.empty(Nat.naturalOrdering)

        type m2 = SortedSet.empty[Nat.naturalOrdering]
        val m2: m2 = SortedSet.empty(Nat.naturalOrdering)

        type um = m#union[m2]
        val um: um = m.union(m2)

        Test.cassertEq[SortedSet.empty[Nat.naturalOrdering], um]
        assertEquals(SortedSet.empty(Nat.naturalOrdering), um)
   }

    def testEmpty2 {
        type m   = SortedSet.empty[Nat.naturalOrdering]
        val m: m = SortedSet.empty(Nat.naturalOrdering)

        type m2 =    SortedSet.empty[Nat.naturalOrdering]#add[_3]#add[_1]#add[_2]
        val m2: m2 = SortedSet.empty(Nat.naturalOrdering).add(_3).add(_1).add(_2)

        type um = m#union[m2]
        val um: um = m.union(m2)

        Test.cassertEq[`true`,  SortedSet.empty[Nat.naturalOrdering]#add[_3]#add[_1]#add[_2]#equal[um]]
        assertEquals(SortedSet.empty(Nat.naturalOrdering).add(_3).add(_1).add(_2), um)
   }

   def testLeftBiased {
        type m   = SortedSet.empty[Nat.naturalOrdering]#add[_4]#add[_5]#add[_0]
        val m: m = SortedSet.empty(Nat.naturalOrdering).add(_4).add(_5).add(_0)

        type m2 =    SortedSet.empty[Nat.naturalOrdering]#add[_3]#add[_4]#add[_2]
        val m2: m2 = SortedSet.empty(Nat.naturalOrdering).add(_3).add(_4).add(_2)

        type um = m#union[m2]
        val um: um = m.union(m2)

        Test.cassertEq[`true`,  SortedSet.empty[Nat.naturalOrdering]#add[_4]#add[_3]#add[_5]#add[_0]#add[_2]#equal[um]]
        assertEquals(SortedSet.empty(Nat.naturalOrdering).add(_4).add(_3).add(_5).add(_0).add(_2), um)
   }

}
