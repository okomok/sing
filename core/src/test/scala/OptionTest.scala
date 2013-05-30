

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok.sing
import sing._
import junit.framework.Assert._
import nat.peano.Literal._
import nat.Peano


class OptionTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        type s = Some[Box[Int]]
        val s: s = Some(Box(3))
        val e: s#get = s.get
        val k: Int = e.unsing
        assertEquals(3, k)

        type n = None
        val n: n = None
        try {
            val e: n#get = n.get
            fail("never come here")
        } catch {
            case _: NoSuchElementException =>
        }
    }

    def testIsEmpty {
        {
            type s = Some[Box[Int]]
            val s: s = Some(Box(3))
            free.assertSame[`false`, s#isEmpty]
            val e: s#isEmpty = s.isEmpty
            val k: `false` = e
        }
        {
            type s = None
            val s: s = None
            free.assertSame[`true`, s#isEmpty]
            val e: s#isEmpty = s.isEmpty
            val k: `true` = e
        }
        ()
    }

    def testIsDefined {
        {
            type s = Some[Box[Int]]
            val s: s = Some(Box(3))
            free.assertSame[`true`, s#isDefined]
            val e: s#isDefined = s.isDefined
            val k: `true` = e
        }
        {
            type s = None
            val s: s = None
            free.assertSame[`false`, s#isDefined]
            val e: s#isEmpty = s.isEmpty
            val k: `true` = e
        }
        ()
    }

    def testUnsing {
        {
            type s = Some[Box[Int]]
            val s: s = Some(Box(3))
            free.assertSame[scala.Some[Int], s#unsing]
            val e: s#unsing = s.unsing
            assertEquals(scala.Some(3), e)
        }
        {
            type s = None
            val s: s = None
            free.assertSame[scala.None.type, s#unsing]
            val e: s#unsing = s.unsing
            assertSame(scala.None, s.unsing)
        }
        ()
    }


    def testMatch {
        val s = Some(Box(3))
        s match {
            case Some(Box(e)) => assertEquals(3, e)
            case _ => fail("doh")
        }

        val n: Option = None
        n match {
            case Some(e) => fail("doh")
            case None =>
        }
        ()
    }
/* Now crash!
    class natty {
         def apply[o <: Option{ type get <: Peano }](o: o): apply[o] = o.get.increment
        type apply[o <: Option{ type get <: Peano }] = o#get#increment
    }
    val natty = new natty

    def testNatty {
        type s = Some[_3]
        val s = Some(_3)
        free.assertSame[_4, natty#apply[s]]
        okomok.sing.assert(_4 equal natty(s))
    }
*/
    def testGetOrElse {
        type s = Some[_3]
        val s: s = Some(_3)
        free.assertSame[_3, s#getOrElse[const0[_8]]]
        val r: s#getOrElse[const0[_8]] = s.getOrElse(const0(_8))
        val k: _3 = r

        type n = None
        val n: n = None
        val q: n#getOrElse[const0[_8]] = n.getOrElse(const0(_8))
        val p: _8 = q
        ()
    }


    case class Plus1() extends Function1 {
        override type self = Plus1
        override def apply[n <: Any](n: n): apply[n] = n.asNat.increment
        override type apply[n <: Any] = n#asNat#increment
    }

    def testMapSome {
        type s = Some[_3]
        val s: s = Some(_3)
        free.assertSame[Some[_4], s#map[Plus1]]
        val m: s#map[Plus1] = s.map(Plus1())
        assertEquals(Some(_4), m)
    }

    def testMapNone {
        type s = None
        val s: s = None
        free.assertSame[None, s#map[Plus1]]
        val m: s#map[Plus1] = s.map(Plus1())
        assertEquals(None, m)
    }


    case class Plus1Get() extends Function1 {
        override type self = Plus1Get
        override def apply[n <: Any](n: n): apply[n] = Some(n.asNat.increment)
        override type apply[n <: Any] = Some[n#asNat#increment]
    }

    def testFlatMapSome {
        type s = Some[_3]
        val s: s = Some(_3)
        free.assertSame[Some[_4], s#flatMap[Plus1Get]]
        val m: s#flatMap[Plus1Get] = s.flatMap(Plus1Get())
        assertEquals(Some(_4), m)
    }

    def testFlatMapNone {
        type s = None
        val s: s = None
        free.assertSame[None, s#map[Plus1Get]]
        val m: s#flatMap[Plus1Get] = s.flatMap(Plus1Get())
        assertEquals(None, m)
    }


    case class Is2() extends Function1 {
        override type self = Is2
        override def apply[n <: Any](n: n): apply[n] = n.asNat equal _2
        override type apply[n <: Any] = n#asNat# equal[_2]
    }

    def testFilterSome {
        type s = Some[_3]
        val s: s = Some(_3)
        free.assertSame[None, s#filter[Is2]]
        val m: s#filter[Is2] = s.filter(Is2())
        assertEquals(None, m)
    }

    def testFilterSome2 {
        type s = Some[_2]
        val s: s = Some(_2)
        free.assertSame[Some[_2], s#filter[Is2]]
        val m: s#filter[Is2] = s.filter(Is2())
        assertEquals(Some(_2), m)
    }

    def testFilterNone {
        type s = None
        val s: s = None
        free.assertSame[None, s#filter[Is2]]
        val m: s#filter[Is2] = s.filter(Is2())
        assertEquals(None, m)
    }


    def testExistsSome {
        type s = Some[_3]
        val s: s = Some(_3)
        free.assertSame[`false`, s#exists[Is2]]
        val m: s#exists[Is2] = s.exists(Is2())
        assertEquals(`false`, m)
    }

    def testExistsSome2 {
        type s = Some[_2]
        val s: s = Some(_2)
        free.assertSame[`true`, s#exists[Is2]]
        val m: s#exists[Is2] = s.exists(Is2())
        assertEquals(`true`, m)
    }

    def testExistsNone {
        type s = None
        val s: s = None
        free.assertSame[`false`, s#exists[Is2]]
        val m: s#exists[Is2] = s.exists(Is2())
        assertEquals(`false`, m)
    }


    case class AddTo(result: java.util.ArrayList[Int]) extends Function1 {
        override type self = AddTo
        override def apply[n <: Any](n: n): apply[n] = { result.add(n.asNat.unsing); Unit }
        override type apply[n <: Any] = Unit
    }

    def testForeachSome {
        type adder = AddTo
        val adder: adder = AddTo(new java.util.ArrayList[Int])
        type s = Some[_2]
        val s: s = Some(_2)
        free.assertSame[Unit, s#foreach[adder]]
        val m: s#foreach[adder] = s.foreach(adder)
        assertEquals(1, adder.result.size)
        assertEquals(2, adder.result.get(0))
    }

    def testForeachNone {
        type adder = AddTo
        val adder: adder = AddTo(new java.util.ArrayList[Int])
        type s = None
        val s: s = None
        free.assertSame[Unit, s#foreach[adder]]
        val m: s#foreach[adder] = s.foreach(adder)
        assertTrue(adder.result.isEmpty)
    }


    case class Some4() extends Function0 {
        override type self = Some4
        override def apply: apply = Some(_4)
        override type apply = Some[_4]
    }

    def testOrElseSome {
        type s = Some[_3]
        val s: s = Some(_3)
        free.assertSame[Some[_3], s#orElse[Some4]]
        val m: s#orElse[Some4] = s.orElse(Some4())
        assertEquals(Some(_3), m)
    }

    def testOrElseNone {
        type s = None
        val s: s = None
        free.assertSame[Some[_4], s#orElse[Some4]]
        val m: s#orElse[Some4] = s.orElse(Some4())
        assertEquals(Some(_4), m)
    }

    def testNaturalOrdering1 {
        val s = Some(_5)
        val t = Some(_6)
        free.assert(s.naturalOrdering.lt(s, t))
    }

    def testNaturalOrdering2 {
        val s = None
        val t = Some(_6)
        free.assert(s.naturalOrdering.lt(s, t))
    }

    def testNaturalOrdering3 {
        val s = Some(_6)
        val t = Some(_6)
        free.assert(s.naturalOrdering.equiv(s, t))
    }

    def testNaturalOrdering4 {
        val s = None
        val t = None
        free.assert(s.naturalOrdering.equiv(s, t))
    }

    def testLift {
        val x = Option.lift(scala.None)
        assertEquals(scala.None, x.unsing)
        val y = Option.lift(scala.Some(15))
        val scala.Some(15) = y.unsing
        ()
    }

}
