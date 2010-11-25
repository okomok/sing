

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


private[sing]
object Filter {
     def apply[xs <: List, f <: Function1](xs: xs, f: f): apply[xs, f] = Impl(xs, f)
    type apply[xs <: List, f <: Function1]                             = Impl[xs, f]

    case class Impl[xs <: List, f <: Function1](xs: xs, f: f) extends AbstractList {
        type self = Impl[xs, f]

        private lazy val ys: ys = xs.dropWhile(f.not)
        private     type ys     = xs#dropWhile[f#not]

        override  def isEmpty: isEmpty = ys.isEmpty.asInstanceOf[isEmpty]
        override type isEmpty          = ys#isEmpty

        override  def head: head = ys.head.asInstanceOf[head]
        override type head       = ys#head

        override  def tail: tail = Impl(ys.tail.asInstanceOf[ys#tail], f)
        override type tail       = Impl[ys#tail, f]
    }
}
