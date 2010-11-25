

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package peg


private[sing]
object Term {
     def apply[y <: Any](y: y): apply[y] = Impl(y)
    type apply[y <: Any]                 = Impl[y]

    final case class Impl[y <: Any](y: y) extends AbstractPeg with OneWidth {
        type self = Impl[y]

        override  def parse[xs <: List](xs: xs): parse[xs] =
            `if`(xs.isEmpty, const0(Failure(xs)), Else(y, xs)).apply.asPegResult//.asInstanceOf[parse[xs]]
        override type parse[xs <: List] =
            `if`[xs#isEmpty, const0[Failure[xs]], Else[y, xs]]#apply#asPegResult
    }

    final case class Else[y <: Any, xs <: List](y: y, xs: xs) extends Function0 {
        type self = Else[y, xs]
        private lazy val x: x = xs.head
        private     type x    = xs#head
        override  def apply: apply =
            `if`(y.naturalOrdering.equiv(y, x), const0(Success(x, xs.tail)), const0(Failure(xs))).apply.asInstanceOf[apply]
        override type apply =
            `if`[y#naturalOrdering#equiv[y, x], const0[Success[x, xs#tail]], const0[Failure[xs]]]#apply
    }
}
