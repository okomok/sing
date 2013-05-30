

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AnyTerm extends AnyType {

    /**
     * Likely to work.
     */
     def is[K <: AnyType](K: K): is[K] = ???
    type is[K <: AnyType] <: Boolean

    /**
     * Unlikely to work.
     */
     def as[K <: AnyType](K: K): as[K] = ???
    type as[K <: AnyType] <: K

}

