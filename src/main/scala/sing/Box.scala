

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


/**
 * Boxed non-sing type
 */
final case class Box[A](override val unsung: A) extends Any {
    Predef.assert(!unsung.isInstanceOf[Any], "unneeded boxing")
    type self = Box[A]
    override type unsung = A
}

object Box {
//    implicit def _autounboxing[A](from: Box[A]): A = from.unsung // rejected
}
