

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package nattest; package densetest


import com.github.okomok

import okomok.sing._
import okomok.sing.Dense.Literal._
import okomok.sing.Dense
import junit.framework.Assert._


class MultiplyTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        assertEquals(_6, _3 times _2)
        assertEquals(_6, _2 times _3)
        assertEquals(_0, _3 times _0)
        assertEquals(_0, _0 times _0)
        assertEquals(_0, _0 times _9)
        assertEquals(_12, _6 times _2)
        assertEquals(_15, _3 times _5)
        assertEquals(_8, _4 times _2)
        assertEquals(_1, _1 times _1)
        assertEquals(_9, _3 times _3)
    }

    def testDuality {
        val a: _4# times [_2] = _4 times _2
        assertEquals(_8, a)
        val b: _8 = a
        okomok.sing.assert(a equal b)
        okomok.sing.assert(a equal _8)
    }

    trait teztTrivial {
        Test.cassertEq[_6, _3 # times[ _2]]
        Test.cassertEq[_6, _2 # times[ _3]]
        Test.cassertEq[_0, _3 # times[ _0]]
        Test.cassertEq[_0, _0 # times[ _0]]
        Test.cassertEq[_0, _0 # times[ _9]]
        Test.cassertEq[_12, _6 # times[ _2]]
        Test.cassertEq[_15, _3 # times[ _5]]
        Test.cassertEq[_8, _4 # times[ _2]]
        Test.cassertEq[_1, _1 # times[ _1]]
        Test.cassertEq[_9, _3 # times[ _3]]
    }
}
