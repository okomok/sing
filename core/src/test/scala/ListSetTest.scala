

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest


import com.github.okomok.sing._
import Dense.Literal._
import junit.framework.Assert._
import scala.language.existentials


class ListSetTest extends org.scalatest.junit.JUnit3Suite {

    def testRemove {
        type m = ListSet.add[_3]#add[_5]#add[_1]
        val m: m = ListSet.add(_3).add(_5).add(_1)

        type rm = m#remove[_5]
        val rm: rm = m.remove(_5)

        Test.cassertSame[_2, rm#size]
        Test.cassertSame[`false`, rm#contains[_5]]
    }

    def testClear {
        type m1    = ListSet.add[_4]#add[_3]#add[_1]#add[_2]#add[_5]#add[_0]
        val m1: m1 = ListSet.add(_4).add(_3).add(_1).add(_2).add(_5).add(_0)

        type n = m1#clear
        val n: n = m1.clear

        Test.cassert[n#isEmpty]
        assertTrue(n.isEmpty.unsing)
    }

    def testEqual {
        type m   = ListSet.add[_4]#add[_3]#add[_1]#add[_2]#add[_5]#add[_0]
        val m: m = ListSet.add(_4).add(_3).add(_1).add(_2).add(_5).add(_0)

        type m2   = SortedSet.add[_3]#add[_4]#add[_0]#add[_2]#add[_5]#add[_1]
        val m2: m2 = SortedSet.add(_3).add(_4).add(_0).add(_2).add(_5).add(_1)

        Test.cassertSame[`true`, m#equal[m]]
        Test.cassertSame[`true`, m#equal[m2]]
        Test.cassertSame[`true`, m2#equal[m]]
        assertEquals(`true`, m.equal(m2))
    }

    def testNotUnique {
        type m   = ListSet.add[_4]#add[_3]#add[_1]#add[_2]#add[_5]#add[_0]
        val m: m = ListSet.add(_4).add(_3).add(_1).add(_2).add(_5).add(_0)

        type m2   = m.add[_1]
        val m2: m2 = m.add(_1)

        Test.cassertSame[`true`, m#size#equal[m2#size]]
    }

    def testAdd {
        type m = ListSet.add[_3]#add[_5]#add[_1]
        val m: m = ListSet.add(_3).add(_5).add(_1)

        Test.cassertSame[_3, m#size]

        type v8 = m#contains[_8]
        val v8: v8 = m.contains(_8)
        Test.cassertSame[`false`, v8]

        type v5 = m#contains[_5]
        val v5: v5 = m.contains(_5)
        Test.cassertSame[`true`, v5]
    }

    def testContains {
        type m = ListSet.add[_3]#add[_5]#add[_1]
        val m: m = ListSet.add(_3).add(_5).add(_1)

        Test.cassertSame[`false`, m#contains[_9]]
        Test.cassertSame[`true`, m#contains[_5]]
    }

    def testSorted1 {
        type m = ListSet.add[_3]#add[_5]#add[_1]
        val m: m = ListSet.add(_3).add(_5).add(_1)

        Test.cassertSame[`false`, m#contains[_9]]
        Test.cassertSame[`true`, m#contains[_5]]
    }

    def testUnsing {
        type m = ListSet.add[_3]#add[_5]#add[_1]
        val m: m = ListSet.add(_3).add(_5).add(_1)

        assertEquals(scala.collection.immutable.ListSet(1, 5, 3), m.unsing)
    }

}

