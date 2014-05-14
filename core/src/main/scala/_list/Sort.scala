

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _list


private[sing]
object Sort {
     def apply[xs <: List, o <: Option](xs: xs, o: o): apply[xs, o] =
        `if`(HasTwoOrMore.apply(xs), Then(xs, o), Const(xs)).apply.asList
    type apply[xs <: List, o <: Option] =
        `if`[HasTwoOrMore.apply[xs], Then[xs, o], Const[xs]]#apply#asList

    case class Then[xs <: List, o <: Option](xs: xs, o: o) extends AsFunction0 {
        override type self = Then[xs, o]
        private[this] lazy val r: r = xs.splitAt(xs.length.quot(Peano._2)) // TODO: remove `length`.
        private[this]     type r    = xs#splitAt[xs#length#quot[Peano._2]]
        override  def apply: apply = Merge.apply(Sort.apply(r._1.asList, o), Sort.apply(r._2.asList, o), o)
        override type apply        = Merge.apply[Sort.apply[r#_1#asList, o], Sort.apply[r#_2#asList, o], o]
    }
}


private[sing]
object Merge {
     def apply[xs <: List, ys <: List, o <: Option](xs: xs, ys: ys, o: o): apply[xs, ys, o] =
        `if`(id(xs).isEmpty, Const(ys), `if`(id(ys).isEmpty, Const(xs), Else(xs, ys, o))).apply.asList
    type apply[xs <: List, ys <: List, o <: Option] =
        `if`[id[xs]#isEmpty, Const[ys], `if`[id[ys]#isEmpty, Const[xs], Else[xs, ys, o]]]#apply#asList

    case class Else[xs <: List, ys <: List, o <: Option](xs: xs, ys: ys, o: o) extends AsFunction0 {
        override type self = Else[xs, ys, o]
        private[this] lazy val _o: _o = o.getOrNaturalOrdering(xs.head)
        private[this]     type _o     = o#getOrNaturalOrdering[xs#head]
        override  def apply: apply = `if`(id(_o).lteq(id(xs).head, id(ys).head), ElseThen(xs, ys, o), ElseElse(xs, ys, o)).apply
        override type apply        = `if`[id[_o]#lteq[id[xs]#head, id[ys]#head], ElseThen[xs, ys, o], ElseElse[xs, ys, o]]#apply
    }

    case class ElseThen[xs <: List, ys <: List, o <: Option](xs: xs, ys: ys, o: o) extends AsFunction0 {
        override type self = ElseThen[xs, ys, o]
        override  def apply: apply = Cons(xs.head, Merge.apply(xs.tail, ys, o))
        override type apply        = Cons[xs#head, Merge.apply[xs#tail, ys, o]]
    }

    case class ElseElse[xs <: List, ys <: List, o <: Option](xs: xs, ys: ys, o: o) extends AsFunction0 {
        override type self = ElseElse[xs, ys, o]
        override  def apply: apply = Cons(ys.head, Merge.apply(xs, ys.tail, o))
        override type apply        = Cons[ys#head, Merge.apply[xs, ys#tail, o]]
    }
}
