

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import Peano.Literal._
import junit.framework.Assert._


class RemoveTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type o = Nat.naturalOrdering
        val o: o = Nat.naturalOrdering

        type m = Set.sorted[o]#add[_3]#add[_5]#add[_1]
        val m: m = Set.sorted(o).add(_3).add(_5).add(_1)

        type rm = m#remove[_5]
        val rm: rm = m.remove(_5)
        Test.assertSame[Dense._2, rm#size]
        Test.assertSame[`false`, rm#contains[_5]]
        ()
    }

}
