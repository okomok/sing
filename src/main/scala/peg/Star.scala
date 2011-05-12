

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package peg


private[sing]
object Star {
     def apply[p <: Peg](p: p): apply[p] = Impl(p)
    type apply[p <: Peg]                 = Impl[p]

    final case class Impl[p <: Peg](p: p) extends AbstractPeg {
        type self = Impl[p]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(p.parse(xs))
        override type parse[xs <: List]                    = _aux[p#parse[xs]]

        private[this]  def _aux[r <: Result](r: r): _aux[r] =
            `if`(r.successful, Then(p, r), const0(Success(Nil, r.next))).apply.asPegResult.asInstanceOf[_aux[r]]
        private[this] type _aux[r <: Result] =
            `if`[r#successful, Then[p, r], const0[Success[Nil, r#next]]]#apply#asPegResult
    }

    final case class Then[p <: Peg, r <: Result](p: p, r: r) extends Function0 {
        type self = Then[p, r]
        override  def apply: apply = Star.apply(p).parse(r.next).map(MakeCons(r.get)).asInstanceOf[apply]
        override type apply        = Star.apply[p]#parse[r#next]#map[MakeCons[r#get]]
    }
}
