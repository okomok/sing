

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing;


import set._


trait SetForwarder extends Set with Forwarder {
    override protected type delegate <: Set

    final override  def size: size = delegate.size
    final override type size       = delegate#size

    final override  def isEmpty: isEmpty = delegate.isEmpty
    final override type isEmpty          = delegate#isEmpty

    final override  def add[k <: Any](k: k): add[k] = delegate.add(k)
    final override type add[k <: Any]               = delegate#add[k]

    final override  def addList[xs <: List](xs: xs): addList[xs] = delegate.addList(xs)
    final override type addList[xs <: List]                      = delegate#addList[xs]

    final override  def clear: clear = delegate.clear
    final override type clear        = delegate#clear

    final override  def remove[k <: Any](k: k): remove[k] = delegate.remove(k)
    final override type remove[k <: Any]                  = delegate#remove[k]

    final override  def removeList[xs <: List](xs: xs): removeList[xs] = delegate.removeList(xs)
    final override type removeList[xs <: List]                         = delegate#removeList[xs]

    final override  def contains[k <: Any](k: k): contains[k] = delegate.contains(k)
    final override type contains[k <: Any]                    = delegate#contains[k]

    final override  def equal[that <: Set](that: that): equal[that] = delegate.equal(that)
    final override type equal[that <: Set]                          = delegate#equal[that]

    final override  def intersect[that <: Set](that: that): intersect[that] = delegate.intersect(that)
    final override type intersect[that <: Set]                              = delegate#intersect[that]

    final override  def union[that <: Set](that: that): union[that] = delegate.union(that)
    final override type union[that <: Set]                          = delegate#union[that]

    final override  def diff[that <: Set](that: that): diff[that] = delegate.diff(that)
    final override type diff[that <: Set]                         = delegate#diff[that]

    final override  def subsetOf[that <: Set](that: that): subsetOf[that] = delegate.subsetOf(that)
    final override type subsetOf[that <: Set]                             = delegate#subsetOf[that]
}

