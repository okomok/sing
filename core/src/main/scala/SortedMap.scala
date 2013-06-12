

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object SortedMap {

    /**
     * Constructs an empty sorted map.
     */
     def empty[o <: Ordering](o: o): empty[o] = BSNil(o)
    type empty[o <: Ordering]                 = BSNil[o]


    /**
     * Constructs a one-entry sorted map.
     */
     def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = empty(k.kind.naturalOrdering).put(k, v).asInstanceOf[put[k, v]]
    type put[k <: Any, v <: Any]                        = empty[k#kind#naturalOrdering]#put[k, v]

}
