

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


private[sing]
case class GetNaturalOrdering[x <: Any](x: x) extends Function0 {
    type self = GetNaturalOrdering[x]
    override  def apply: apply = x.naturalOrdering
    override type apply        = x#naturalOrdering
}
