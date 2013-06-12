

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsKind extends Kind with AsAny with UnsingEquals {
    // KindKind
    override  def kind: kind = ???
    override type kind = Nothing

    override  def unsing: unsing = kindId.unsing
    override type unsing         = kindId#unsing

    override  def conformsTo[that <: Kind](that: that): conformsTo[that] = kindId.hasBitOf(that.kindId)
    override type conformsTo[that <: Kind]                               = kindId#hasBitOf[that#kindId]

    override def canEqual(that: scala.Any) = that.isInstanceOf[Kind]
}
