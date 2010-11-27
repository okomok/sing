

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


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

        type m = map.sorted[o]#put[_3, Box[Int]]#put[_5, Box[Char]]#put[_1, Box[String]]
        val m: m = map.sorted(o).put(_3, Box(3)).put(_5, Box('c')).put(_1, Box("wow"))
        AssertInvariant(m)

        type rm = m#remove[_5]
        val rm: rm = m.remove(_5)
        free.assertSame[nat.dense._2, rm#size]
        free.assertSame[None, rm#get[_5]]
        AssertInvariant(rm)
        ()
    }

    def testTrivial1 {
        type m = Samples.m8
        val m: m = Samples.m8

        type rm = m#remove[_1]
        val rm: rm = m.remove(_1)
        free.assertSame[nat.dense._8, rm#size]
        free.assertSame[None, rm#get[_1]]
        AssertInvariant(rm)
        ()
    }

    def testTrivial3 {
        type m = Samples.m8
        val m: m = Samples.m8

        type rm = m#remove[_3]
        val rm: rm = m.remove(_3)
        free.assertSame[nat.dense._8, rm#size]
        free.assertSame[None, rm#get[_3]]
        AssertInvariant(rm)
        //println(rm)
        ()
    }

    def testTrivial8 {
        type m = Samples.m8
        val m: m = Samples.m8

        type rm = m#remove[_8]
        val rm: rm = m.remove(_8)
        free.assertSame[nat.dense._8, rm#size]
        free.assertSame[None, rm#get[_8]]
        AssertInvariant(rm)
        ()
    }

    def testTrivial14 {
        type m = Samples.m8
        val m: m = Samples.m8

        type rm = m#remove[_14]
        val rm: rm = m.remove(_14)
        free.assertSame[nat.dense._8, rm#size]
        free.assertSame[None, rm#get[_14]]
        AssertInvariant(rm)
        ()
    }

    def testTrivial6 {
        type m = Samples.m8
        val m: m = Samples.m8

        type rm = m#remove[_6]
        val rm: rm = m.remove(_6)
        free.assertSame[nat.dense._8, rm#size]
        free.assertSame[None, rm#get[_6]]
        AssertInvariant(rm)
        ()
    }

}
