

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
object FromList {
     def apply[ys <: List](ys: ys): apply[ys] = Impl(ys)
    type apply[ys <: List]                    = Impl[ys]

    final case class Impl[ys <: List](ys: ys) extends PegImpl {
        type self = Impl[ys]

        override  def parse[xs <: List](xs: xs): parse[xs] = _aux(StartsWith.apply(xs, ys, None), xs)
        override type parse[xs <: List]                    = _aux[StartsWith.apply[xs, ys, None], xs]

        private[this]  def _aux[r <: Option, xs <: List](r: r, xs: xs): _aux[r, xs] =
            `if`(r.isEmpty, const0(PegFailure(xs)), Else(r)).apply.asPegResult.asInstanceOf[_aux[r, xs]]
        private[this] type _aux[r <: Option, xs <: List] =
            `if`[r#isEmpty, const0[PegFailure[xs]], Else[r]]#apply#asPegResult

        override  def width: width = ys.length
        override type width        = ys#length
    }

    final case class Else[r <: Option](r: r) extends Function0 {
        type self = Else[r]
        private[this] lazy val p: p = r.get.asProduct2
        private[this]     type p    = r#get#asProduct2
        override  def apply: apply = PegSuccess(p._1, p._2.asList)
        override type apply        = PegSuccess[p#_1, p#_2#asList]
    }
}
