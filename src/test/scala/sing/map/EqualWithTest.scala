

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._


class EqualWithTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = Tuple2[_4, _5] :: Tuple2[_3, _4] :: Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_5, _6] :: Tuple2[_0, _1] :: Nil
        val xs: xs = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_5, _6) :: Tuple2(_0, _1) :: Nil
        type m   = map.sorted[nat.naturalOrdering]#put[_8, _9]#putList[xs]
        val m: m = map.sorted(nat.naturalOrdering).put(_8, _9).putList(xs)

        type xs2    = Tuple2[_4, _5] ::Tuple2[_3, _4] ::  Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_0, _1] ::Tuple2[_5, _6] ::  Nil
        val xs2: xs2 = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_0, _1) ::Tuple2(_5, _6) ::  Nil
        type m2   = map.sorted[nat.naturalOrdering]#put[_8, _9]#putList[xs2]
        val m2: m2 = map.sorted(nat.naturalOrdering).put(_8, _9).putList(xs2)

        free.assertSame[`true`, m#equalWith[m, nat.naturalOrdering]]
        free.assertSame[`true`, m#equalWith[m2, nat.naturalOrdering]]
        free.assertSame[`true`, m2#equalWith[m, nat.naturalOrdering]]
        assertEquals(`true`, m.equalWith(m2, nat.naturalOrdering))
    }

    def testTrivialDifferentKey {
        type xs    = Tuple2[_4, _5] :: Tuple2[_3, _4] :: Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_15, _6] :: Tuple2[_0, _1] :: Nil
        val xs: xs = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_15, _6) :: Tuple2(_0, _1) :: Nil
        type m   = map.sorted[nat.naturalOrdering]#put[_8, _9]#putList[xs]
        val m: m = map.sorted(nat.naturalOrdering).put(_8, _9).putList(xs)

        type xs2    = Tuple2[_4, _5] ::Tuple2[_3, _4] ::  Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_0, _1] ::Tuple2[_5, _6] ::  Nil
        val xs2: xs2 = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_0, _1) ::Tuple2(_5, _6) ::  Nil
        type m2   = map.sorted[nat.naturalOrdering]#put[_8, _9]#putList[xs2]
        val m2: m2 = map.sorted(nat.naturalOrdering).put(_8, _9).putList(xs2)

        free.assertSame[`true`, m#equalWith[m, nat.naturalOrdering]]
        free.assertSame[`false`, m#equalWith[m2, nat.naturalOrdering]]
        free.assertSame[`false`, m2#equalWith[m, nat.naturalOrdering]]
        assertEquals(`false`, m.equalWith(m2, nat.naturalOrdering))
    }

    def testTrivialDifferentValue {
        type xs    = Tuple2[_4, _5] :: Tuple2[_3, _4] :: Tuple2[_1, _12] :: Tuple2[_2, _3] :: Tuple2[_5, _6] :: Tuple2[_0, _1] :: Nil
        val xs: xs = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _12) :: Tuple2(_2, _3) :: Tuple2(_5, _6) :: Tuple2(_0, _1) :: Nil
        type m   = map.sorted[nat.naturalOrdering]#put[_8, _9]#putList[xs]
        val m: m = map.sorted(nat.naturalOrdering).put(_8, _9).putList(xs)

        type xs2    = Tuple2[_4, _5] ::Tuple2[_3, _4] ::  Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_0, _1] ::Tuple2[_5, _6] ::  Nil
        val xs2: xs2 = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_0, _1) ::Tuple2(_5, _6) ::  Nil
        type m2   = map.sorted[nat.naturalOrdering]#put[_8, _9]#putList[xs2]
        val m2: m2 = map.sorted(nat.naturalOrdering).put(_8, _9).putList(xs2)

        free.assertSame[`true`, m#equalWith[m, nat.naturalOrdering]]
        free.assertSame[`false`, m#equalWith[m2, nat.naturalOrdering]]
        free.assertSame[`false`, m2#equalWith[m, nat.naturalOrdering]]
        assertEquals(`false`, m.equalWith(m2, nat.naturalOrdering))
    }

    def testTrivialDifferentSize {
        type xs    = Tuple2[_4, _5] :: Tuple2[_3, _4] :: Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_5, _6] :: Nil
        val xs: xs = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_5, _6) :: Nil
        type m   = map.sorted[nat.naturalOrdering]#put[_8, _9]#putList[xs]
        val m: m = map.sorted(nat.naturalOrdering).put(_8, _9).putList(xs)

        type xs2    = Tuple2[_4, _5] ::Tuple2[_3, _4] ::  Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_0, _1] ::Tuple2[_5, _6] ::  Nil
        val xs2: xs2 = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_0, _1) ::Tuple2(_5, _6) ::  Nil
        type m2   = map.sorted[nat.naturalOrdering]#put[_8, _9]#putList[xs2]
        val m2: m2 = map.sorted(nat.naturalOrdering).put(_8, _9).putList(xs2)

        free.assertSame[`true`, m#equalWith[m, nat.naturalOrdering]]
        free.assertSame[`false`, m#equalWith[m2, nat.naturalOrdering]]
        free.assertSame[`false`, m2#equalWith[m, nat.naturalOrdering]]
        assertEquals(`false`, m.equalWith(m2, nat.naturalOrdering))
    }

    def testTrivialNil {
        type m   = map.sorted[nat.naturalOrdering]
        val m: m = map.sorted(nat.naturalOrdering)
        type m2   = map.sorted[nat.naturalOrdering]
        val m2: m2 = map.sorted(nat.naturalOrdering)

        free.assertSame[`true`, m#equalWith[m, nat.naturalOrdering]]
        free.assertSame[`true`, m#equalWith[m2, nat.naturalOrdering]]
        free.assertSame[`true`, m2#equalWith[m, nat.naturalOrdering]]
        assertEquals(`true`, m.equalWith(m2, nat.naturalOrdering))
   }

}
