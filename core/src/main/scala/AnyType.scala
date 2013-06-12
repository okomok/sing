

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AnyType extends AnyKind {

    /**
     * Likely to work.
     */
     def is[K <: AnyKind](K: K): is[K] = unsupported("AnyType.is")
    type is[K <: AnyKind] <: Boolean

    /**
     * Unlikely to work.
     */
     def as[K <: AnyKind](K: K): as[K] = ???
    type as[K <: AnyKind] <: K
}
