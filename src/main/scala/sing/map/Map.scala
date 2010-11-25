

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package map


object Map extends Common


/**
 * The sing Map
 */
trait Map extends Any {
    type self <: Map
    type unsung <: scala.collection.Map[scala.Any, scala.Any]

     def asBSTree: asBSTree = unsupported("Map.asBSTree")
    type asBSTree <: bstree.BSTree

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
//    final def put[k <: Any, v](k: k, v: v, o: util.Overload = ()): put[k, Box[v]] = put(k, Box(v))

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
