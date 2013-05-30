

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
object Minus {
     def apply[xs <: Dense, ys <: Dense](xs: xs, ys: ys): apply[xs, ys] =
        Match(xs, ys,
            const0(Nil),
            throw0(new UnsupportedOperationException("sing.nat.dense.Nil.subtract positive")),
            const0(xs),
            ConsMatch(xs, ys,
                CaseXX(xs, ys),
                CaseTF(xs, ys),
                CaseFT(xs, ys),
                CaseXX(xs, ys)
            )
        ).apply.asNat.asDense.asInstanceOf[apply[xs, ys]]

    type apply[xs <: Dense, ys <: Dense] =
        Match[xs, ys,
            const0[Nil],
            throw0[_],
            const0[xs],
            ConsMatch[xs, ys,
                CaseXX[xs, ys],
                CaseTF[xs, ys],
                CaseFT[xs, ys],
                CaseXX[xs, ys]
            ]
        ]#apply#asNat#asDense

    case class CaseXX[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends Function0 {
        type self = CaseXX[xs, ys]
        override  def apply: apply = ConsFalse.apply(xs.tail.minus(ys.tail)).asInstanceOf[apply]
        override type apply        = ConsFalse.apply[xs#tail#minus[ys#tail]]
    }

    case class CaseTF[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends Function0 {
        type self = CaseTF[xs, ys]
        private[this]   def xst_sub_yst: xst_sub_yst = xs.tail.minus(ys.tail).asInstanceOf[xst_sub_yst]
        private[this]  type xst_sub_yst              = xs#tail#minus[ys#tail]
        override  def apply: apply = Cons(`true`, xst_sub_yst)
        override type apply        = Cons[`true`, xst_sub_yst]
    }

    case class CaseFT[xs <: Dense, ys <: Dense](xs: xs, ys: ys) extends Function0 {
        type self = CaseFT[xs, ys]
        override  def apply: apply = Cons(`true`, xs.tail.decrement.minus(ys.tail)).asInstanceOf[apply]
        override type apply        = Cons[`true`, xs#tail#decrement#minus[ys#tail]]
    }
}
