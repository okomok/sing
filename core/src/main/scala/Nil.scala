

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


sealed abstract class Nil extends AsList {
    override type self = Nil

    override  def isEmpty: isEmpty = `true`
    override type isEmpty          = `true`

    override  def head: head = makro.NoSuchElement.apply("Nil.head")
    override type head       = makro.NoSuchElement.apply("Nil.head")

    override  def tail: tail = makro.NoSuchElement.apply("Nil.tail")
    override type tail       = makro.NoSuchElement.apply("Nil.tail")

    def unapply(that: Nil) = true
}


private[sing]
object _TermOfNil {
    val apply: Nil = new Nil{}
}
