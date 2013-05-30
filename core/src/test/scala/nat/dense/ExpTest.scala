

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing._
import okomok.sing.nat.dense.Literal._
import okomok.sing.nat.Dense
import junit.framework.Assert._


class ExpTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        assertEquals(_9, _3 exp _2)
        assertEquals(_8, _2 exp _3)
        assertEquals(_1, _3 exp _0)
        assertEquals(_1, _0 exp _0)
        assertEquals(_0, _0 exp _9)
        assertEquals(_6 times _6, _6 exp _2)
        assertEquals(_15 plus _1, _4 exp _2)
        assertEquals(_1, _1 exp _1)
    }

    def testBig {
        assertEquals(32768, (_2 exp _15).unsing)
        assertEquals(1073741824, (_8 exp _10).unsing)
    }

    def testDuality {
        val a: _4# exp [_2] = _4 exp _2
        assertEquals(_15 plus _1, a)
        val b: _15#plus [_1] = a
        okomok.sing.assert(a equal b)
        okomok.sing.assert(a equal (_15 plus _1))
    }

    trait teztTrivial {
        free.assertSame[_9, _3 # exp[ _2]]
        free.assertSame[_8, _2 # exp[ _3]]
        free.assertSame[_1, _3 # exp[ _0]]
        free.assertSame[_1, _0 # exp[ _0]]
        free.assertSame[_0, _0 # exp[ _9]]
        free.assertSame[_6# times [_6], _6 # exp[ _2]]
        free.assertSame[_15#plus [_1], _4 # exp[ _2]]
        free.assertSame[_1, _1 # exp[ _1]]
    }

}
