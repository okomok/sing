

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
object Term {
     def apply[y <: Any](y: y): apply[y] = Impl(y)
    type apply[y <: Any]                 = Impl[y]

    final case class Impl[y <: Any](y: y) extends AsPeg with OneWidth {
        override type self = Impl[y]

        override  def parse[xs <: List](xs: xs): parse[xs] =
            `if`(xs.isEmpty, Const(PegFailure(xs)), Else(y, xs)).apply.asPegResult//.asInstanceOf[parse[xs]]
        override type parse[xs <: List] =
            `if`[xs#isEmpty, Const[PegFailure[xs]], Else[y, xs]]#apply#asPegResult
    }

    final case class Else[y <: Any, xs <: List](y: y, xs: xs) extends AsFunction0 {
        override type self = Else[y, xs]
        private[this] lazy val x: x = xs.head
        private[this]     type x    = xs#head
        override  def apply: apply =
            `if`(y.kind.naturalOrdering.equiv(y, x), Const(PegSuccess(x, xs.tail)), Const(PegFailure(xs))).apply.asInstanceOf[apply]
        override type apply =
            `if`[y#kind#naturalOrdering#equiv[y, x], Const[PegSuccess[x, xs#tail]], Const[PegFailure[xs]]]#apply
    }
}
