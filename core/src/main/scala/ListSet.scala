

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import ListSet._


object ListSet {

    /**
     * Constructs an empty list-map.
     */
     def empty[r <: Relation](r: r): empty[r] = ListSet(r, Nil)
    type empty[r <: Relation]                 = ListSet[r, Nil]

    /**
     * Constructs a one-entry list-map.
     */
     def add[k <: Any](k: k): add[k] = empty(k.naturalOrdering).add(k).asInstanceOf[add[k]]
    type add[k <: Any]               = empty[k#naturalOrdering]#add[k]

    private[sing]
    final case class Related[r <: Relation, k <: Any](r: r, k: k) extends AsFunction1 {
        override type self = Related[r, k]
        override  def apply[x <: Any](x: x): apply[x] = r.related(k, x)
        override type apply[x <: Any]                 = r#related[k, x]
    }

    private[sing]
    final case class NotRelated[r <: Relation, k <: Any](r: r, k: k) extends AsFunction1 {
        override type self = NotRelated[r, k]
        override  def apply[x <: Any](x: x): apply[x] = r.related(k, x).not
        override type apply[x <: Any]                 = r#related[k, x]#not
    }
}


private[sing]
final case class ListSet[r <: Relation, ks <: List](r: r, override val asList: ks) extends AsSet {
    override type self = ListSet[r, ks]

    override type asList = ks

    override  def size: size = asList.length
    override type size       = asList#length

    override  def isEmpty: isEmpty = asList.isEmpty
    override type isEmpty          = asList#isEmpty

    override  def clear: clear = ListSet(r, Nil)
    override type clear        = ListSet[r, Nil]

    override  def add[k <: Any](k: k): add[k] = ListSet(r, Cons(k, asList))
    override type add[k <: Any]               = ListSet[r, Cons[k, asList]]

    override  def remove[k <: Any](k: k): remove[k] = ListSet(r, asList.filter(NotRelated(r, k)))
    override type remove[k <: Any]                  = ListSet[r, asList#filter[NotRelated[r, k]]]

    override  def contains[k <: Any](k: k): contains[k] = asList.find(Related(r, k)).nonEmpty
    override type contains[k <: Any]                    = asList#find[Related[r, k]]#nonEmpty
}
