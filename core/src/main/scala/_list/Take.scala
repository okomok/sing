

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _list


private[sing]
object Take {
     def apply[xs <: List, n <: Nat](xs: xs, n: n): apply[xs, n] = Impl(xs, n)
    type apply[xs <: List, n <: Nat]                             = Impl[xs, n]

    case class Impl[xs <: List, n <: Nat](xs: xs, n: n) extends AsList {
        override type self = Impl[xs, n]

        private[this] lazy val ys: ys = `if`(n.isZero, Const(Nil), Const(xs)).apply.asList
        private[this]     type ys     = `if`[n#isZero, Const[Nil], Const[xs]]#apply#asList

        override  def isEmpty: isEmpty = ys.isEmpty
        override type isEmpty          = ys#isEmpty

        override  def head: head = ys.head
        override type head       = ys#head

        override  def tail: tail = Impl(ys.tail, n.decrement)
        override type tail       = Impl[ys#tail, n#decrement]
    }
}


private[sing]
object TakeWhile {
     def apply[xs <: List, f <: Function1](xs: xs, f: f): apply[xs, f] = Impl(xs, f)
    type apply[xs <: List, f <: Function1]                             = Impl[xs, f]

    case class Impl[xs <: List, f <: Function1](xs: xs, f: f) extends AsList {
        override type self = Impl[xs, f]

        private[this] lazy val ys: ys = `if`(xs.isEmpty, Const(xs), Else(xs, f)).apply.asList
        private[this]     type ys     = `if`[xs#isEmpty, Const[xs], Else[xs, f]]#apply#asList

        override  def isEmpty: isEmpty = ys.isEmpty
        override type isEmpty          = ys#isEmpty

        override  def head: head = ys.head
        override type head       = ys#head

        override  def tail: tail = Impl(ys.tail, f)
        override type tail       = Impl[ys#tail, f]
    }

    case class Else[xs <: List, f <: Function1](xs: xs, f: f) extends AsFunction0 {
        override type self = Else[xs, f]
        override  def apply: apply = `if`(id(f).apply(id(xs).head).asBoolean, Const(xs), Const(Nil)).apply
        override type apply        = `if`[id[f]#apply[id[xs]#head]#asBoolean, Const[xs], Const[Nil]]#apply
    }
}
