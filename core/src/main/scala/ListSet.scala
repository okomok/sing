

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


object ListSet {
    /**
     * Constructs an empty list-set.
     */
     def empty[e <: Equiv](e: e): empty[e] = ListSet(e, Nil)
    type empty[e <: Equiv]                 = ListSet[e, Nil]

    /**
     * Constructs a one-entry list-set.
     */
     def add[k <: Any](k: k): add[k] = empty(id(k).kind.naturalEquiv).add(k)
    type add[k <: Any]               = empty[id[k]#kind#naturalEquiv]#add[k]

    private[sing]
    final case class EquivTo[e <: Equiv, k <: Any](e: e, k: k) extends AsFunction1 {
        override type self = EquivTo[e, k]
        override  def apply[x <: Any](x: x): apply[x] = e.equiv(k, x)
        override type apply[x <: Any]                 = e#equiv[k, x]
    }
}


private[sing]
final case class ListSet[e <: Equiv, ks <: List](e: e, override val asList: ks) extends AsSet {
    import ListSet._

    override type self = ListSet[e, ks]

    override  def unsing: unsing = scala.collection.immutable.ListSet.empty ++ asList.unsing
    override type unsing         = scala.collection.immutable.ListSet[scala.Any]

    override type asList = ks

    override  def size: size = asList.length
    override type size       = asList#length

    override  def isEmpty: isEmpty = asList.isEmpty
    override type isEmpty          = asList#isEmpty

    override  def clear: clear = ListSet(e, Nil)
    override type clear        = ListSet[e, Nil]

    override  def add[k <: Any](k: k): add[k] = ListSet(e, Cons(k, remove(k).asList))
    override type add[k <: Any]               = ListSet[e, Cons[k, remove[k]#asList]]

    override  def remove[k <: Any](k: k): remove[k] = ListSet(e, asList.filter(EquivTo(e, k).not))
    override type remove[k <: Any]                  = ListSet[e, asList#filter[EquivTo[e, k]#not]]

    override  def contains[k <: Any](k: k): contains[k] = asList.find(EquivTo(e, k)).nonEmpty
    override type contains[k <: Any]                    = asList#find[EquivTo[e, k]]#nonEmpty
}
