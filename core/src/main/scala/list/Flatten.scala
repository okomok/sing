

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object Flatten {
     def apply[xs <: List](xs: xs): apply[xs] = Impl(xs)
    type apply[xs <: List]                    = Impl[xs]

    case class Impl[xs <: List](xs: xs) extends AsList {
        override type self = Impl[xs]

        private[this] lazy val ys: ys = xs.dropWhile(IsEmpty)
        private[this]     type ys     = xs#dropWhile[IsEmpty]

        override  def isEmpty: isEmpty = ys.isEmpty
        override type isEmpty          = ys#isEmpty

        private[this] lazy val local: local = ys.head.asList
        private[this]     type local        = ys#head#asList

        override  def head: head = local.head
        override type head       = local#head

        override  def tail: tail = Impl(Cons(local.tail, ys.tail))
        override type tail       = Impl[Cons[local#tail, ys#tail]]

    }

    val IsEmpty = new IsEmpty
    class IsEmpty extends AsFunction1 {
        override type self = IsEmpty
        override  def apply[xs <: Any](xs: xs): apply[xs] = xs.asList.isEmpty
        override type apply[xs <: Any]                    = xs#asList#isEmpty
    }
}
