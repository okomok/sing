

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


final case class Cons[x <: Any, xs <: List](override val head: x, override val tail: xs) extends AbstractList {
    type self = Cons[x, xs]

    override  def isEmpty: isEmpty = `false`
    override type isEmpty          = `false`

    override type head = x
    override type tail = xs
}
