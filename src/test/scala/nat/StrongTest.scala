

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package nattest


import com.github.okomok

import okomok.sing._
import junit.framework.Assert._


class StrongTest extends org.scalatest.junit.JUnit3Suite {

    def testDense {
        import nat.dense.StrongLiteral._
        free.assert(_5 plus _4 equal _9)
        assertEquals(8, _2 plus _6 unsing)
    }

    def testPeano {
        import nat.peano.StrongLiteral._
        free.assert(_5 plus _4 equal _9)
        assertEquals(8, _2 plus _6 unsing)
    }

}
