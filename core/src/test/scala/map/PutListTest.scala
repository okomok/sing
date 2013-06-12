

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._


class PutListTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = Tuple2[_4, _5] :: Tuple2[_3, _4] :: Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_5, _6] :: Tuple2[_0, _1] :: Nil
        val xs: xs = Tuple2(_4, _5) :: Tuple2(_3, _4) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_5, _6) :: Tuple2(_0, _1) :: Nil

        type m   = SortedMap.empty[Nat.kind.naturalOrdering]#put[_8, _9]#putList[xs]
        val m: m = SortedMap.empty(Nat.kind.naturalOrdering).put(_8, _9).putList(xs)

        type l   = Tuple2[_0, _1] :: Tuple2[_1, _2] :: Tuple2[_2, _3] :: Tuple2[_3, _4] :: Tuple2[_4, _5] :: Tuple2[_5, _6] :: Tuple2[_8, _9] :: Nil
        val l: l = Tuple2(_0, _1) :: Tuple2(_1, _2) :: Tuple2(_2, _3) :: Tuple2(_3, _4) :: Tuple2(_4, _5) :: Tuple2(_5, _6) :: Tuple2(_8, _9) :: Nil
        Test.assertSame[l, m#asList#force]
        assertEquals(l, m.asList)
   }

    def testTrivialNil {
        type m   = SortedMap.empty[Nat.kind.naturalOrdering]#put[_8, _9]#putList[Nil]
        val m: m = SortedMap.empty(Nat.kind.naturalOrdering).put(_8, _9).putList(Nil)

        type l   = Tuple2[_8, _9] :: Nil
        val l: l = Tuple2(_8, _9) :: Nil
        Test.assertSame[l, m#asList#force]
        assertEquals(l, m.asList)
   }

}
