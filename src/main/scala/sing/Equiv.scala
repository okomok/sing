

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


trait Equiv extends Any with ReferenceEquality {
    type self <: Equiv

    final override  def asEquiv: asEquiv = self
    final override type asEquiv          = self

     def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y]
    type equiv[x <: Any, y <: Any] <: Boolean
}
