

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object ListMap {
    /**
     * Constructs an empty list-map.
     */
     def empty[e <: Equiv](e: e): empty[e] = ListMap(e, Nil)
    type empty[e <: Equiv]                 = ListMap[e, Nil]

    /**
     * Constructs a one-entry list-map.
     */
     def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = empty(id(k).kind.naturalOrdering).put(k, v)
    type put[k <: Any, v <: Any]                        = empty[id[k]#kind#naturalOrdering]#put[k, v]

    private[sing]
    final case class EquivTo[e <: Equiv, k <: Any](e: e, k: k) extends AsFunction1 {
        override type self = EquivTo[e, k]
        override  def apply[x <: Any](x: x): apply[x] = e.equiv(k, x.asProduct2._1)
        override type apply[x <: Any]                 = e#equiv[k, x#asProduct2#_1]
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
final case class ListMap[e <: Equiv, kvs <: List](e: e, override val asList: kvs) extends AsMap {
    import ListMap._

    override type self = ListMap[e, kvs]

    override  def unsing: unsing = scala.collection.immutable.ListMap.empty ++ asList.unsing.map{ case (k, v) => (k, v) }
    override type unsing         = scala.collection.immutable.ListMap[scala.Any, scala.Any]

    override type asList = kvs

    override  def size: size = asList.length
    override type size       = asList#length

    override  def isEmpty: isEmpty = asList.isEmpty
    override type isEmpty          = asList#isEmpty

    override  def clear: clear = ListMap(e, Nil)
    override type clear        = ListMap[e, Nil]

    override  def get[k <: Any](k: k): get[k] = asList.find(EquivTo(e, k)).map(Get2)
    override type get[k <: Any]               = asList#find[EquivTo[e, k]]#map[Get2]

    override  def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = ListMap(e, Cons(Tuple2(k, v), remove(k).asList))
    override type put[k <: Any, v <: Any]                        = ListMap[e, Cons[Tuple2[k, v], remove[k]#asList]]

    override  def remove[k <: Any](k: k): remove[k] = ListMap(e, asList.filter(EquivTo(e, k).not))
    override type remove[k <: Any]                  = ListMap[e, asList#filter[EquivTo[e, k]#not]]

    override  def keySet: keySet = ListSet(e, keyList)
    override type keySet         = ListSet[e, keyList]

    override  def keyList: keyList = asList.map(Get1)
    override type keyList          = asList#map[Get1]

    override  def valueList: valueList = asList.map(Get2)
    override type valueList            = asList#map[Get2]
}
