

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


private[sing]
final class NaturalEquiv extends AsEquiv {
    override type self = NaturalEquiv

    override  def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = x.equal(y)
    override type equiv[x <: Any, y <: Any]                          = x#equal[y]
}
