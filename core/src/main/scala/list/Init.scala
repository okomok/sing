

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


private[sing]
object Init {
     def apply[xs <: List](xs: xs): apply[xs] = Impl(xs)
    type apply[xs <: List]                    = Impl[xs]

    case class Impl[xs <: List](xs: xs) extends AbstractList {
        type self = Impl[xs]

        private[this] lazy val ys: ys = `if`(xs.tail.isEmpty, const0(Nil), const0(xs)).apply.asList
        private[this]     type ys     = `if`[xs#tail#isEmpty, const0[Nil], const0[xs]]#apply#asList

        override  def isEmpty: isEmpty = ys.isEmpty
        override type isEmpty          = ys#isEmpty

        override  def head: head = ys.head
        override type head       = ys#head

        override  def tail: tail = Impl(ys.tail)
        override type tail       = Impl[ys#tail]
    }
}
