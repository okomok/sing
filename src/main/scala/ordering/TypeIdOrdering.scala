

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package ordering


private[sing]
final class TypeIdOrdering extends AbstractOrdering {
    type self = TypeIdOrdering

    private  val impl: impl = nat.naturalOrdering
    private type impl       = nat.naturalOrdering

    override  def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = impl.equiv(x.typeId, y.typeId)
    override type equiv[x <: Any, y <: Any]                          = impl#equiv[x#typeId, y#typeId]

    override  def compare[x <: Any, y <: Any](x: x, y: y): compare[x, y] = impl.compare(x.typeId, y.typeId)
    override type compare[x <: Any, y <: Any]                            = impl#compare[x#typeId, y#typeId]
}

