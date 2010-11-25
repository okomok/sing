

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package peg


@annotation.visibleForTesting
object StartsWith {
     def apply[xs <: List, ys <: List, eqv <: Option](xs: xs, ys: ys, eqv: eqv): apply[xs, ys, eqv] =
        `if`(ys.isEmpty,
            const0(Some(Pair(Nil, xs))),
            `if`(xs.isEmpty,
                const0(None),
                Else(xs, ys, eqv)
            )
        ).apply.asOption.asInstanceOf[apply[xs, ys, eqv]]
    type apply[xs <: List, ys <: List, eqv <: Option] =
        `if`[ys#isEmpty,
            const0[Some[Pair[Nil, xs]]],
            `if`[xs#isEmpty,
                const0[None],
                Else[xs, ys, eqv]
            ]
        ]#apply#asOption

    final case class Else[xs <: List, ys <: List, eqv <: Option](xs: xs, ys: ys, eqv: eqv) extends Function0 {
        type self = Else[xs, ys, eqv]
        private lazy val _eqv: _eqv = eqv.getOrNaturalEquiv(xs.head)
        private     type _eqv       = eqv#getOrNaturalEquiv[xs#head]
        override  def apply: apply =
            `if`(_eqv.equiv(xs.head, ys.head), ElseThen(xs, ys, eqv), const0(None)).apply.asInstanceOf[apply]
        override type apply =
            `if`[_eqv#equiv[xs#head, ys#head], ElseThen[xs, ys, eqv], const0[None]]#apply
    }

    final case class ElseThen[xs <: List, ys <: List, eqv <: Option](xs: xs, ys: ys, eqv: eqv) extends Function0 {
        type self = ElseThen[xs, ys, eqv]
        private lazy val r: r = StartsWith.apply(xs.tail, ys.tail, eqv)
        private     type r    = StartsWith.apply[xs#tail, ys#tail, eqv]
        override  def apply: apply = `if`(r.isEmpty, const0(None), ElseThenElse(xs.head, r)).apply.asInstanceOf[apply]
        override type apply        = `if`[r#isEmpty, const0[None], ElseThenElse[xs#head, r]]#apply
    }

    final case class ElseThenElse[x <: Any, r <: Option](x: x, r: r) extends Function0 {
        type self = ElseThenElse[x, r]
        private lazy val p: p = r.get.asProduct2
        private     type p    = r#get#asProduct2
        override  def apply: apply = Some(Pair(x :: p._1.asList, p._2))
        override type apply        = Some[Pair[x :: p#_1#asList, p#_2]]
    }
}
