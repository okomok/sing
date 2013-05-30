

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


/**
 * Sequence-derivation helper to work around suboptimal `nsc.symtab.Types.Type.isGround`.
 * (See "C++ Template Metaprogramming" 5.10 and C.3.7)
 */
abstract class Strong[xs <: List](xs: xs) extends AbstractList {
    override  def isEmpty: isEmpty = xs.isEmpty
    override type isEmpty          = xs#isEmpty

    override  def head: head = xs.head
    override type head       = xs#head

    override  def tail: tail = xs.tail
    override type tail       = xs#tail
}

/*
// This is probably worse than above, accessing delegate type-expression earlier.
abstract class Strong[xs <: List](final override protected val delegate: xs) extends TrivialForwarder {
    final override protected type delegate = xs

    final override  def asList: asList = self
    final override type asList         = self
}
*/
