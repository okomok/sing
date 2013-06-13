

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait Kind extends Any {
    /**
     * ID number
     */
     def kindId: kindId = unsupported("Kind.kindId")
    type kindId <: KindId

    /**
     * Checks the kind-conformance.
     */
     def conformsTo[that <: Kind](that: that): conformsTo[that] = unsupported("Kind.conformsTo")
    type conformsTo[that <: Kind] <: Boolean

    /**
     * Returns the natural ordering.
     */
     def naturalOrdering: naturalOrdering = unsupported("Kind.naturalOrdering")
    type naturalOrdering <: Ordering
}


trait AsKind extends KindImpl {
    // KindKind
    override  def kind: kind = ???
    override type kind = Nothing
}


trait KindImpl extends Kind with AnyImpl with UnsingEquals {
    override  def unsing: unsing = kindId.unsing
    override type unsing         = kindId#unsing

    override  def conformsTo[that <: Kind](that: that): conformsTo[that] = kindId.hasBitOf(that.kindId)
    override type conformsTo[that <: Kind]                               = kindId#hasBitOf[that#kindId]

    override def canEqual(that: scala.Any) = that.isInstanceOf[Kind]
}
