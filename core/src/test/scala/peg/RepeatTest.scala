

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package pegtest


import com.github.okomok

import okomok.sing._
import Dense.Literal._
import junit.framework.Assert._
import Peg.term


class RepeatTest extends org.scalatest.junit.JUnit3Suite {


    def testTrivial {
        type xs    = _1 :: _1 :: _1 :: _1 :: _3 :: Nil
        val xs: xs = _1 :: _1 :: _1 :: _1 :: _3 :: Nil
        type p   = term[_1]#repeat[_2, _5]
        val p: p = term(_1).repeat(_2, _5)
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Test.assertTrue[r#successful]
        assertTrue(r.successful.unsing)
        Test.assertSame[_1 :: _1 :: _1 :: _1 :: Nil, r#get#force]
        assertEquals(_1 :: _1 :: _1 :: _1 :: Nil, r.get)
        Test.assertSame[_3 :: Nil, r#next#force]
        assertEquals(_3 :: Nil, r.next)
    }

    def testNotTakeTooMany {
        type xs    = _1 :: _1 :: _1 :: _1 :: _1 :: _1 :: _1 :: Nil
        val xs: xs = _1 :: _1 :: _1 :: _1 :: _1 :: _1 :: _1 :: Nil
        type p   = term[_1]#repeat[_2, _5]
        val p: p = term(_1).repeat(_2, _5)
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Test.assertTrue[r#successful]
        assertTrue(r.successful.unsing)
        Test.assertSame[_1 :: _1 :: _1 :: _1 :: _1 :: Nil, r#get#force]
        assertEquals(_1 :: _1 :: _1 :: _1 :: _1 :: Nil, r.get)
        Test.assertSame[_1 :: _1 :: Nil, r#next#force]
        assertEquals(_1 :: _1 :: Nil, r.next)
    }

    def testAtLeast {
        type xs    = _1 :: _1 :: _2 :: _1 :: _1 :: _1 :: Nil
        val xs: xs = _1 :: _1 :: _2 :: _1 :: _1 :: _1 :: Nil
        type p   = term[_1]#repeat[_3, _5]
        val p: p = term(_1).repeat(_3, _5)
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Test.assertFalse[r#successful]
        assertFalse(r.successful.unsing)
        Test.assertSame[xs, r#next#force]
        assertEquals(xs, r.next)
    }

    def testExactly {
        type xs    = _1 :: _1 :: _1 :: Nil
        val xs: xs = _1 :: _1 :: _1 :: Nil
        type p   = term[_1]#repeat[_3, _3]
        val p: p = term(_1).repeat(_3, _3)
        type r = p#parse[xs]
        val r: r = p.parse(xs)
        Test.assertTrue[r#successful]
        assertTrue(r.successful.unsing)
        Test.assertSame[xs, r#get#force]
        assertEquals(xs, r.get)
        Test.assertSame[Nil, r#next#force]
        assertEquals(Nil, r.next)
    }

}
