

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object UnfoldRight {
     def apply[z <: Any, f <: Function1](z: z, f: f): apply[z, f] = Impl(z, f)
    type apply[z <: Any, f <: Function1]                          = Impl[z, f]

    case class Impl[z <: Any, f <: Function1](z: z, f: f) extends ListImpl {
        type self = Impl[z, f]

        private[this] lazy val acc: acc = f.apply(z).asOption
        private[this]     type acc      = f#apply[z]#asOption

        override  def isEmpty: isEmpty = acc.isEmpty
        override type isEmpty          = acc#isEmpty

        override  def head: head = acc.get.asProduct2._1
        override type head       = acc#get#asProduct2#_1

        override  def tail: tail = Impl(acc.get.asProduct2._2, f)
        override type tail       = Impl[acc#get#asProduct2#_2, f]
    }
}
