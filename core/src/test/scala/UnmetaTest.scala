

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import junit.framework.Assert._
//import nat.Operator._


class UnmetaTest extends org.scalatest.junit.JUnit3Suite {

     def testBoolean {
        type r = `true`
        val r: `true` = unmeta[r]
        assertEquals(`true`, r)
        type s = `false`
        val s: `false` = unmeta[s]
        assertEquals(`false`, s)
    }

    def testUnit {
        type r = Unit
        val r: Unit = unmeta[r]
        assertSame(Unit, r)
    }

    def testListNil {
        type l = Nil
        val l: Nil = unmeta[l]
        assertSame(Nil, l)
    }

}


class UnmetaNatPeanoTest extends org.scalatest.junit.JUnit3Suite {

    import nat.peano.Literal._

    def testNatPeano {
        type r = _1#plus[_3]#plus[_4]
        val r: _8 = unmeta[r]
        assertEquals(_8, r)
        assertEquals(8, r.unsing)
    }

    def testNatPeanoList {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: _3 :: Nil = unmeta[l]
        assertEquals(_1 :: _2 :: _3 :: Nil, l)
    }

    def testNatPeanoListTake {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: Nil = unmeta[l#take[_2]#force]
        assertEquals(_1 :: _2 :: Nil, l)
    }

}


class UnmetaNatDenseTest extends org.scalatest.junit.JUnit3Suite {

    import nat.dense.Literal._

    def testNatDense {
        type r = _1#plus[_3]#plus[_4]
        val r: _8 = unmeta[r]
        assertEquals(_8, r)
        assertEquals(8, r.unsing)
    }

    def testNatDenseList {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: _3 :: Nil = unmeta[l]
        assertEquals(_1 :: _2 :: _3 :: Nil, l)
    }

    def testNatDenseListTake {
        type l = _1 :: _2 :: _3 :: Nil
        val l: _1 :: _2 :: Nil = unmeta[l#take[_2]#force]
        assertEquals(_1 :: _2 :: Nil, l)
    }

}
