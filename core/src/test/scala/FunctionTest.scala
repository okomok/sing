

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._
import okomok.sing.Peano.Literal._
import junit.framework.Assert._


class FunctionTest extends org.scalatest.junit.JUnit3Suite {

    final case class Plus() extends AsFunction2 {
        override type self = Plus
        override  def apply[n <: Any, m <: Any](n: n, m: m): apply[n, m] = n.asNat plus m.asNat
        override type apply[n <: Any, m <: Any] = n#asNat# plus [m#asNat]
    }

    def testCurried {
        type c = Plus#curried
        val c: c = Plus().curried

        type a = c#apply[_3]
        val a: a = c.apply(_3)

        type b = a#apply[_2]
        val b: b = a.apply(_2)

        val z: _5 = b
        okomok.sing.assert(b equal _5)
        val d: c#apply[_4]#apply[_5] = c(_4)(_5)
        okomok.sing.assert(d equal _9)
    }

    def testTupled {
        type c = Plus#tupled
        val c: c = Plus().tupled

        type k = c#apply[Tuple2[_3, _4]]
        val k : k = c.apply(Tuple2(_3, _4))

        val r: _7 = k
        okomok.sing.assert(k equal _7)
        ()
    }

    final case class Plus2() extends AsFunction1 {
        override type self = Plus2
        override  def apply[n <: Any](n: n): apply[n] = n.asNat plus _2
        override type apply[n <: Any] = n#asNat# plus [_2]
    }

    final case class Minus3() extends AsFunction1 {
        override type self = Minus3
        override  def apply[n <: Any](n: n): apply[n] = n.asNat minus _3
        override type apply[n <: Any] = n#asNat# minus [_3]
    }

    def testCompose {
        type c = Plus2#compose[Minus3]
        val c: c = Plus2().compose(Minus3())
        val r: c#apply[_5] = c.apply(_5)
        okomok.sing.assert(r equal _4)
        val k: _4 = r
        ()
    }

    def testAndThen {
        val k: _3 = Minus3().andThen(Plus2())(_4)
        try {
            Minus3().andThen(Plus2()).apply(_2)
            fail("never come here")
        } catch {
            case _: UnsupportedOperationException =>
        }
        ()
    }


    final case class PlusTimes() extends AsFunction3 {
        override type self = PlusTimes
        override  def apply[n <: Any, m <: Any, u <: Any](n: n, m: m, u: u): apply[n, m, u] =
            n.asNat.plus(m.asNat).times(u.asNat).asInstanceOf[apply[n, m, u]]
        override type apply[n <: Any, m <: Any, u <: Any] =
            n#asNat#plus[m#asNat]#times[u#asNat]
    }

    def testCurried3 {
        type c = PlusTimes#curried
        val c: c = PlusTimes().curried

        type a = c#apply[_2]
        val a: a = c.apply(_2)

        type b = a#apply[_1]
        val b: b = a.apply(_1)

        val z: b#apply[_3] = b.apply(_3)
        Test.cassert(z equal _9)
        val d: c#apply[_2]#apply[_1]#apply[_3] = c(_2)(_1)(_3)
        Test.cassert(d equal _9)
    }

    def testTupled3 {
        type c = PlusTimes#tupled
        val c: c = PlusTimes().tupled
        Test.cassert(c(Tuple3(_2, _1, _3)) equal _9)
    }

    def testTupledLeft3 {
        type c = PlusTimes#tupledLeft
        val c: c = PlusTimes().tupledLeft
        Test.cassert(c(Pair(Pair(_2, _1), _3)) equal _9)
    }

}
