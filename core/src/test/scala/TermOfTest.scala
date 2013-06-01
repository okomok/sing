

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
        val r: `true` = Weak.termOf[r]
        assertEquals(`true`, r)
        type s = `false`
        val s: `false` = Weak.termOf[s]
        assertEquals(`false`, s)

        Weak.assertSame[`true`, Weak.typeOf(`true`)]
        Weak.assertSame[`true`, Weak.typeOf(r)]
        Weak.assertSame[`true`, Weak.typeOf(sing.`true`)]

    }

    def testUnit {
        type r = Unit
        val r: Unit = Weak.termOf[r]
        assertSame(Unit, r)
    }

    def testListNil {
        type l = Nil
        val l: Nil = Weak.termOf[l]
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
        val r: _8 = Weak.termOf[r]
        assertEquals(_8, r)
        assertEquals(8, r.unsing)
    }

    def testNatPeanoList {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: _3 :: Nil = Weak.termOf[l]
        assertEquals(_1 :: _2 :: _3 :: Nil, l)
    }

    def testNatPeanoListTake {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: Nil = Weak.termOf[l#take[_2]#force]
        assertEquals(_1 :: _2 :: Nil, l)
    }

}


class TermOfNatDenseTest extends org.scalatest.junit.JUnit3Suite {

    import nat.dense.Literal._

    def testNatDense {
        type r = _1#plus[_3]#plus[_4]
        val r: _8 = Weak.termOf[r]
        assertEquals(_8, r)
        assertEquals(8, r.unsing)
    }

    def testNatDenseList {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: _3 :: Nil = Weak.termOf[l]
        assertEquals(_1 :: _2 :: _3 :: Nil, l)
    }

    def testNatDenseListTake {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: Nil = Weak.termOf[l#take[_2]#force]
        assertEquals(_1 :: _2 :: Nil, l)
    }

}
