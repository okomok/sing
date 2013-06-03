

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Equiv


trait Equiv extends Any with RefEquals {
    override type self <: Equiv

    override  def asEquiv: asEquiv = self
    override type asEquiv          = self

     def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y]
    type equiv[x <: Any, y <: Any] <: Boolean
}
