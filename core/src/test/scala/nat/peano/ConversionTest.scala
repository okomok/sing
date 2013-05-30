

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package peanotest


import com.github.okomok

import okomok.sing.assert
import okomok.sing.weak
import okomok.sing.nat._


class ConversionTest extends org.scalatest.junit.JUnit3Suite {

    def testToDense {
        import junit.framework.Assert._
        weak.assertSame[dense._0, peano._0#asNat#asDense]
        weak.assertSame[dense._1, peano._1#asNat#asDense]
        weak.assertSame[dense._6, peano._6#asNat#asDense]
        weak.assertSame[dense._5, peano._2#plus[peano._3]#asNat#asDense]

        type x = peano._5
         val x: x = peano._5
        type y = x#asNat#asDense
         val y: y = x.asNat.asDense
        okomok.sing.assert(dense._5 equal y)
    }

}
