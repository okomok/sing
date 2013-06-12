

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsAny extends Any {
    override  def is[K <: Kind](K: K): is[K] = kind.conformsTo(K)
    override type is[K <: Kind]              = kind#conformsTo[K]

    override  def nequal[that <: Any](that: that): nequal[that] = equal(that).not
    override type nequal[that <: Any]                           = equal[that]#not
}
