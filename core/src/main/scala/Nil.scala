

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import list._


sealed abstract class Nil extends AsList {
    type self = Nil

    override  def isEmpty: isEmpty = `true`
    override type isEmpty          = `true`

    override  def head: head = noSuchElement("Nil.head")
    override type head       = noSuchElement[_]

    override  def tail: tail = noSuchElement("Nil.tail")
    override type tail       = noSuchElement[_]

    final def unapply(that: Nil) = true
}


private[sing]
object _Nil {
    val value: Nil = new Nil{}
}

