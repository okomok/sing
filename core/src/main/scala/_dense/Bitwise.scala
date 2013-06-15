

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _dense


private[sing]
object BitAnd {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys, Const(DNil), Const(DNil), Const(DNil),
            DConsMatch(xs, ys, CaseTT(xs, ys), Else(xs, ys), Else(xs, ys), Else(xs, ys))).apply.asNat.asDense
    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys, Const[DNil], Const[DNil], Const[DNil],
            DConsMatch[xs, ys, CaseTT[xs, ys], Else[xs, ys], Else[xs, ys], Else[xs, ys]]]#apply#asNat#asDense

    case class CaseTT[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseTT[xs, ys]
        private[this]   def xst_and_yst: xst_and_yst = xs.tail.bitAnd(ys.tail)
        private[this]  type xst_and_yst              = xs#tail#bitAnd[ys#tail]
        override  def apply: apply = DCons(`true`, xst_and_yst)
        override type apply        = DCons[`true`, xst_and_yst]
    }

    case class Else[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = Else[xs, ys]
        override  def apply: apply = id(xs).tail.bitAnd(id(ys).tail).shiftLeft
        override type apply        = id[xs]#tail#bitAnd[id[ys]#tail]#shiftLeft
    }
}


private[sing]
object BitOr {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys, Const(DNil), Const(ys), Const(xs),
            DConsMatch(xs, ys, Else(xs, ys), Else(xs, ys), Else(xs, ys), CaseFF(xs, ys))).apply.asNat.asDense
    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys, Const[DNil], Const[ys], Const[xs],
            DConsMatch[xs, ys, Else[xs, ys], Else[xs, ys], Else[xs, ys], CaseFF[xs, ys]]]#apply#asNat#asDense

    case class CaseFF[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseFF[xs, ys]
        private[this]   def xst_or_yst: xst_or_yst = xs.tail.bitOr(ys.tail)
        private[this]  type xst_or_yst             = xs#tail#bitOr[ys#tail]
        override  def apply: apply = DCons(`false`, xst_or_yst)
        override type apply        = DCons[`false`, xst_or_yst]
    }

    case class Else[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = Else[xs, ys]
        private[this]   def xst_or_yst: xst_or_yst = xs.tail.bitOr(ys.tail)
        private[this]  type xst_or_yst             = xs#tail#bitOr[ys#tail]
        override  def apply: apply = DCons(`true`, xst_or_yst)
        override type apply        = DCons[`true`, xst_or_yst]
    }
}
