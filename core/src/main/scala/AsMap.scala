

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import map._


trait AsMap extends Map with AsPartialFunction with UnsingEquals {
    override  def kind: kind = Map
    override type kind       = Map.type

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
