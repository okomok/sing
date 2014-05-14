

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _list


private[sing]
object LexicographicalOrdering {
     def apply[eo <: Option](eo: eo): apply[eo] = Impl(eo)
    type apply[eo <: Option]                    = Impl[eo]

    case class Impl[eo <: Option](eo: eo) extends AsOrdering {
        override type self = Impl[eo]

        override  def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = Equal.apply(x.asList, y.asList, eo)
        override type equiv[x <: Any, y <: Any]                          = Equal.apply[x#asList, y#asList, eo]

        override  def compare[x <: Any, y <: Any](x: x, y: y): compare[x, y] = _compare(x.asList, y.asList)
        override type compare[x <: Any, y <: Any]                            = _compare[x#asList, y#asList]

        private[this]  def _compare[xs <: List, ys <: List](xs: xs, ys: ys): _compare[xs, ys] =
            `if`(id(xs).isEmpty,
                `if`(id(ys).isEmpty, Const(EQ), Const(LT)),
                `if`(id(ys).isEmpty, Const(GT), Else(xs, ys, eo))
            ).apply.asOrderingResult

        private[this] type _compare[xs <: List, ys <: List] =
            `if`[id[xs]#isEmpty,
                `if`[id[ys]#isEmpty, Const[EQ], Const[LT]],
                `if`[id[ys]#isEmpty, Const[GT], Else[xs, ys, eo]]
            ]#apply#asOrderingResult
    }

    case class Else[xs <: List, ys <: List, eo <: Option](xs: xs, ys: ys, eo: eo) extends AsFunction0 {
        override type self = Else[xs, ys, eo]
        private[this] lazy val _eo: _eo = eo.getOrNaturalOrdering(xs.head)
        private[this]     type _eo      = eo#getOrNaturalOrdering[xs#head]
        override  def apply: apply =
            id(_eo).`match`(id(xs).head, id(ys).head, Const(LT), Const(GT), CaseEQ(xs, ys, eo)).asOrderingResult
        override type apply =
            id[_eo]#`match`[id[xs]#head, id[ys]#head, Const[LT], Const[GT], CaseEQ[xs, ys, eo]]#asOrderingResult
    }

    case class CaseEQ[xs <: List, ys <: List, eo <: Option](xs: xs, ys: ys, eo: eo) extends AsFunction0 {
        override type self = CaseEQ[xs, ys, eo]
        override  def apply: apply = Impl(eo).compare(xs.tail, ys.tail)
        override type apply        = Impl[eo]#compare[xs#tail, ys#tail]
    }
}
