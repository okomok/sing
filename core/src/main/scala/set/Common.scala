

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package set


trait Common {

    /**
     * Constructs an empty sorted set.
     */
     def sorted[o <: Ordering](o: o): sorted[o] = BSTree(map.bstree.Nil(o))
    type sorted[o <: Ordering]                  = BSTree[map.bstree.Nil[o]]


    /**
     * Constructs a one-entry sorted set.
     */
     def sorted1[k <: Any](k: k): sorted1[k] = sorted(k.naturalOrdering).add(k).asInstanceOf[sorted1[k]]
    type sorted1[k <: Any]                   = sorted[k#naturalOrdering]#add[k]

}
