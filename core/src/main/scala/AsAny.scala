

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsAny extends Any {
    override  def is[K <: AnyKind](K: K): is[K] = kindId.equal(K.kindId)
    override type is[K <: AnyKind]              = kindId#equal[K#kindId]

    override  def nequal[that <: Any](that: that): nequal[that] = equal(that).not
    override type nequal[that <: Any]                           = equal[that]#not
}
