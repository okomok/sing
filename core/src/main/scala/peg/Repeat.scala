

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


import Peg.eps


private[sing]
object Repeat {
     def apply[p <: Peg, n <: Nat, m <: Nat](p: p, n: n, m: m): apply[p, n, m] =
        `if`(n.isZero, RepeatAtMost.Make(p, m), Const(Impl(p, n, m))).apply.asPeg.asInstanceOf[apply[p, n, m]]
    type apply[p <: Peg, n <: Nat, m <: Nat] =
        `if`[n#isZero, RepeatAtMost.Make[p, m], Const[Impl[p, n, m]]]#apply#asPeg

    final case class Impl[p <: Peg, n <: Nat, m <: Nat](p: p, n: n, m: m) extends AsPeg {
        assert(n.lteq(m)) // `Const` takes a by-name argument.

        override type self = Impl[p, n, m]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(p.parse(xs), xs)
        override type parse[xs <: List]                    = _aux[p#parse[xs], xs]

        private[this]  def _aux[r <: PegResult, xs <: List](r: r, xs: xs): _aux[r, xs] =
            `if`(r.successful, Then(p, r, n, m, xs), Const(r)).apply.asPegResult.asInstanceOf[_aux[r, xs]]
        private[this] type _aux[r <: PegResult, xs <: List] =
            `if`[r#successful, Then[p, r, n, m, xs], Const[r]]#apply#asPegResult
    }

    final case class Then[p <: Peg, r <: PegResult, n <: Nat, m <: Nat, xs <: List](p: p, r: r, n: n, m: m, xs: xs) extends AsFunction0 {
        override type self = Then[p, r, n, m, xs]
        private[this] lazy val s: s = Repeat.apply(p, n.decrement, m.decrement).parse(r.next).asInstanceOf[s]
        private[this]     type s    = Repeat.apply[p, n#decrement, m#decrement]#parse[r#next]
        override  def apply: apply = `if`(s.successful, ThenThen(r, s), Const(PegFailure(xs))).apply
        override type apply        = `if`[s#successful, ThenThen[r, s], Const[PegFailure[xs]]]#apply
    }

    final case class ThenThen[r <: PegResult, s <: PegResult](r: r, s: s) extends AsFunction0 {
        override type self = ThenThen[r, s]
        override  def apply: apply = PegSuccess(r.get :: s.get.asList, s.next)
        override type apply        = PegSuccess[r#get :: s#get#asList, s#next]
    }

    private[this]  def safeDec[n <: Nat](n: n): safeDec[n] = `if`(n.isZero, Const(n), Dec(n)).apply.asNat
    private[this] type safeDec[n <: Nat]                   = `if`[n#isZero, Const[n], Dec[n]]#apply#asNat

    final case class Dec[n <: Nat](n: n) extends AsFunction0 {
        override type self = Dec[n]
        override  def apply: apply = n.decrement
        override type apply        = n#decrement
    }
}


private[sing]
object RepeatAtMost {
     def apply[p <: Peg, n <: Nat](p: p, n: n): apply[p, n] =
        `if`(n.isZero, Const(eps), Const(Impl(p, n))).apply.asPeg.asInstanceOf[apply[p, n]]
    type apply[p <: Peg, n <: Nat] =
        `if`[n#isZero, Const[eps], Const[Impl[p, n]]]#apply#asPeg

    final case class Impl[p <: Peg, n <: Nat](p: p, n: n) extends AsPeg {
        override type self = Impl[p, n]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(p.parse(xs))
        override type parse[xs <: List]                    = _aux[p#parse[xs]]

        private[this]  def _aux[r <: PegResult](r: r): _aux[r] =
            `if`(r.successful, Then(p, r, n), Const(PegSuccess(Nil, r.next))).apply.asPegResult.asInstanceOf[_aux[r]]
        private[this] type _aux[r <: PegResult] =
            `if`[r#successful, Then[p, r, n], Const[PegSuccess[Nil, r#next]]]#apply#asPegResult
    }

    final case class Then[p <: Peg, r <: PegResult, n <: Nat](p: p, r: r, n: n) extends AsFunction0 {
        override type self = Then[p, r, n]
        override  def apply: apply = RepeatAtMost.apply(p, n.decrement).parse(r.next).map(MakeCons(r.get)).asInstanceOf[apply]
        override type apply        = RepeatAtMost.apply[p, n#decrement]#parse[r#next]#map[MakeCons[r#get]]
    }

    final case class Make[p <: Peg, n <: Nat](p: p, n: n) extends AsFunction0 {
        override type self = Make[p, n]
        override  def apply: apply = RepeatAtMost.apply(p, n)
        override type apply        = RepeatAtMost.apply[p, n]
    }
}
