

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import ListMap._


/**
 * In sing, this is a multimap.
 */
object ListMap {

    /**
     * Constructs an empty list-map.
     */
     def empty[r <: Relation](r: r): empty[r] = ListMap(r, Nil)
    type empty[r <: Relation]                 = ListMap[r, Nil]

    /**
     * Constructs a one-entry list-map.
     */
     def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = empty(k.naturalOrdering).put(k, v).asInstanceOf[put[k, v]]
    type put[k <: Any, v <: Any]                        = empty[k#naturalOrdering]#put[k, v]

    private[sing]
    final case class Related[r <: Relation, k <: Any](r: r, k: k) extends AsFunction1 {
        override type self = Related[r, k]
        override  def apply[x <: Any](x: x): apply[x] = r.related(k, x.asProduct2._1)
        override type apply[x <: Any]                 = r#related[k, x#asProduct2#_1]
    }

    private[sing]
    final class Get1 extends AsFunction1 {
        override type self = Get1
        override  def apply[x <: Any](x: x): apply[x] = x.asProduct2._1
        override type apply[x <: Any]                 = x#asProduct2#_1
    }
    private[sing]
    lazy val Get1: Get1 = new Get1

    private[sing]
    final class Get2 extends AsFunction1 {
        override type self = Get2
        override  def apply[x <: Any](x: x): apply[x] = x.asProduct2._2
        override type apply[x <: Any]                 = x#asProduct2#_2
    }
    private[sing]
    lazy val Get2: Get2 = new Get2
}


private[sing]
final case class ListMap[r <: Relation, kvs <: List](r: r, override val asList: kvs) extends AsMap {
    override type self = ListMap[r, kvs]

    override type asList = kvs

    override  def size: size = asList.length
    override type size       = asList#length

    override  def isEmpty: isEmpty = asList.isEmpty
    override type isEmpty          = asList#isEmpty

    override  def clear: clear = ListMap(r, Nil)
    override type clear        = ListMap[r, Nil]

    override  def get[k <: Any](k: k): get[k] = asList.find(Related(r, k)).map(Get2)
    override type get[k <: Any]               = asList#find[Related[r, k]]#map[Get2]

    override  def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = ListMap(r, Cons(Tuple2(k, v), asList))
    override type put[k <: Any, v <: Any]                        = ListMap[r, Cons[Tuple2[k, v], asList]]

    override  def remove[k <: Any](k: k): remove[k] = ListMap(r, asList.filter(Related(r, k).not))
    override type remove[k <: Any]                  = ListMap[r, asList#filter[Related[r, k]#not]]

    override  def keySet: keySet = ListSet(r, keyList)
    override type keySet         = ListSet[r, keyList]

    override  def keyList: keyList = asList.map(Get1)
    override type keyList          = asList#map[Get1]

    override  def valueList: valueList = asList.map(Get2)
    override type valueList            = asList#map[Get2]
}
