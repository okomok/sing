

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


/**
 * unneeded if `assert[c]` could be implemented.
 */
@annotation.specializer
@scala.annotation.implicitNotFound("Cannot prove preconditon ${c}.")
sealed abstract class Pre[c <: Boolean]

object Pre {
    implicit val _ofTrue = new Pre[`true`]{}
}
