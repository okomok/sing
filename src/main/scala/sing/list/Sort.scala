

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


private[sing]
object Sort {
     def apply[xs <: List, o <: Option](xs: xs, o: o): apply[xs, o] =
        `if`(HasTwoOrMore.apply(xs), Then(xs, o), const0(xs)).apply.asList.asInstanceOf[apply[xs, o]]
    type apply[xs <: List, o <: Option] =
        `if`[HasTwoOrMore.apply[xs], Then[xs, o], const0[xs]]#apply#asList

    case class Then[xs <: List, o <: Option](xs: xs, o: o) extends Function0 {
        type self = Then[xs, o]
        private lazy val r: r = xs.splitAt(xs.length.quot(nat.peano._2)) // TODO: remove `length`.
        private     type r    = xs#splitAt[xs#length#quot[nat.peano._2]]
        override  def apply: apply = Merge.apply(Sort.apply(r._1.asList, o), Sort.apply(r._2.asList, o), o).asInstanceOf[apply]
        override type apply        = Merge.apply[Sort.apply[r#_1#asList, o], Sort.apply[r#_2#asList, o], o]
    }
}


private[sing]
object Merge {
     def apply[xs <: List, ys <: List, o <: Option](xs: xs, ys: ys, o: o): apply[xs, ys, o] =
        `if`(xs.isEmpty, const0(ys), `if`(ys.isEmpty, const0(xs), Else(xs, ys, o))).apply.asList.asInstanceOf[apply[xs, ys, o]]
    type apply[xs <: List, ys <: List, o <: Option] =
        `if`[xs#isEmpty, const0[ys], `if`[ys#isEmpty, const0[xs], Else[xs, ys, o]]]#apply#asList

    case class Else[xs <: List, ys <: List, o <: Option](xs: xs, ys: ys, o: o) extends Function0 {
        type self = Else[xs, ys, o]
        private lazy val _o: _o = o.getOrNaturalOrdering(xs.head)
        private     type _o     = o#getOrNaturalOrdering[xs#head]
        override  def apply: apply = `if`(_o.lteq(xs.head, ys.head), ElseThen(xs, ys, o), ElseElse(xs, ys, o)).apply.asInstanceOf[apply]
        override type apply        = `if`[_o#lteq[xs#head, ys#head], ElseThen[xs, ys, o], ElseElse[xs, ys, o]]#apply
    }

    case class ElseThen[xs <: List, ys <: List, o <: Option](xs: xs, ys: ys, o: o) extends Function0 {
        type self = ElseThen[xs, ys, o]
        override  def apply: apply = Cons(xs.head, Merge.apply(xs.tail, ys, o)).asInstanceOf[apply]
        override type apply        = Cons[xs#head, Merge.apply[xs#tail, ys, o]]
    }

    case class ElseElse[xs <: List, ys <: List, o <: Option](xs: xs, ys: ys, o: o) extends Function0 {
        type self = ElseElse[xs, ys, o]
        override  def apply: apply = Cons(ys.head, Merge.apply(xs, ys.tail, o)).asInstanceOf[apply]
        override type apply        = Cons[ys#head, Merge.apply[xs, ys#tail, o]]
    }
}
