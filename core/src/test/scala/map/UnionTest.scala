

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._


class UnionTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type m   = Map.sorted[Nat.naturalOrdering]#put[_4, _5]#put[_5, _6]#put[_0, _1]
        val m: m = Map.sorted(Nat.naturalOrdering).put(_4, _5).put(_5, _6).put(_0, _1)

        type m2 =    Map.sorted[Nat.naturalOrdering]#put[_3, _4]#put[_1, _2]#put[_2, _3]
        val m2: m2 = Map.sorted(Nat.naturalOrdering).put(_3, _4).put(_1, _2).put(_2, _3)

        type um = m#union[m2]
        val um: um = m.union(m2)

        Weak.assertSame[`true`, Map.sorted[Nat.naturalOrdering]#put[_4, _5]#put[_3, _4]#put[_5, _6]#put[_0, _1]#put[_1, _2]#put[_2, _3]#equalWith[um, Nat.naturalOrdering]]
        assertEquals(Map.sorted(Nat.naturalOrdering).put(_4, _5).put(_3, _4).put(_5, _6).put(_0, _1).put(_1, _2).put(_2, _3), um)
   }

    def testEmpty {
        type m   = Map.sorted[Nat.naturalOrdering]
        val m: m = Map.sorted(Nat.naturalOrdering)

        type m2 = Map.sorted[Nat.naturalOrdering]
        val m2: m2 = Map.sorted(Nat.naturalOrdering)

        type um = m#union[m2]
        val um: um = m.union(m2)

        Weak.assertSame[Map.sorted[Nat.naturalOrdering], um]
        assertEquals(Map.sorted(Nat.naturalOrdering), um)
   }

    def testEmpty2 {
        type m   = Map.sorted[Nat.naturalOrdering]
        val m: m = Map.sorted(Nat.naturalOrdering)

        type m2 =    Map.sorted[Nat.naturalOrdering]#put[_3, _4]#put[_1, _2]#put[_2, _3]
        val m2: m2 = Map.sorted(Nat.naturalOrdering).put(_3, _4).put(_1, _2).put(_2, _3)

        type um = m#union[m2]
        val um: um = m.union(m2)

        Weak.assertSame[`true`,  Map.sorted[Nat.naturalOrdering]#put[_3, _4]#put[_1, _2]#put[_2, _3]#equalWith[um, Nat.naturalOrdering]]
        assertEquals(Map.sorted(Nat.naturalOrdering).put(_3, _4).put(_1, _2).put(_2, _3), um)
   }

   def testLeftBiased {
        type m   = Map.sorted[Nat.naturalOrdering]#put[_4, _5]#put[_5, _6]#put[_0, _1]
        val m: m = Map.sorted(Nat.naturalOrdering).put(_4, _5).put(_5, _6).put(_0, _1)

        type m2 =    Map.sorted[Nat.naturalOrdering]#put[_3, _4]#put[_4, _9]#put[_2, _3]
        val m2: m2 = Map.sorted(Nat.naturalOrdering).put(_3, _4).put(_4, _9).put(_2, _3)

        type um = m#union[m2]
        val um: um = m.union(m2)

        Weak.assertSame[`true`,  Map.sorted[Nat.naturalOrdering]#put[_4, _5]#put[_3, _4]#put[_5, _6]#put[_0, _1]#put[_2, _3]#equalWith[um, Nat.naturalOrdering]]
        assertEquals(Map.sorted(Nat.naturalOrdering).put(_4, _5).put(_3, _4).put(_5, _6).put(_0, _1).put(_2, _3), um)
   }

}
