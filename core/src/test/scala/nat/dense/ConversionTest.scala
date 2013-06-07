

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing._


class ConversionTest extends org.scalatest.junit.JUnit3Suite {

    def testToPeano {
        import junit.framework.Assert._
        Test.assertSame[Peano._0, Dense._0#asNat#asPeano]
        Test.assertSame[Peano._6, Dense._6#asNat#asPeano]
        Test.assertSame[Peano._5, Dense._2#plus[Dense._3]#asNat#asPeano]

        type x = Dense._5
         val x: x = Dense._5
        type y = x#asNat#asPeano
         val y: y = x.asNat.asPeano
        okomok.sing.assert(Peano._5 equal y)
    }

}
