

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package peanotest


import com.github.okomok

import okomok.sing._


class ConversionTest extends org.scalatest.junit.JUnit3Suite {

    def testToDense {
        import junit.framework.Assert._
        AssertEq[Dense._0, Peano._0#asNat#asDense]
        AssertEq[Dense._1, Peano._1#asNat#asDense]
        AssertEq[Dense._6, Peano._6#asNat#asDense]
        AssertEq[Dense._5, Peano._2#plus[Peano._3]#asNat#asDense]

        type x = Peano._5
         val x: x = Peano._5
        type y = x#asNat#asDense
         val y: y = x.asNat.asDense
        okomok.sing.assert(Dense._5 equal y)
    }

}
