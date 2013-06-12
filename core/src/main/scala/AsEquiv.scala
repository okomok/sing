

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsEquiv extends Equiv with AsRelation with RefEquals {
    override  def asEquiv: asEquiv = self
    override type asEquiv          = self

     def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y]
    type equiv[x <: Any, y <: Any] <: Boolean

    override  def related[x <: Any, y <: Any](x: x, y: y): related[x, y] = equiv(x, y)
    override type related[x <: Any, y <: Any]                            = equiv[x, y]
}
