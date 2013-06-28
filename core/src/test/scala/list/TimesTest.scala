

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest; package listtest


import com.github.okomok

import okomok.sing._
import okomok.sing.{assert => dassert}
import Dense.Literal._
import junit.framework.Assert._


class TimesTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type xs = _1 :: _2 :: _3 :: Nil
        val xs: xs = _1 :: _2 :: _3 :: Nil
        type rs = xs#times[_3]
        val rs: rs = xs.times(_3)
        Test.cassert[rs#equalWith[_1 :: _2 :: _3 :: _1 :: _2 :: _3 :: _1 :: _2 :: _3 :: Nil, Nat.naturalOrdering]]
        assertEquals(_1 :: _2 :: _3 :: _1 :: _2 :: _3 :: _1 :: _2 :: _3 :: Nil, rs)
    }

    def testTrivialNil {
        type xs = Nil
        val xs: xs = Nil
        type rs = xs#times[_3]
        val rs: rs = xs.times(_3)
        Test.cassertEq[Nil, rs#force]
        assertEquals(Nil, rs)
    }

    def testTrivialZero {
        type xs = _1 :: _2 :: _3 :: Nil
        val xs: xs = _1 :: _2 :: _3 :: Nil
        type rs = xs#times[_0]
        val rs: rs = xs.times(_0)
        Test.cassertEq[Nil, rs#force]
        assertEquals(Nil, rs)
    }

}
