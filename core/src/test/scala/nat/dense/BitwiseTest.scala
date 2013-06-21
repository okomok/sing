

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing.Test
import okomok.sing.Dense._
import junit.framework.Assert._


class BitwiseTest extends org.scalatest.junit.JUnit3Suite {

    def testAnd {
        Test.cassertSame[_0, _0#bitAnd[_0]]
        Test.cassertSame[_1, _1#bitAnd[_1]]
        Test.cassertSame[_0, _2#bitAnd[_5]]
        Test.cassertSame[_0, _8#bitAnd[_4]]
        Test.cassertSame[_5, _7#bitAnd[_5]]
        Test.cassertSame[_0, _5#bitAnd[_0]]
        Test.cassertSame[_3, _7#bitAnd[_3]]
        Test.cassertSame[_2, _2#bitAnd[_7]]

        assertEquals(0 & 0, (_0 bitAnd _0).unsing)
        assertEquals(1 & 1, (_1 bitAnd _1).unsing)
        assertEquals(2 & 5, (_2 bitAnd _5).unsing)
        assertEquals(8 & 4, (_8 bitAnd _4).unsing)
        assertEquals(7 & 5, (_7 bitAnd _5).unsing)
        assertEquals(5 & 0, (_5 bitAnd _0).unsing)
        assertEquals(7 & 3, (_7 bitAnd _3).unsing)
        assertEquals(2 & 7, (_2 bitAnd _7).unsing)
    }

    def testOr {
        Test.cassertSame[_0, _0#bitOr[_0]]
        Test.cassertSame[_1, _1#bitOr[_1]]
        Test.cassertSame[_7, _2#bitOr[_5]]
        Test.cassertSame[_12, _8#bitOr[_4]]
        Test.cassertSame[_7, _7#bitOr[_5]]
        Test.cassertSame[_5, _5#bitOr[_0]]
        Test.cassertSame[_7, _7#bitOr[_3]]
        Test.cassertSame[_7, _2#bitOr[_7]]

        assertEquals(0 | 0, (_0 bitOr _0).unsing)
        assertEquals(1 | 1, (_1 bitOr _1).unsing)
        assertEquals(2 | 5, (_2 bitOr _5).unsing)
        assertEquals(8 | 4, (_8 bitOr _4).unsing)
        assertEquals(7 | 5, (_7 bitOr _5).unsing)
        assertEquals(5 | 0, (_5 bitOr _0).unsing)
        assertEquals(7 | 3, (_7 bitOr _3).unsing)
        assertEquals(2 | 7, (_2 bitOr _7).unsing)
    }
}
