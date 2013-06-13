

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Relation extends AsKind


trait Relation extends Any {
    override type self <: Relation

     def related[x <: Any, y <: Any](x: x, y: y): related[x, y]
    type related[x <: Any, y <: Any] <: Boolean
}


trait AsRelation extends RelationImpl {
    override  def kind: kind = Relation
    override type kind       = Relation.type
}


trait RelationImpl extends Relation with AnyImpl with RefEquals {
    override  def asRelation: asRelation = self
    override type asRelation             = self
}
