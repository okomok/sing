

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import ListSet._


object ListSet {

    /**
     * Constructs an empty list-map.
     */
     def empty[eq <: Equiv](eq: eq): empty[eq] = ListSet(eq, Nil)
    type empty[eq <: Equiv]                    = ListSet[eq, Nil]

    /**
     * Constructs a one-entry list-map.
     */
     def add[k <: Any](k: k): add[k] = empty(k.naturalOrdering).add(k).asInstanceOf[add[k]]
    type add[k <: Any]               = empty[k#naturalOrdering]#add[k]

    private[sing]
    final case class EquivTo[eq <: Equiv, k <: Any](eq: eq, k: k) extends AsFunction1 {
        override type self = EquivTo[eq, k]
        override  def apply[x <: Any](x: x): apply[x] = eq.equiv(x, k)
        override type apply[x <: Any]                 = eq#equiv[x, k]
    }

    private[sing]
    final case class NotEquivTo[eq <: Equiv, k <: Any](eq: eq, k: k) extends AsFunction1 {
        override type self = NotEquivTo[eq, k]
        override  def apply[x <: Any](x: x): apply[x] = eq.equiv(x, k).not
        override type apply[x <: Any]                 = eq#equiv[x, k]#not
    }
}


private[sing]
final case class ListSet[eq <: Equiv, ks <: List](eq: eq, override val asList: ks) extends AsSet {
    override type self = ListSet[eq, ks]

    override  def unsing: unsing = scala.collection.immutable.ListSet.empty ++ asList.unsing
    override type unsing         = scala.collection.immutable.ListSet[scala.Any]

    override type asList = ks

    override  def size: size = asList.length
    override type size       = asList#length

    override  def isEmpty: isEmpty = asList.isEmpty
    override type isEmpty          = asList#isEmpty

    override  def clear: clear = ListSet(eq, Nil)
    override type clear        = ListSet[eq, Nil]

    override  def add[k <: Any](k: k): add[k] = ListSet(eq, k :: remove(k).asList)
    override type add[k <: Any]               = ListSet[eq, k :: remove[k]#asList]

    override  def remove[k <: Any](k: k): remove[k] = ListSet(eq, asList.filter(NotEquivTo(eq, k)))
    override type remove[k <: Any]                  = ListSet[eq, asList#filter[NotEquivTo[eq, k]]]

    override  def contains[k <: Any](k: k): contains[k] = asList.find(EquivTo(eq, k)).nonEmpty
    override type contains[k <: Any]                    = asList#find[EquivTo[eq, k]]#nonEmpty
}
