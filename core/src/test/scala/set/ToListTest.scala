

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package settest


import com.github.okomok

import okomok.sing._
import nat.dense.Literal._
import junit.framework.Assert._


class ToListTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type m   = set.sorted[nat.naturalOrdering]#add[_4]#add[_3]#add[_1]#add[_2]#add[_5]#add[_0]
        val m: m = set.sorted(nat.naturalOrdering).add(_4).add(_3).add(_1).add(_2).add(_5).add(_0)

        type l   = _0 :: _1 :: _2 :: _3 :: _4 :: _5 :: Nil
        val l: l = _0 :: _1 :: _2 :: _3 :: _4 :: _5 :: Nil
        Weak.assertSame[l, m#asList#force]
        assertEquals(l, m.asList)
   }

}
