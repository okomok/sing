

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package map


trait Common {

    /**
     * Constructs an empty sorted map.
     */
     def sorted[o <: Ordering](o: o): sorted[o] = bstree.Nil(o)
    type sorted[o <: Ordering]                  = bstree.Nil[o]


    /**
     * Constructs a one-entry sorted map.
     */
     def sorted1[k <: Any, v <: Any](k: k, v: v): sorted1[k, v] = sorted(k.naturalOrdering).put(k, v).asInstanceOf[sorted1[k, v]]
    type sorted1[k <: Any, v <: Any]                            = sorted[k#naturalOrdering]#put[k, v]
//    final def sorted1[k <: Any, v](k: k, v: v, o: util.Overload = ()): sorted1[k, Box[v]] = sorted1(k, Box(v))

}
