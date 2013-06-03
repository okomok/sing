

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package dense


private[sing]
object BitAnd {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys, const0(DNil), const0(DNil), const0(DNil),
            DConsMatch(xs, ys, CaseTT(xs, ys), Else(xs, ys), Else(xs, ys), Else(xs, ys))).apply.asNat.asDense.asInstanceOf[apply[xs, ys]]
    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys, const0[DNil], const0[DNil], const0[DNil],
            DConsMatch[xs, ys, CaseTT[xs, ys], Else[xs, ys], Else[xs, ys], Else[xs, ys]]]#apply#asNat#asDense

    case class CaseTT[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseTT[xs, ys]
        private[this]   def xst_and_yst: xst_and_yst = xs.tail.bitAnd(ys.tail).asInstanceOf[xst_and_yst]
        private[this]  type xst_and_yst              = xs#tail#bitAnd[ys#tail]
        override  def apply: apply = DCons(`true`, xst_and_yst)
        override type apply        = DCons[`true`, xst_and_yst]
    }

    case class Else[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = Else[xs, ys]
        override  def apply: apply = DConsFalse.apply(xs.tail.bitAnd(ys.tail)).asInstanceOf[apply]
        override type apply        = DConsFalse.apply[xs#tail#bitAnd[ys#tail]]
    }
}


private[sing]
object BitOr {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys, const0(DNil), const0(ys), const0(xs),
            DConsMatch(xs, ys, Else(xs, ys), Else(xs, ys), Else(xs, ys), CaseFF(xs, ys))).apply.asNat.asDense.asInstanceOf[apply[xs, ys]]
    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys, const0[DNil], const0[ys], const0[xs],
            DConsMatch[xs, ys, Else[xs, ys], Else[xs, ys], Else[xs, ys], CaseFF[xs, ys]]]#apply#asNat#asDense

    case class CaseFF[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseFF[xs, ys]
        private[this]   def xst_or_yst: xst_or_yst = xs.tail.bitOr(ys.tail).asInstanceOf[xst_or_yst]
        private[this]  type xst_or_yst             = xs#tail#bitOr[ys#tail]
        override  def apply: apply = DCons(`false`, xst_or_yst)
        override type apply        = DCons[`false`, xst_or_yst]
    }

    case class Else[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = Else[xs, ys]
        private[this]   def xst_or_yst: xst_or_yst = xs.tail.bitOr(ys.tail).asInstanceOf[xst_or_yst]
        private[this]  type xst_or_yst             = xs#tail#bitOr[ys#tail]
        override  def apply: apply = DCons(`true`, xst_or_yst)
        override type apply        = DCons[`true`, xst_or_yst]
    }
}
