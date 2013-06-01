

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest
package singtest; package maptest


import com.github.okomok

import okomok.sing._
import nat.peano.Literal._
import junit.framework.Assert._


class RemoveTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type o = nat.naturalOrdering
        val o: o = nat.naturalOrdering

        type m = map.sorted[o]#put[_3, _Box[Int]]#put[_5, _Box[Char]]#put[_1, _Box[String]]
        val m: m = map.sorted(o).put(_3, _Box(3)).put(_5, _Box('c')).put(_1, _Box("wow"))
        AssertInvariant(m)

        type rm = m#remove[_5]
        val rm: rm = m.remove(_5)
        weak.assertSame[nat.dense._2, rm#size]
        weak.assertSame[None, rm#get[_5]]
        AssertInvariant(rm)
        ()
    }

    def testTrivial1 {
        type m = Samples.m8
        val m: m = Samples.m8

        type rm = m#remove[_1]
        val rm: rm = m.remove(_1)
        weak.assertSame[nat.dense._8, rm#size]
        weak.assertSame[None, rm#get[_1]]
        AssertInvariant(rm)
        ()
    }

    def testTrivial3 {
        type m = Samples.m8
        val m: m = Samples.m8

        type rm = m#remove[_3]
        val rm: rm = m.remove(_3)
        weak.assertSame[nat.dense._8, rm#size]
        weak.assertSame[None, rm#get[_3]]
        AssertInvariant(rm)
        //println(rm)
        ()
    }

    def testTrivial8 {
        type m = Samples.m8
        val m: m = Samples.m8

        type rm = m#remove[_8]
        val rm: rm = m.remove(_8)
        weak.assertSame[nat.dense._8, rm#size]
        weak.assertSame[None, rm#get[_8]]
        AssertInvariant(rm)
        ()
    }

    def testTrivial14 {
        type m = Samples.m8
        val m: m = Samples.m8

        type rm = m#remove[_14]
        val rm: rm = m.remove(_14)
        weak.assertSame[nat.dense._8, rm#size]
        weak.assertSame[None, rm#get[_14]]
        AssertInvariant(rm)
        ()
    }

    def testTrivial6 {
        type m = Samples.m8
        val m: m = Samples.m8

        type rm = m#remove[_6]
        val rm: rm = m.remove(_6)
        weak.assertSame[nat.dense._8, rm#size]
        weak.assertSame[None, rm#get[_6]]
        AssertInvariant(rm)
        ()
    }

}
