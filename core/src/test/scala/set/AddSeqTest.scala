

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._


class AddSeqTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs    = _4 :: _3 :: _1 :: _2 :: _5 :: _0 :: Nil
        val xs: xs = _4 :: _3 :: _1 :: _2 :: _5 :: _0 :: Nil

        type m   = set.sorted[nat.naturalOrdering]#add[_8]#addList[xs]
        val m: m = set.sorted(nat.naturalOrdering).add(_8).addList(xs)

        type l   = _0 :: _1 :: _2 :: _3 :: _4 :: _5 :: _8 :: Nil
        val l: l = _0 :: _1 :: _2 :: _3 :: _4 :: _5 :: _8 :: Nil
        Weak.assertSame[l, m#asList#force]
        assertEquals(l, m.asList)
   }

    def testTrivialNil {
        type m   = set.sorted[nat.naturalOrdering]#add[_8]#addList[Nil]
        val m: m = set.sorted(nat.naturalOrdering).add(_8).addList(Nil)

        type l   = _8 :: Nil
        val l: l = _8 :: Nil
        Weak.assertSame[l, m#asList#force]
        assertEquals(l, m.asList)
   }

}
