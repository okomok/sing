

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import ListMap._


object ListMap {

    /**
     * Constructs an empty list-map.
     */
     def empty[eq <: Equiv](eq: eq): empty[eq] = ListMap(eq, Nil)
    type empty[eq <: Equiv]                    = ListMap[eq, Nil]

    /**
     * Constructs a one-entry list-map.
     */
     def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = empty(k.naturalOrdering).put(k, v).asInstanceOf[put[k, v]]
    type put[k <: Any, v <: Any]                        = empty[k#naturalOrdering]#put[k, v]

    private[sing]
    final case class EquivTo[eq <: Equiv, k <: Any](eq: eq, k: k) extends AsFunction1 {
        override type self = EquivTo[eq, k]
        override  def apply[x <: Any](x: x): apply[x] = eq.equiv(x.asProduct2._1, k)
        override type apply[x <: Any]                 = eq#equiv[x#asProduct2#_1, k]
    }

    private[sing]
    final case class NotEquivTo[eq <: Equiv, k <: Any](eq: eq, k: k) extends AsFunction1 {
        override type self = NotEquivTo[eq, k]
        override  def apply[x <: Any](x: x): apply[x] = eq.equiv(x.asProduct2._1, k).not.asInstanceOf[apply[x]]
        override type apply[x <: Any]                 = eq#equiv[x#asProduct2#_1, k]#not
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

    private[sing]
    object OptionMap {
         def apply[kv <: Option](kv: kv): apply[kv] = `if`(kv.isEmpty, Const(None), Else(kv)).apply.asOption
        type apply[kv <: Option]                    = `if`[kv#isEmpty, Const[None], Else[kv]]#apply#asOption

        case class Else[kv <: Option](kv: kv) extends AsFunction0 {
            override type self = Else[kv]
            override  def apply: apply = Some(kv.get.asProduct2._2)
            override type apply        = Some[kv#get#asProduct2#_2]
        }
    }
}


private[sing]
final case class ListMap[eq <: Equiv, kvs <: List](eq: eq, override val asList: kvs) extends AsMap {
    override type self = ListMap[eq, kvs]

    override  def unsing: unsing = scala.collection.immutable.ListMap.empty ++ asList.unsing.map(kv => kv.asInstanceOf[scala.Tuple2[scala.Any, scala.Any]])
    override type unsing         = scala.collection.immutable.ListMap[scala.Any, scala.Any]

    override type asList = kvs

    override  def size: size = asList.length
    override type size       = asList#length

    override  def isEmpty: isEmpty = asList.isEmpty
    override type isEmpty          = asList#isEmpty

    override  def clear: clear = ListMap(eq, Nil)
    override type clear        = ListMap[eq, Nil]

    override  def get[k <: Any](k: k): get[k] = OptionMap.apply(asList.find(EquivTo(eq, k)))
    override type get[k <: Any]               = OptionMap.apply[asList#find[EquivTo[eq, k]]]

    override  def put[k <: Any, v <: Any](k: k, v: v): put[k, v] = ListMap(eq, Tuple2(k, v) :: remove(k).asList)
    override type put[k <: Any, v <: Any]                        = ListMap[eq, Tuple2[k, v] :: remove[k]#asList]

    override  def remove[k <: Any](k: k): remove[k] = ListMap(eq, asList.filter(NotEquivTo(eq, k)))
    override type remove[k <: Any]                  = ListMap[eq, asList#filter[NotEquivTo[eq, k]]]

    override  def keySet: keySet = ListSet(eq, keyList)
    override type keySet         = ListSet[eq, keyList]

    override  def keyList: keyList = asList.map(Get1)
    override type keyList          = asList#map[Get1]

    override  def valueList: valueList = asList.map(Get2)
    override type valueList            = asList#map[Get2]
}
