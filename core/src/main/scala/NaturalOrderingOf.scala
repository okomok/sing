

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


final case class NaturalOrderingOf[x <: Any](x: x) extends AsFunction0 {
    override type self = NaturalOrderingOf[x]
    override  def apply: apply = x.kind.naturalOrdering
    override type apply        = x#kind#naturalOrdering
}

