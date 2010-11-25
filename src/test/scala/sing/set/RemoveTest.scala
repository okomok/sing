

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class RemoveTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = set.sorted[o]#add[_3]#add[_5]#add[_1]
        val m: m = set.sorted(o).add(_3).add(_5).add(_1)

        type rm = m#remove[_5]
        val rm: rm = m.remove(_5)
        free.assertSame[nat.dense._2, rm#size]
        free.assertSame[`false`, rm#contains[_5]]
        ()
    }

}
