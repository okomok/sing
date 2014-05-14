

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


private[sing]
final case class EqualTo[x <: Any, y <: Any](x: x, y: y) extends AsFunction0 {
    override type self = EqualTo[x, y]

    override  def apply: apply = x.equal(y)
    override type apply        = x#equal[y]
}
