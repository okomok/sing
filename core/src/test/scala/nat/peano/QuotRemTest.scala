

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package peanotest


import com.github.okomok

import okomok.sing._
import okomok.sing.nat.peano.Literal._
import okomok.sing.nat.Peano
import junit.framework.Assert._


class QuotRemTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type n = _3#quotRem[_5]
        val n: n = _3.quotRem(_5)
        weak.assertSame[Tuple2[_0, _3], n]
        assertEquals(Tuple2(_0, _3), n)
    }

    def testTrivial2 {
        type n = _13#quotRem[_5]
        val n: n = _13.quotRem(_5)
        weak.assertSame[Tuple2[_2, _3], n]
        assertEquals(Tuple2(_2, _3), n)
    }

    def testTrivial3 {
        type n = _15#quotRem[_5]
        val n: n = _15.quotRem(_5)
        weak.assertSame[Tuple2[_3, _0], n]
        assertEquals(Tuple2(_3, _0), n)
    }

    def testTrivial4 {
        type n = _14#quot[_3]
        val n: n = _14 quot _3
        weak.assertSame[_4, n]
        assertEquals(_4, n)
    }

    def testTrivial5 {
        type n = _14#rem[_3]
        val n: n = _14 rem _3
        weak.assertSame[_2, n]
        assertEquals(_2, n)
    }

}
