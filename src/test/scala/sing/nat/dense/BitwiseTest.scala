

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing.free
import okomok.sing.nat.dense._
import junit.framework.Assert._


class BitwiseTest extends org.scalatest.junit.JUnit3Suite {

    def testAnd {
        free.assertSame[_0, _0#bitAnd[_0]]
        free.assertSame[_1, _1#bitAnd[_1]]
        free.assertSame[_0, _2#bitAnd[_5]]
        free.assertSame[_0, _8#bitAnd[_4]]
        free.assertSame[_5, _7#bitAnd[_5]]
        free.assertSame[_0, _5#bitAnd[_0]]
        free.assertSame[_3, _7#bitAnd[_3]]
        free.assertSame[_2, _2#bitAnd[_7]]

        assertEquals(0 & 0, (_0 bitAnd _0).unsung)
        assertEquals(1 & 1, (_1 bitAnd _1).unsung)
        assertEquals(2 & 5, (_2 bitAnd _5).unsung)
        assertEquals(8 & 4, (_8 bitAnd _4).unsung)
        assertEquals(7 & 5, (_7 bitAnd _5).unsung)
        assertEquals(5 & 0, (_5 bitAnd _0).unsung)
        assertEquals(7 & 3, (_7 bitAnd _3).unsung)
        assertEquals(2 & 7, (_2 bitAnd _7).unsung)
    }

    def testOr {
        free.assertSame[_0, _0#bitOr[_0]]
        free.assertSame[_1, _1#bitOr[_1]]
        free.assertSame[_7, _2#bitOr[_5]]
        free.assertSame[_12, _8#bitOr[_4]]
        free.assertSame[_7, _7#bitOr[_5]]
        free.assertSame[_5, _5#bitOr[_0]]
        free.assertSame[_7, _7#bitOr[_3]]
        free.assertSame[_7, _2#bitOr[_7]]

        assertEquals(0 | 0, (_0 bitOr _0).unsung)
        assertEquals(1 | 1, (_1 bitOr _1).unsung)
        assertEquals(2 | 5, (_2 bitOr _5).unsung)
        assertEquals(8 | 4, (_8 bitOr _4).unsung)
        assertEquals(7 | 5, (_7 bitOr _5).unsung)
        assertEquals(5 | 0, (_5 bitOr _0).unsung)
        assertEquals(7 | 3, (_7 bitOr _3).unsung)
        assertEquals(2 | 7, (_2 bitOr _7).unsung)
    }
}
