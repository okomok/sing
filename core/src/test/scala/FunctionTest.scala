

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomoktest; package singtest


import com.github.okomok
import okomok.sing._
import okomok.sing.Peano.Literal._
import junit.framework.Assert._


class FunctionTest extends org.scalatest.junit.JUnit3Suite {

    final case class Plus() extends Function2 {
        type self = Plus
        override  def apply[n <: Any, m <: Any](n: n, m: m): apply[n, m] = n.asNat plus m.asNat
        override type apply[n <: Any, m <: Any] = n#asNat# plus [m#asNat]
    }

    def testCurried {
        type c = Function2.curried[Plus]
        val c: c = Function2.curried(Plus())

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
        type c = Function2.tupled[Plus]
        val c: c = Function2.tupled(Plus())

        type k = c#apply[Tuple2[_3, _4]]
        val k : k = c.apply(Tuple2(_3, _4))

        val r: _7 = k
        okomok.sing.assert(k equal _7)
        ()
    }

    final case class Plus2() extends Function1 {
        type self = Plus2
        override  def apply[n <: Any](n: n): apply[n] = n.asNat plus _2
        override type apply[n <: Any] = n#asNat# plus [_2]
    }

    final case class Minus3() extends Function1 {
        type self = Minus3
        override  def apply[n <: Any](n: n): apply[n] = n.asNat minus _3
        override type apply[n <: Any] = n#asNat# minus [_3]
    }

    def testCompose {
        type c = Function1.compose[Plus2, Minus3]
        val c: c = Function1.compose(Plus2(), Minus3())
        val r: c#apply[_5] = c.apply(_5)
        okomok.sing.assert(r equal _4)
        val k: _4 = r
        ()
    }

    def testAndThen {
        val k: _3 = Function1.andThen(Minus3(), Plus2())(_4)
        try {
            Function1.andThen(Minus3(), Plus2()).apply(_2)
            fail("never come here")
        } catch {
            case _: UnsupportedOperationException =>
        }
        ()
    }


    final case class PlusTimes() extends Function3 {
        type self = PlusTimes
        override  def apply[n <: Any, m <: Any, u <: Any](n: n, m: m, u: u): apply[n, m, u] =
            n.asNat.plus(m.asNat).times(u.asNat).asInstanceOf[apply[n, m, u]]
        override type apply[n <: Any, m <: Any, u <: Any] =
            n#asNat#plus[m#asNat]#times[u#asNat]
    }

    def testCurried3 {
        type c = Function3.curried[PlusTimes]
        val c: c = Function3.curried(PlusTimes())

        type a = c#apply[_2]
        val a: a = c.apply(_2)

        type b = a#apply[_1]
        val b: b = a.apply(_1)

        val z: b#apply[_3] = b.apply(_3)
        Weak.assert(z equal _9)
        val d: c#apply[_2]#apply[_1]#apply[_3] = c(_2)(_1)(_3)
        Weak.assert(d equal _9)
    }

    def testTupled3 {
        type c = Function3.tupled[PlusTimes]
        val c: c = Function3.tupled(PlusTimes())
        Weak.assert(c(Tuple3(_2, _1, _3)) equal _9)
    }

    def testTupledLeft3 {
        type c = Function3.tupledLeft[PlusTimes]
        val c: c = Function3.tupledLeft(PlusTimes())
        Weak.assert(c(Pair(Pair(_2, _1), _3)) equal _9)
    }

}
