

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package peg


private[sing]
object Repeat {
     def apply[p <: Peg, n <: Nat, m <: Nat](p: p, n: n, m: m): apply[p, n, m] =
        `if`(n.isZero, RepeatAtMost.Make(p, m), const0(Impl(p, n, m))).apply.asPeg.asInstanceOf[apply[p, n, m]]
    type apply[p <: Peg, n <: Nat, m <: Nat] =
        `if`[n#isZero, RepeatAtMost.Make[p, m], const0[Impl[p, n, m]]]#apply#asPeg

    final case class Impl[p <: Peg, n <: Nat, m <: Nat](p: p, n: n, m: m) extends AbstractPeg {
        assert(n.lteq(m)) // `const0` takes a by-name argument.

        type self = Impl[p, n, m]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(p.parse(xs), xs)
        override type parse[xs <: List]                    = _aux[p#parse[xs], xs]

        private  def _aux[r <: Result, xs <: List](r: r, xs: xs): _aux[r, xs] =
            `if`(r.successful, Then(p, r, n, m, xs), const0(r)).apply.asPegResult.asInstanceOf[_aux[r, xs]]
        private type _aux[r <: Result, xs <: List] =
            `if`[r#successful, Then[p, r, n, m, xs], const0[r]]#apply#asPegResult
    }

    final case class Then[p <: Peg, r <: Result, n <: Nat, m <: Nat, xs <: List](p: p, r: r, n: n, m: m, xs: xs) extends Function0 {
        type self = Then[p, r, n, m, xs]
        private lazy val s: s = Repeat.apply(p, n.decrement, m.decrement).parse(r.next).asInstanceOf[s]
        private     type s    = Repeat.apply[p, n#decrement, m#decrement]#parse[r#next]
        override  def apply: apply = `if`(s.successful, ThenThen(r, s), const0(Failure(xs))).apply
        override type apply        = `if`[s#successful, ThenThen[r, s], const0[Failure[xs]]]#apply
    }

    final case class ThenThen[r <: Result, s <: Result](r: r, s: s) extends Function0 {
        type self = ThenThen[r, s]
        override  def apply: apply = Success(r.get :: s.get.asList, s.next)
        override type apply        = Success[r#get :: s#get#asList, s#next]
    }

    private  def safeDec[n <: Nat](n: n): safeDec[n] = `if`(n.isZero, const0(n), Dec(n)).apply.asNat
    private type safeDec[n <: Nat]                   = `if`[n#isZero, const0[n], Dec[n]]#apply#asNat

    final case class Dec[n <: Nat](n: n) extends Function0 {
        type self = Dec[n]
        override  def apply: apply = n.decrement
        override type apply        = n#decrement
    }
}


private[sing]
object RepeatAtMost {
     def apply[p <: Peg, n <: Nat](p: p, n: n): apply[p, n] =
        `if`(n.isZero, const0(eps), const0(Impl(p, n))).apply.asPeg.asInstanceOf[apply[p, n]]
    type apply[p <: Peg, n <: Nat] =
        `if`[n#isZero, const0[eps], const0[Impl[p, n]]]#apply#asPeg

    final case class Impl[p <: Peg, n <: Nat](p: p, n: n) extends AbstractPeg {
        type self = Impl[p, n]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(p.parse(xs))
        override type parse[xs <: List]                    = _aux[p#parse[xs]]

        private  def _aux[r <: Result](r: r): _aux[r] =
            `if`(r.successful, Then(p, r, n), const0(Success(Nil, r.next))).apply.asPegResult.asInstanceOf[_aux[r]]
        private type _aux[r <: Result] =
            `if`[r#successful, Then[p, r, n], const0[Success[Nil, r#next]]]#apply#asPegResult
    }

    final case class Then[p <: Peg, r <: Result, n <: Nat](p: p, r: r, n: n) extends Function0 {
        type self = Then[p, r, n]
        override  def apply: apply = RepeatAtMost.apply(p, n.decrement).parse(r.next).map(MakeCons(r.get)).asInstanceOf[apply]
        override type apply        = RepeatAtMost.apply[p, n#decrement]#parse[r#next]#map[MakeCons[r#get]]
    }

    final case class Make[p <: Peg, n <: Nat](p: p, n: n) extends Function0 {
        type self = Make[p, n]
        override  def apply: apply = RepeatAtMost.apply(p, n)
        override type apply        = RepeatAtMost.apply[p, n]
    }
}
