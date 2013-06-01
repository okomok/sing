

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing._
import okomok.sing.nat.dense.Literal._
import okomok.sing.nat.Dense


class TrivialTest extends org.scalatest.junit.JUnit3Suite {

    def testUnsing {
        import junit.framework.Assert._
        assertEquals(0, _0.unsing)
        assertEquals(7, _6.increment.unsing)
        assertEquals(10, _10.unsing)

        assertEquals(_2, _2)
        AssertNotEquals(_2, _3)
    }

    def testIncDecDuarity {
        val x: _4 = _3.increment
        val y: _3 = _4.decrement
        ()
    }

    def testAddDuality {
        val x: _2#plus [_3] = _2 plus _3
        val y: _5 = x
        okomok.sing.assert(x equal y)
        okomok.sing.assert(x equal _5)
    }

    def testSubstractDuality {
        val x: _6# minus [_5] = _6 minus _5
        val y: _1 = x
        okomok.sing.assert(x equal y)
        okomok.sing.assert(x equal _1)
    }

    def testComparisonDuality {
        val a: _4#gt [_2] = _4 gt _2
        val b: `true` = a
        okomok.sing.assert(a equal b)
        okomok.sing.assert(a equal `true`)
    }

    trait testTrivial {
        Weak.assertSame[scala.Int, _2#unsing]
        Weak.assert[_0# equal [_0]]

        Weak.assert[_0# nequal [_1]]
        Weak.assert[_1# nequal [_0]]

        Weak.assert[_1# equal [_1]]

        Weak.assert[_1# nequal [_2]]
        Weak.assert[_1# nequal [_3]]
        Weak.assert[_2# nequal [_1]]
        Weak.assert[_3# nequal[_1]]

        Weak.assert[_7# equal[_7]]
        Weak.assert[_2# nequal[_7]]
        Weak.assert[_7# nequal[_2]]
        Weak.assert[_6# nequal[_7]]
        Weak.assert[_7# nequal[_6]]
        Weak.assert[_0# nequal[_7]]
        Weak.assert[_7# nequal[_0]]
        Weak.assert[_1# nequal[_7]]
        Weak.assert[_7# nequal[_1]]

        Weak.assert[_1#increment# equal [_2]]
        Weak.assert[_1#increment#increment# equal [_3]]

        Weak.assert[_1#decrement# equal [_0]]
        Weak.assert[_3#decrement#decrement# equal [_1]]
        Weak.assert[_4#decrement# equal [_3]]
        Weak.assert[_7#increment#decrement#decrement# equal [_6]]
    }

    trait testAdd {
        Weak.assert[_0#plus[_0]# equal[_0]]
        Weak.assert[_0#plus[_3]# equal[_3]]
        Weak.assert[_4#plus[_3]# equal[_7]]
        Weak.assert[_1#plus[_8]# equal[_9]]
        Weak.assert[_5#plus[_2]# equal[_7]]
    }

    trait testSubtract {
        Weak.assert[_0# minus[_0]# equal[_0]]
        Weak.assert[_1# minus[_1]# equal[_0]]
        Weak.assert[_3# minus[_0]# equal[_3]]
        Weak.assert[_4# minus[_3]# equal[_1]]
        Weak.assert[_8# minus[_1]# equal[_7]]
        Weak.assert[_5# minus[_2]# equal[_3]]
        Weak.assert[_6# minus[_5]# equal[_1]]
        Weak.assert[_5# minus[_5]# equal[_0]]
    }

    trait testComparison {
        Weak.assert[_0#lt[_2]]
        Weak.assert[_3#lt[_5]]
        Weak.assert[_3#lteq[_3]]
        Weak.assert[_5#gt[_3]]
        Weak.assert[_4#gt[_0]]
        Weak.assert[_4# gteq[_2]]
        Weak.assert[_0#lteq[_0]]
        Weak.assert[_0# gteq[_0]]
        Weak.assertNot[_3#gt[_5]]
        Weak.assertNot[_0#lt[_0]]
        Weak.assertNot[_0#gt[_0]]
        Weak.assertNot[_4# gteq[_5]]
        Weak.assertNot[_4#lteq[_2]]
        Weak.assertNot[_4#lt[_4]]
        Weak.assertNot[_4#gt[_4]]
    }

    trait testPropagation {
        type plusPlus[n <: Dense] = n#increment#increment
        type id[n <: Dense] = n#increment#decrement
        type equaL[n <: Dense, m <: Dense] = plusPlus[n]# equal [id[m]]

        Weak.assert[plusPlus[_4]# equal [_6]]
        Weak.assert[plusPlus[_7]# equal [_9]]
        Weak.assert[id[_9]# equal [_9]]
        Weak.assert[id[_7]# equal [_7]]

        Weak.assert[equaL[_3, _5]]
        Weak.assert[equaL[_4, _6]]

        // Must work.
        type subsub[n <: Dense, m <: Dense] = n# minus[m]# minus[m]
        Weak.assert[subsub[_9, _2]# equal [_5]]
    }

}
