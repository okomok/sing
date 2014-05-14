

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.



package com.github.okomoktest; package singtest


import com.github.okomok.sing._


/**
 * Boxed non-sing type
 */
final case class _Box[A](override val unsing: A) extends AsAny with UnsingEquals {
    Predef.assert(!unsing.isInstanceOf[Any], "unneeded boxing")
    override type self = _Box[A]
    override type unsing = A
}

