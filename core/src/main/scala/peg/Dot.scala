

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
object Dot {
     def apply: apply = new Impl
    type apply        =     Impl

    final class Impl extends AbstractPeg with OneWidth {
        type self = Impl

        override  def parse[xs <: List](xs: xs): parse[xs] =
            `if`(xs.isEmpty, const0(PegFailure(xs)), Else(xs)).apply.asPegResult//.asInstanceOf[parse[xs]]
        override type parse[xs <: List] =
            `if`[xs#isEmpty, const0[PegFailure[xs]], Else[xs]]#apply#asPegResult
    }

    final case class Else[xs <: List](xs: xs) extends Function0 {
        type self = Else[xs]
        override  def apply: apply = PegSuccess(xs.head, xs.tail)
        override type apply        = PegSuccess[xs#head, xs#tail]
    }
}
