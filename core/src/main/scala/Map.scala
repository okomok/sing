

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


object Map extends AsKind {
    override  def kindId: kindId = KindId.ofMap
    override type kindId         = KindId.ofMap
}


trait Map extends PartialFunction {
    override type self <: Map
    override type unsing <: scala.collection.Map[scala.Any, scala.Any]

     def asBSTree: asBSTree = Unsupported("Map.asBSTree").unwrap
    type asBSTree <: BSTree

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

     def equalWith[that <: Map, ve <: Equiv](that: that, ve: ve): equalWith[that, ve]
    type equalWith[that <: Map, ve <: Equiv] <: Boolean

    // left-biased
     def union[that <: Map](that: that): union[that]
    type union[that <: Map] <: Map
}


trait AsMap extends MapImpl {
    override  def kind: kind = Map
    override type kind       = Map.type
}


trait MapImpl extends Map with PartialFunctionImpl with UnsingEquals {
    import _map._

    override  def asMap: asMap = self
    override type asMap        = self

    override  def putList[xs <: List](xs: xs): putList[xs] = PutList.apply(self, xs)
    override type putList[xs <: List]                      = PutList.apply[self, xs]

    override  def contains[k <: Any](k: k): contains[k] = get(k).isEmpty.not
    override type contains[k <: Any]                    = get[k]#isEmpty#not

    override  def equal[that <: Any](that: that): equal[that] = Equal.apply(self, that.asMap, None)
    override type equal[that <: Any]                          = Equal.apply[self, that#asMap, None]

    override  def equalWith[that <: Map, ve <: Equiv](that: that, ve: ve): equalWith[that, ve] = Equal.apply(self, that, Some(ve))
    override type equalWith[that <: Map, ve <: Equiv]                                          = Equal.apply[self, that, Some[ve]]

    override  def union[that <: Map](that: that): union[that] = that.putList(asList)
    override type union[that <: Map]                          = that#putList[asList]

    override def canEqual(that: scala.Any) = that.isInstanceOf[Map]

// as PartialFunction
    override  def isDefinedAt[x <: Any](x: x): isDefinedAt[x] = contains(x)
    override type isDefinedAt[x <: Any]                       = contains[x]

    override  def apply[x <: Any](x: x): apply[x] = get(x).get
    override type apply[x <: Any]                 = get[x]#get
}
