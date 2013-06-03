

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object Map {
     def apply[xs <: List, f <: Function1](xs: xs, f: f): apply[xs, f] = Impl(xs, f)
    type apply[xs <: List, f <: Function1]                             = Impl[xs, f]

    case class Impl[xs <: List, f <: Function1](xs: xs, f: f) extends AsList {
        type self = Impl[xs, f]

        override  def isEmpty: isEmpty = xs.isEmpty
        override type isEmpty          = xs#isEmpty

        override  def head: head = f.apply(xs.head)
        override type head       = f#apply[xs#head]

        override  def tail: tail = Impl(xs.tail, f)
        override type tail       = Impl[xs#tail, f]
    }
}
