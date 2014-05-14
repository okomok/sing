

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


sealed abstract class Identity extends AsFunction1 {
    override type self = Identity
    override  def apply[v1 <: Any](v1: v1): apply[v1] = v1
    override type apply[v1 <: Any]                    = v1
}

private[sing]
object _TermOfIdentity {
    val apply: Identity = new Identity{}
}
