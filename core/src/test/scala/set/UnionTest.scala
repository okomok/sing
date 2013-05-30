

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._


class UnionTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type m   = set.sorted[nat.naturalOrdering]#add[_4]#add[_5]#add[_0]
        val m: m = set.sorted(nat.naturalOrdering).add(_4).add(_5).add(_0)

        type m2 =    set.sorted[nat.naturalOrdering]#add[_3]#add[_1]#add[_2]
        val m2: m2 = set.sorted(nat.naturalOrdering).add(_3).add(_1).add(_2)

        type um = m#union[m2]
        val um: um = m.union(m2)

        free.assertSame[`true`, set.sorted[nat.naturalOrdering]#add[_4]#add[_3]#add[_5]#add[_0]#add[_1]#add[_2]#equal[um]]
        assertEquals(set.sorted(nat.naturalOrdering).add(_4).add(_3).add(_5).add(_0).add(_1).add(_2), um)
   }

    def testEmpty {
        type m   = set.sorted[nat.naturalOrdering]
        val m: m = set.sorted(nat.naturalOrdering)

        type m2 = set.sorted[nat.naturalOrdering]
        val m2: m2 = set.sorted(nat.naturalOrdering)

        type um = m#union[m2]
        val um: um = m.union(m2)

        free.assertSame[set.sorted[nat.naturalOrdering], um]
        assertEquals(set.sorted(nat.naturalOrdering), um)
   }

    def testEmpty2 {
        type m   = set.sorted[nat.naturalOrdering]
        val m: m = set.sorted(nat.naturalOrdering)

        type m2 =    set.sorted[nat.naturalOrdering]#add[_3]#add[_1]#add[_2]
        val m2: m2 = set.sorted(nat.naturalOrdering).add(_3).add(_1).add(_2)

        type um = m#union[m2]
        val um: um = m.union(m2)

        free.assertSame[`true`,  set.sorted[nat.naturalOrdering]#add[_3]#add[_1]#add[_2]#equal[um]]
        assertEquals(set.sorted(nat.naturalOrdering).add(_3).add(_1).add(_2), um)
   }

   def testLeftBiased {
        type m   = set.sorted[nat.naturalOrdering]#add[_4]#add[_5]#add[_0]
        val m: m = set.sorted(nat.naturalOrdering).add(_4).add(_5).add(_0)

        type m2 =    set.sorted[nat.naturalOrdering]#add[_3]#add[_4]#add[_2]
        val m2: m2 = set.sorted(nat.naturalOrdering).add(_3).add(_4).add(_2)

        type um = m#union[m2]
        val um: um = m.union(m2)

        free.assertSame[`true`,  set.sorted[nat.naturalOrdering]#add[_4]#add[_3]#add[_5]#add[_0]#add[_2]#equal[um]]
        assertEquals(set.sorted(nat.naturalOrdering).add(_4).add(_3).add(_5).add(_0).add(_2), um)
   }

}
