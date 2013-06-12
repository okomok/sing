

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsAnyKind extends AnyKind {
    override  def conformsTo[that <: AnyKind](that: that): conformsTo[that] = kindId.hasBitOf(that.kindId)
    override type conformsTo[that <: AnyKind]                               = kindId#hasBitOf[that#kindId]
}
