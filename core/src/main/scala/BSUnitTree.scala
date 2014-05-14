

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


private[sing]
final case class BSUnitTree[impl <: BSTree](impl: impl) extends AsSet {
    override type self = BSUnitTree[impl]

    override  def unsing: unsing = impl.unsing.keySet
    override type unsing         = scala.collection.Set[scala.Any]

    override  def size: size = impl.size
    override type size       = impl#size

    override  def isEmpty: isEmpty = impl.isEmpty
    override type isEmpty          = impl#isEmpty

    override  def add[k <: Any](k: k): add[k] = BSUnitTree(impl.put(k, Unit))
    override type add[k <: Any]               = BSUnitTree[impl#put[k, Unit]]

    override  def clear: clear = BSUnitTree(impl.clear)
    override type clear        = BSUnitTree[impl#clear]

    override  def remove[k <: Any](k: k): remove[k] = BSUnitTree(impl.remove(k))
    override type remove[k <: Any]                  = BSUnitTree[impl#remove[k]]

    override  def contains[k <: Any](k: k): contains[k] = impl.contains(k)
    override type contains[k <: Any]                    = impl#contains[k]

    override  def asList: asList = impl.keyList
    override type asList         = impl#keyList
}
