

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing._
import okomok.sing.Dense.Literal._
import junit.framework.Assert._


class QuotRemTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type n = _3#quotRem[_5]
        val n: n = _3.quotRem(_5)
        Test.assertEq[Tuple2[_0, _3], n]
        assertEquals(Tuple2(_0, _3), n)
    }

    def testTrivial2 {
        type n = _13#quotRem[_5]
        val n: n = _13.quotRem(_5)
        Test.assertEq[Tuple2[_2, _3], n]
        assertEquals(Tuple2(_2, _3), n)
    }

    def testTrivial3 {
        type n = _15#quotRem[_5]
        val n: n = _15.quotRem(_5)
        Test.assertEq[Tuple2[_3, _0], n]
        assertEquals(Tuple2(_3, _0), n)
    }

    def testTrivial4 {
        type n = _14#quot[_3]
        val n: n = _14 quot _3
        Test.assertEq[_4, n]
        assertEquals(_4, n)
    }

    def testTrivial5 {
        type n = _14#rem[_3]
        val n: n = _14 rem _3
        Test.assertEq[_2, n]
        assertEquals(_2, n)
    }

    def testTrivial6 {
        type n = _1#quotRem[_1]
        val n: n = _1.quotRem(_1)
        Test.assertEq[Tuple2[_1, _0], n]
        assertEquals(Tuple2(_1, _0), n)
    }

    def testTrivial7 {
        type n = _15#quotRem[_1]
        val n: n = _15.quotRem(_1)
        Test.assertEq[Tuple2[_15, _0], n]
        assertEquals(Tuple2(_15, _0), n)
    }

}
