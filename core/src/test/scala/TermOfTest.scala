

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import junit.framework.Assert._
//import nat.Operator._


class _TermOfTest extends org.scalatest.junit.JUnit3Suite {

     def testBoolean {
        type r = `true`
        val r: `true` = termOf[r]
        assertEquals(`true`, r)
        type s = `false`
        val s: `false` = termOf[s]
        assertEquals(`false`, s)

        // named type for some lexical error
        val _tt = typeOf(`true`)
        type tt = _tt.apply

        val _tr = typeOf(r)
        type tr = _tr.apply

        val _tst = typeOf(sing.`true`)
        type tst = _tst.apply

        Test.assertEq[`true`, tt]
        Test.assertEq[`true`, tr]
        Test.assertEq[`true`, tst]
    }

    def testUnit {
        type r = Unit
        val r: Unit = termOf[r]
        assertSame(Unit, r)
    }

    def testListNil {
        type l = Nil
        val l: Nil = termOf[l]
        assertSame(Nil, l)
    }

}


class _TermOfNatPeanoTest extends org.scalatest.junit.JUnit3Suite {

    import Peano.Literal._

    def testNatPeano {
        type r = _1#plus[_3]#plus[_4]
        val r: _8 = termOf[r]
        assertEquals(_8, r)
        assertEquals(8, r.unsing)
    }

    def testNatPeanoList {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: _3 :: Nil = termOf[l]
        assertEquals(_1 :: _2 :: _3 :: Nil, l)
    }

    def testNatPeanoListTake {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: Nil = termOf[l#take[_2]#force]
        assertEquals(_1 :: _2 :: Nil, l)
    }

}


class _TermOfNatDenseTest extends org.scalatest.junit.JUnit3Suite {

    import Dense.Literal._

    def testNatDense {
        type r = _1#plus[_3]#plus[_4]
        val r: _8 = termOf[r]
        assertEquals(_8, r)
        assertEquals(8, r.unsing)
    }

    def testNatDenseList {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: _3 :: Nil = termOf[l]
        assertEquals(_1 :: _2 :: _3 :: Nil, l)
    }

    def testNatDenseListTake {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: Nil = termOf[l#take[_2]#force]
        assertEquals(_1 :: _2 :: Nil, l)
    }

}
