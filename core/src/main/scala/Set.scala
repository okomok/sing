

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import set._


object Set extends AsSetKind {

    /**
     * Constructs an empty sorted set.
     */
     def sorted[o <: Ordering](o: o): sorted[o] = BSUnitTree(BSNil(o))
    type sorted[o <: Ordering]                  = BSUnitTree[BSNil[o]]


    /**
     * Constructs a one-entry sorted set.
     */
     def sorted1[k <: Any](k: k): sorted1[k] = sorted(k.naturalOrdering).add(k).asInstanceOf[sorted1[k]]
    type sorted1[k <: Any]                   = sorted[k#naturalOrdering]#add[k]

}


/**
 * The sing Set
 */
trait Set extends Any {
    override type self <: Set
    override type unsing <: scala.collection.Set[scala.Any]

     def size: size
    type size <: Nat

     def isEmpty: isEmpty
    type isEmpty <: Boolean

     def add[k <: Any](k: k): add[k]
    type add[k <: Any] <: Set

     def addList[xs <: List](xs: xs): addList[xs]
    type addList[xs <: List] <: Set

     def clear: clear
    type clear <: Set

     def remove[k <: Any](k: k): remove[k]
    type remove[k <: Any] <: Set

     def removeList[xs <: List](xs: xs): removeList[xs]
    type removeList[xs <: List] <: Set

     def contains[k <: Any](k: k): contains[k]
    type contains[k <: Any] <: Boolean

     def equal[that <: Set](that: that): equal[that]
    type equal[that <: Set] <: Boolean

     def intersect[that <: Set](that: that): intersect[that]
    type intersect[that <: Set] <: Set

     def union[that <: Set](that: that): union[that]
    type union[that <: Set] <: Set

     def diff[that <: Set](that: that): diff[that]
    type diff[that <: Set] <: Set

     def subsetOf[that <: Set](that: that): subsetOf[that]
    type subsetOf[that <: Set] <: Boolean
}
