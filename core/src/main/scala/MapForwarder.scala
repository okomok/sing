

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import map._


trait MapForwarder extends Map with Forwarder {
    override protected type delegate <: Map

    final override  def asBSTree: asBSTree = delegate.asBSTree
    final override type asBSTree           = delegate#asBSTree

    final override  def size: size = delegate.size
    final override type size       = delegate#size

    final override  def isEmpty: isEmpty = delegate.isEmpty
    final override type isEmpty          = delegate#isEmpty

    final override  def clear: clear = delegate.clear
    final override type clear        = delegate#clear

    final override  def get[k <: Any](k: k): get[k] = delegate.get(k)
    final override type get[k <: Any]               = delegate#get[k]

    final override  def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = delegate.put(k, v)
    final override type put[k <: Any, v <: Any]                        = delegate#put[k, v]

    final override  def putList[xs <: List](xs: xs): putList[xs] = delegate.putList(xs)
    final override type putList[xs <: List]                      = delegate#putList[xs]

    final override  def remove[k <: Any](k: k): remove[k] = delegate.remove(k)
    final override type remove[k <: Any]                  = delegate#remove[k]

    final override  def contains[k <: Any](k: k): contains[k] = delegate.contains(k)
    final override type contains[k <: Any]                    = delegate#contains[k]

    final override  def keySet: keySet = delegate.keySet
    final override type keySet         = delegate#keySet

    final override  def keyList: keyList = delegate.keyList
    final override type keyList          = delegate#keyList

    final override  def valueList: valueList = delegate.valueList
    final override type valueList            = delegate#valueList

    final override  def equal[that <: Map](that: that): equal[that] = delegate.equal(that)
    final override type equal[that <: Map]                          = delegate#equal[that]

    final override  def equalWith[that <: Map, ve <: Equiv](that: that, ve: ve): equalWith[that, ve] = delegate.equalWith(that, ve)
    final override type equalWith[that <: Map, ve <: Equiv]                                          = delegate#equalWith[that, ve]

    final override  def union[that <: Map](that: that): union[that] = delegate.union(that)
    final override type union[that <: Map]                          = delegate#union[that]
}

