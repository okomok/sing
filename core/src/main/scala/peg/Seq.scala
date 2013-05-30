

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package peg


private[sing]
object Seq {
     def apply[p <: Peg, q <: Peg](p: p, q: q): apply[p, q] = Impl(p, q)
    type apply[p <: Peg, q <: Peg]                          = Impl[p, q]

    final case class Impl[p <: Peg, q <: Peg](p: p, q: q) extends AbstractPeg {
        type self = Impl[p, q]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(p.parse(xs), xs)
        override type parse[xs <: List]                    = _aux[p#parse[xs], xs]

        override  def width: width = p.width.plus(q.width)
        override type width        = p#width#plus[q#width]

        private[this]  def _aux[r <: Result, xs <: List](r: r, xs: xs): _aux[r, xs] =
            `if`(r.successful, Then(q, r, xs), const0(r)).apply.asPegResult
        private[this] type _aux[r <: Result, xs <: List] =
            `if`[r#successful, Then[q, r, xs], const0[r]]#apply#asPegResult
    }

    final case class Then[q <: Peg, r <: Result, xs <: List](q: q, r: r, xs: xs) extends Function0 {
        type self = Then[q, r, xs]

        private[this] lazy val s: s = q.parse(r.next)
        private[this]     type s    = q#parse[r#next]

        override  def apply: apply =
            `if`(s.successful, ThenThen(r, s), const0(Failure(xs))).apply.asPegResult
        override type apply =
            `if`[s#successful, ThenThen[r, s], const0[Failure[xs]]]#apply#asPegResult
    }

    final case class ThenThen[r <: Result, s <: Result](r: r, s: s) extends Function0 {
        type self = ThenThen[r, s]
        override  def apply: apply = Success(Pair(r.get, s.get), s.next)
        override type apply        = Success[Pair[r#get, s#get], s#next]
    }

    final case class MakePair[a <: Any](a: a) extends Function1 {
        type self = MakePair[a]
        override  def apply[b <: Any](b: b): apply[b] = Pair(a, b)
        override type apply[b <: Any]                 = Pair[a, b]
    }
}
