

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._

import junit.framework.Assert._

import scala.language.existentials


class BoxTest extends org.scalatest.junit.JUnit3Suite {

    def testList {
        val xs = 1 #:: 2 #:: Nil
        val x  = xs.head
        //val i: Int = x
        //assertEquals(1, i)
        ()
    }

    def testList2 {
        class Wow {
            def foo = ()
        }
        val xs = new Wow #:: "boxing" #:: Nil
        val x: Wow = xs.head.unsing
        //xs.head.foo
    }

    def testTuple {
        val t1 = Tuple.lift1(scala.Tuple1(1))
        val t2 = Tuple.lift2(1, 2)
        val t3 = Tuple.lift3(1, 2, 3)
        assertEquals(1, t1.unsing._1)
        assertEquals(2, t2.unsing._2)
        assertEquals(3, t3.unsing._3)
    }
/*
    def testListSingle {
        val xs = list.single(3)
        val x: Box[Int] = xs.head
        val ys = list.single(Box(3))
        val y: Box[Int] = ys.head
        ()
    }
    def testMap {
        import nat.dense.Literal._
        val m = map.sorted1(_3, 3).put(_2, 2).put(_4, 4)
        val v: Box[Int] = m.get(_2).get
        val i: Int = v
        assertEquals(2, i)
    }

    def testMap2 {
        import nat.dense.Literal._
        class Wow {
            def foo = ()
        }
        val m = map.sorted1(_3, 3).put(_2, new Wow).put(_4, 4)
        val v: Box[Wow] = m.get(_2).get
        m.get(_2).get.foo
    }

*/
}
