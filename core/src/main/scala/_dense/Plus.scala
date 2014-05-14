

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _dense


private[sing]
object Plus {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys, Const(DNil), Const(ys), Const(xs),
            DConsMatch(xs, ys, CaseTT(xs, ys), CaseXF(xs, ys), CaseFX(xs, ys), CaseXF(xs, ys))).apply.asNat.asDense
    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys, Const[DNil], Const[ys], Const[xs],
            DConsMatch[xs, ys, CaseTT[xs, ys], CaseXF[xs, ys], CaseFX[xs, ys], CaseXF[xs, ys]]]#apply#asNat#asDense

    case class CaseTT[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseTT[xs, ys]
        override  def apply: apply = DCons(`false`, id(xs).tail.plus(id(ys).tail).increment)
        override type apply        = DCons[`false`, id[xs]#tail#plus[id[ys]#tail]#increment]
    }

    case class CaseXF[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseXF[xs, ys]
        private[this]   def xst_add_yst: xst_add_yst = xs.tail.plus(ys.tail)
        private[this]  type xst_add_yst              = xs#tail#plus[ys#tail]
        override  def apply: apply = DCons(xs.head, xst_add_yst)
        override type apply        = DCons[xs#head, xst_add_yst]
    }

    case class CaseFX[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseFX[xs, ys]
        private[this]   def xst_add_yst: xst_add_yst = xs.tail.plus(ys.tail)
        private[this]  type xst_add_yst              = xs#tail#plus[ys#tail]
        override  def apply: apply = DCons(ys.head, xst_add_yst)
        override type apply        = DCons[ys#head, xst_add_yst]
    }
}
