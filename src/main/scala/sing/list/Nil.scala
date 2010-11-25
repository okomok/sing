

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


sealed abstract class Nil extends AbstractList {
    type self = Nil

    override  def isEmpty: isEmpty = `true`
    override type isEmpty          = `true`

    override  def head: head = noSuchElement("list.Nil.head")
    override type head       = noSuchElement[_]

    override  def tail: tail = noSuchElement("list.Nil.tail")
    override type tail       = noSuchElement[_]
}

private[sing]
object _Nil {
    val value = new Nil{}
}
