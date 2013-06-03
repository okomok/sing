

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import map._


object Map extends AsMapKind {

    /**
     * Constructs an empty sorted map.
     */
     def sorted[o <: Ordering](o: o): sorted[o] = BSNil(o)
    type sorted[o <: Ordering]                  = BSNil[o]


    /**
     * Constructs a one-entry sorted map.
     */
     def sorted1[k <: Any, v <: Any](k: k, v: v): sorted1[k, v] = sorted(k.naturalOrdering).put(k, v).asInstanceOf[sorted1[k, v]]
    type sorted1[k <: Any, v <: Any]                            = sorted[k#naturalOrdering]#put[k, v]
}


/**
 * The sing Map
 */
trait Map extends Any {
    override type self <: Map
    override type unsing <: scala.collection.Map[scala.Any, scala.Any]

     def asBSTree: asBSTree = unsupported("Map.asBSTree")
    type asBSTree <: BSTree

     def size: size
    type size <: Nat

     def isEmpty: isEmpty
    type isEmpty <: Boolean

     def clear: clear
    type clear <: Map

     def get[k <: Any](k: k): get[k]
    type get[k <: Any] <: Option

     def put[k <: Any, v <: Any](k: k, v: v): put[k, v]
    type put[k <: Any, v <: Any] <: Map

     def putList[xs <: List](xs: xs): putList[xs]
    type putList[xs <: List] <: Map

     def remove[k <: Any](k: k): remove[k]
    type remove[k <: Any] <: Map

     def contains[k <: Any](k: k): contains[k]
    type contains[k <: Any] <: Boolean

     def keySet: keySet
    type keySet <: Set

     def keyList: keyList
    type keyList <: List

     def valueList: valueList
    type valueList <: List

     def equal[that <: Map](that: that): equal[that]
    type equal[that <: Map] <: Boolean

     def equalWith[that <: Map, ve <: Equiv](that: that, ve: ve): equalWith[that, ve]
    type equalWith[that <: Map, ve <: Equiv] <: Boolean

    // left-biased
     def union[that <: Map](that: that): union[that]
    type union[that <: Map] <: Map
}
