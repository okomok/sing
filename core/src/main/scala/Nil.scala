

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


sealed abstract class Nil extends AsList {
    override type self = Nil

    override  def isEmpty: isEmpty = `true`
    override type isEmpty          = `true`

    private[sing] lazy val _head = NoSuchElement("Nil.head")
    override  def head: head = _head.unwrap
    override type head       = _head.unwrap

    private[sing] lazy val _tail = NoSuchElement("Nil.tail")
    override  def tail: tail = _tail.unwrap
    override type tail       = _tail.unwrap

    def unapply(that: Nil) = true
}


private[sing]
object _TermOfNil {
    val apply: Nil = new Nil{}
}
