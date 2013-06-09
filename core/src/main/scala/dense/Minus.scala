

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package dense


private[sing]
object Minus {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys,
            Const(DNil),
            Throw(new UnsupportedOperationException("sing.Dense.DNil.subtract positive")),
            Const(xs),
            DConsMatch(xs, ys,
                CaseXX(xs, ys),
                CaseTF(xs, ys),
                CaseFT(xs, ys),
                CaseXX(xs, ys)
            )
        ).apply.asNat.asDense.asInstanceOf[apply[xs, ys]]

    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys,
            Const[DNil],
            Throw,
            Const[xs],
            DConsMatch[xs, ys,
                CaseXX[xs, ys],
                CaseTF[xs, ys],
                CaseFT[xs, ys],
                CaseXX[xs, ys]
            ]
        ]#apply#asNat#asDense

    case class CaseXX[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseXX[xs, ys]
        override  def apply: apply = DConsFalse.apply(xs.tail.minus(ys.tail)).asInstanceOf[apply]
        override type apply        = DConsFalse.apply[xs#tail#minus[ys#tail]]
    }

    case class CaseTF[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseTF[xs, ys]
        private[this]   def xst_sub_yst: xst_sub_yst = xs.tail.minus(ys.tail).asInstanceOf[xst_sub_yst]
        private[this]  type xst_sub_yst              = xs#tail#minus[ys#tail]
        override  def apply: apply = DCons(`true`, xst_sub_yst)
        override type apply        = DCons[`true`, xst_sub_yst]
    }

    case class CaseFT[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends AsFunction0 {
        override type self = CaseFT[xs, ys]
        override  def apply: apply = DCons(`true`, xs.tail.decrement.minus(ys.tail)).asInstanceOf[apply]
        override type apply        = DCons[`true`, xs#tail#decrement#minus[ys#tail]]
    }
}
