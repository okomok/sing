

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


@Annotation.visibleForTesting
object StartsWith {
     def apply[xs <: List, ys <: List, eqv <: Option](xs: xs, ys: ys, eqv: eqv): apply[xs, ys, eqv] =
        `if`(ys.isEmpty,
            Const(Some(Pair(Nil, xs))),
            `if`(xs.isEmpty,
                Const(None),
                Else(xs, ys, eqv)
            )
        ).apply.asOption.asInstanceOf[apply[xs, ys, eqv]]
    type apply[xs <: List, ys <: List, eqv <: Option] =
        `if`[ys#isEmpty,
            Const[Some[Pair[Nil, xs]]],
            `if`[xs#isEmpty,
                Const[None],
                Else[xs, ys, eqv]
            ]
        ]#apply#asOption

    final case class Else[xs <: List, ys <: List, eqv <: Option](xs: xs, ys: ys, eqv: eqv) extends AsFunction0 {
        override type self = Else[xs, ys, eqv]
        private[this] lazy val _eqv: _eqv = eqv.getOrNaturalEquiv(xs.head)
        private[this]     type _eqv       = eqv#getOrNaturalEquiv[xs#head]
        override  def apply: apply =
            `if`(_eqv.equiv(xs.head, ys.head), ElseThen(xs, ys, eqv), Const(None)).apply.asInstanceOf[apply]
        override type apply =
            `if`[_eqv#equiv[xs#head, ys#head], ElseThen[xs, ys, eqv], Const[None]]#apply
    }

    final case class ElseThen[xs <: List, ys <: List, eqv <: Option](xs: xs, ys: ys, eqv: eqv) extends AsFunction0 {
        override type self = ElseThen[xs, ys, eqv]
        private[this] lazy val r: r = StartsWith.apply(xs.tail, ys.tail, eqv)
        private[this]     type r    = StartsWith.apply[xs#tail, ys#tail, eqv]
        override  def apply: apply = `if`(r.isEmpty, Const(None), ElseThenElse(xs.head, r)).apply.asInstanceOf[apply]
        override type apply        = `if`[r#isEmpty, Const[None], ElseThenElse[xs#head, r]]#apply
    }

    final case class ElseThenElse[x <: Any, r <: Option](x: x, r: r) extends AsFunction0 {
        override type self = ElseThenElse[x, r]
        private[this] lazy val p: p = r.get.asProduct2
        private[this]     type p    = r#get#asProduct2
        override  def apply: apply = Some(Pair(x :: p._1.asList, p._2))
        override type apply        = Some[Pair[x :: p#_1#asList, p#_2]]
    }
}
