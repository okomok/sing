

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _list


private[sing]
object Step {
     def apply[xs <: List, n <: Nat](xs: xs, n: n): apply[xs, n] = Impl(xs, n)
    type apply[xs <: List, n <: Nat]                             = Impl[xs, n]

    case class Impl[xs <: List, n <: Nat](xs: xs, n: n) extends AsList {
        override type self = Impl[xs, n]

        override  def isEmpty: isEmpty = xs.isEmpty
        override type isEmpty          = xs#isEmpty

        override  def head: head = xs.head
        override type head       = xs#head

        override  def tail: tail = Impl(xs.drop(n), n)
        override type tail       = Impl[xs#drop[n], n]
    }
}
