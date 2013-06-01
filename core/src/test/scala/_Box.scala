

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.



package com.github.okomoktest; package singtest


import com.github.okomok.sing._


/**
 * Boxed non-sing type
 */
final case class _Box[A](override val unsing: A) extends Any {
    Predef.assert(!unsing.isInstanceOf[Any], "unneeded boxing")
    type self = _Box[A]
    override type unsing = A
}

