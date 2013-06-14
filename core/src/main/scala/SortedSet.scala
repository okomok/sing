

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object SortedSet {

    /**
     * Constructs an empty sorted set.
     */
     def empty[o <: Ordering](o: o): empty[o] = BSUnitTree(BSNil(o))
    type empty[o <: Ordering]                 = BSUnitTree[BSNil[o]]


    /**
     * Constructs a one-entry sorted set.
     */
     def add[k <: Any](k: k): add[k] = empty(id(k).kind.naturalOrdering).add(k)
    type add[k <: Any]               = empty[id[k]#kind#naturalOrdering]#add[k]

}
