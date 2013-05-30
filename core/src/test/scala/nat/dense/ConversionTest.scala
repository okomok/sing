

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing.assert
import okomok.sing.free
import okomok.sing.nat._


class ConversionTest extends org.scalatest.junit.JUnit3Suite {

    def testToPeano {
        import junit.framework.Assert._
        free.assertSame[peano._0, dense._0#asNat#asPeano]
        free.assertSame[peano._6, dense._6#asNat#asPeano]
        free.assertSame[peano._5, dense._2#plus[dense._3]#asNat#asPeano]

        type x = dense._5
         val x: x = dense._5
        type y = x#asNat#asPeano
         val y: y = x.asNat.asPeano
        okomok.sing.assert(peano._5 equal y)
    }

}
