

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
object Or {
     def apply[p <: Peg, q <: Peg](p: p, q: q): apply[p, q] = Impl(p, q)
    type apply[p <: Peg, q <: Peg]                          = Impl[p, q]

    final case class Impl[p <: Peg, q <: Peg](p: p, q: q) extends AsPeg {
        override type self = Impl[p, q]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(p.parse(xs), xs)
        override type parse[xs <: List]                    = _aux[p#parse[xs], xs]

        private[this] lazy val pw: pw = p.width
        private[this]     type pw     = p#width

        override  def width: width =
            `if`(pw.equal(q.width), Const(pw), Throw(new UnsupportedOperationException("sing.peg.or.width"))).apply.asNat.asInstanceOf[width]
        override type width =
            `if`[pw#equal[q#width], Const[pw], Throw]#apply#asNat

        private[this]  def _aux[r <: PegResult, xs <: List](r: r, xs: xs): _aux[r, xs] =
            `if`(r.successful, Const(r), Else(q, xs)).apply.asPegResult
        private[this] type _aux[r <: PegResult, xs <: List] =
            `if`[r#successful, Const[r], Else[q, xs]]#apply#asPegResult
    }

    final case class Else[q <: Peg, xs <: List](q: q, xs: xs) extends AsFunction0 {
        override type self = Else[q, xs]
        override  def apply: apply = q.parse(xs)
        override type apply        = q#parse[xs]
    }
/*
    final case class Then[r <: PegResult](r: r) extends AsFunction0 {
        override type self = Then[r]
        override  def apply: apply = PegSuccess(Left(r.get), r.next)
        override type apply        = PegSuccess[Left[r#get], r#next]
    }

    final case class Else[q <: Peg, xs <: List](q: q, xs: xs) extends AsFunction0 {
        override type self = Else[q, xs]
        override  def apply: apply = q.parse(xs).map(MakeRight).asInstanceOf[apply]
        override type apply        = q#parse[xs]#map[MakeRight]
    }

    val MakeRight = new MakeRight
    final class MakeRight extends AsFunction1 {
        override type self = MakeRight
        override  def apply[b <: Any](b: b): apply[b] = Right(b)
        override type apply[b <: Any]                 = Right[b]
    }
*/
}
