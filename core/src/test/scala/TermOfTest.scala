

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import junit.framework.Assert._
//import nat.Operator._


class TermOfTest extends org.scalatest.junit.JUnit3Suite {

     def testBoolean {
        type r = `true`
        val r: `true` = weak.termOf[r]
        assertEquals(`true`, r)
        type s = `false`
        val s: `false` = weak.termOf[s]
        assertEquals(`false`, s)

        weak.assertSame[`true`, weak.typeOf(`true`)]
        weak.assertSame[`true`, weak.typeOf(r)]
        weak.assertSame[`true`, weak.typeOf(sing.`true`)]

    }

    def testUnit {
        type r = Unit
        val r: Unit = weak.termOf[r]
        assertSame(Unit, r)
    }

    def testListNil {
        type l = Nil
        val l: Nil = weak.termOf[l]
        assertSame(Nil, l)
    }

    def testBackwardCompatiblity {
        type r = Unit
        val r: Unit = unmeta[r]
        assertSame(Unit, r)
    }

}


class TermOfNatPeanoTest extends org.scalatest.junit.JUnit3Suite {

    import nat.peano.Literal._

    def testNatPeano {
        type r = _1#plus[_3]#plus[_4]
        val r: _8 = weak.termOf[r]
        assertEquals(_8, r)
        assertEquals(8, r.unsing)
    }

    def testNatPeanoList {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: _3 :: Nil = weak.termOf[l]
        assertEquals(_1 :: _2 :: _3 :: Nil, l)
    }

    def testNatPeanoListTake {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: Nil = weak.termOf[l#take[_2]#force]
        assertEquals(_1 :: _2 :: Nil, l)
    }

}


class TermOfNatDenseTest extends org.scalatest.junit.JUnit3Suite {

    import nat.dense.Literal._

    def testNatDense {
        type r = _1#plus[_3]#plus[_4]
        val r: _8 = weak.termOf[r]
        assertEquals(_8, r)
        assertEquals(8, r.unsing)
    }

    def testNatDenseList {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: _3 :: Nil = weak.termOf[l]
        assertEquals(_1 :: _2 :: _3 :: Nil, l)
    }

    def testNatDenseListTake {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: Nil = weak.termOf[l#take[_2]#force]
        assertEquals(_1 :: _2 :: Nil, l)
    }

}
