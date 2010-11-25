

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


private[sing]
case class GetNaturalOrdering[x <: Any](x: x) extends Function0 {
    type self = GetNaturalOrdering[x]
    override  def apply: apply = x.naturalOrdering
    override type apply        = x#naturalOrdering
}
