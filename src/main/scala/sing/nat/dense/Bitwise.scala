

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
object BitAnd {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys, const0(Nil), const0(Nil), const0(Nil),
            ConsMatch(xs, ys, CaseTT(xs, ys), Else(xs, ys), Else(xs, ys), Else(xs, ys))).apply.asNat.asDense.asInstanceOf[apply[xs, ys]]
    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys, const0[Nil], const0[Nil], const0[Nil],
            ConsMatch[xs, ys, CaseTT[xs, ys], Else[xs, ys], Else[xs, ys], Else[xs, ys]]]#apply#asNat#asDense

    case class CaseTT[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends Function0 {
        type self = CaseTT[xs, ys]
        private   def xst_and_yst: xst_and_yst = xs.tail.bitAnd(ys.tail).asInstanceOf[xst_and_yst]
        private  type xst_and_yst              = xs#tail#bitAnd[ys#tail]
        override  def apply: apply = Cons(`true`, xst_and_yst)
        override type apply        = Cons[`true`, xst_and_yst]
    }

    case class Else[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends Function0 {
        type self = Else[xs, ys]
        override  def apply: apply = ConsFalse.apply(xs.tail.bitAnd(ys.tail)).asInstanceOf[apply]
        override type apply        = ConsFalse.apply[xs#tail#bitAnd[ys#tail]]
    }
}


private[sing]
object BitOr {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys, const0(Nil), const0(ys), const0(xs),
            ConsMatch(xs, ys, Else(xs, ys), Else(xs, ys), Else(xs, ys), CaseFF(xs, ys))).apply.asNat.asDense.asInstanceOf[apply[xs, ys]]
    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys, const0[Nil], const0[ys], const0[xs],
            ConsMatch[xs, ys, Else[xs, ys], Else[xs, ys], Else[xs, ys], CaseFF[xs, ys]]]#apply#asNat#asDense

    case class CaseFF[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends Function0 {
        type self = CaseFF[xs, ys]
        private   def xst_or_yst: xst_or_yst = xs.tail.bitOr(ys.tail).asInstanceOf[xst_or_yst]
        private  type xst_or_yst             = xs#tail#bitOr[ys#tail]
        override  def apply: apply = Cons(`false`, xst_or_yst)
        override type apply        = Cons[`false`, xst_or_yst]
    }

    case class Else[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends Function0 {
        type self = Else[xs, ys]
        private   def xst_or_yst: xst_or_yst = xs.tail.bitOr(ys.tail).asInstanceOf[xst_or_yst]
        private  type xst_or_yst             = xs#tail#bitOr[ys#tail]
        override  def apply: apply = Cons(`true`, xst_or_yst)
        override type apply        = Cons[`true`, xst_or_yst]
    }
}
