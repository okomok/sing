

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


trait Term extends Type {

    /**
     * Likely to work.
     */
     def is[K <: Type](K: K): is[K] = ???
    type is[K <: Type] <: Boolean

    /**
     * Unlikely to work.
     */
     def as[K <: Type](K: K): as[K] = ???
    type as[K <: Type] <: K

}

