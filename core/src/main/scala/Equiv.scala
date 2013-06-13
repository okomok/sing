

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Equiv extends AsKind


trait Equiv extends Relation {
    override type self <: Equiv

     def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y]
    type equiv[x <: Any, y <: Any] <: Boolean
}


trait AsEquiv extends EquivImpl {
    override  def kind: kind = Relation
    override type kind       = Relation.type
}


trait EquivImpl extends Equiv with RelationImpl with RefEquals {
    override  def asEquiv: asEquiv = self
    override type asEquiv          = self

    override  def related[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = equiv(x, y)
    override type related[x <: Any, y <: Any]                          = equiv[x, y]
}
