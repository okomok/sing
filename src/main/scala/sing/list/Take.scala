

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


private[sing]
object Take {
     def apply[xs <: List, n <: Nat](xs: xs, n: n): apply[xs, n] = Impl(xs, n)
    type apply[xs <: List, n <: Nat]                             = Impl[xs, n]

    case class Impl[xs <: List, n <: Nat](xs: xs, n: n) extends AbstractList {
        type self = Impl[xs, n]

        private lazy val ys: ys = `if`(n.isZero, const0(Nil), const0(xs)).apply.asList
        private     type ys     = `if`[n#isZero, const0[Nil], const0[xs]]#apply#asList

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

    case class Impl[xs <: List, f <: Function1](xs: xs, f: f) extends AbstractList {
        type self = Impl[xs, f]

        private lazy val ys: ys = `if`(xs.isEmpty, const0(xs), Else(xs, f)).apply.asList
        private     type ys     = `if`[xs#isEmpty, const0[xs], Else[xs, f]]#apply#asList

        override  def isEmpty: isEmpty = ys.isEmpty
        override type isEmpty          = ys#isEmpty

        override  def head: head = ys.head
        override type head       = ys#head

        override  def tail: tail = Impl(ys.tail, f)
        override type tail       = Impl[ys#tail, f]
    }

    case class Else[xs <: List, f <: Function1](xs: xs, f: f) extends Function0 {
        type self = Else[xs, f]
        override  def apply: apply = `if`(f.apply(xs.head).asBoolean, const0(xs), const0(Nil)).apply.asInstanceOf[apply]
        override type apply        = `if`[f#apply[xs#head]#asBoolean, const0[xs], const0[Nil]]#apply
    }
}
