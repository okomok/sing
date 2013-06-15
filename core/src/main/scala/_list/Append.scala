

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _list


private[sing]
object Append {
     def apply[xs <: List, ys <: List](xs: xs, ys: ys): apply[xs, ys] = Impl(xs, ys)
    type apply[xs <: List, ys <: List]                                = Impl[xs, ys]

    case class Impl[xs <: List, ys <: List](xs: xs, ys: ys) extends AsList {
        override type self = Impl[xs, ys]

        override  def isEmpty: isEmpty = xs.isEmpty.and(ys.isEmpty)
        override type isEmpty          = xs#isEmpty#and[ys#isEmpty]

        override  def head: head = `if`(xs.isEmpty, DerefThen(xs, ys), DerefElse(xs, ys)).apply
        override type head       = `if`[xs#isEmpty, DerefThen[xs, ys], DerefElse[xs, ys]]#apply

        override  def tail: tail = `if`(xs.isEmpty, NextThen(xs, ys), NextElse(xs, ys)).apply.asList
        override type tail       = `if`[xs#isEmpty, NextThen[xs, ys], NextElse[xs, ys]]#apply#asList
    }

    case class DerefThen[xs <: List, ys <: List](xs: xs, ys: ys) extends AsFunction0 {
        override type self = DerefThen[xs, ys]
        override  def apply: apply = ys.head
        override type apply        = ys#head
    }

    case class DerefElse[xs <: List, ys <: List](xs: xs, ys: ys) extends AsFunction0 {
        override type self = DerefElse[xs, ys]
        override  def apply: apply = xs.head
        override type apply        = xs#head
    }

    case class NextThen[xs <: List, ys <: List](xs: xs, ys: ys) extends AsFunction0 {
        override type self = NextThen[xs, ys]
        override  def apply: apply = Append.apply(xs, ys.tail)
        override type apply        = Append.apply[xs, ys#tail]
    }

    case class NextElse[xs <: List, ys <: List](xs: xs, ys: ys) extends AsFunction0 {
        override type self = NextElse[xs, ys]
        override  def apply: apply = Append.apply(xs.tail, ys)
        override type apply        = Append.apply[xs#tail, ys]
    }
}
