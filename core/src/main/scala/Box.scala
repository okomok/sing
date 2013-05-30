

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


/**
 * Boxed non-sing type
 */
final case class Box[A](override val unsing: A) extends Any {
    Predef.assert(!unsing.isInstanceOf[Any], "unneeded boxing")
    type self = Box[A]
    override type unsing = A
}

object Box {
//    implicit def _autounboxing[A](from: Box[A]): A = from.unsing // rejected
}
