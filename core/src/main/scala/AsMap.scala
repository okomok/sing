

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import map._


trait AsMap extends Map with AsAny with UnsingEquals with AsMapKind {
    override  def asMap: asMap = self
    override type asMap        = self

    override  def putList[xs <: List](xs: xs): putList[xs] = PutList.apply(self, xs)
    override type putList[xs <: List]                      = PutList.apply[self, xs]

    override  def contains[k <: Any](k: k): contains[k] = get(k).isEmpty.not
    override type contains[k <: Any]                    = get[k]#isEmpty#not

    override  def equal[that <: Map](that: that): equal[that] = Equal.apply(self, that, None)
    override type equal[that <: Map]                          = Equal.apply[self, that, None]

    override  def equalWith[that <: Map, ve <: Equiv](that: that, ve: ve): equalWith[that, ve] = Equal.apply(self, that, Some(ve))
    override type equalWith[that <: Map, ve <: Equiv]                                          = Equal.apply[self, that, Some[ve]]

    override  def union[that <: Map](that: that): union[that] = that.putList(asList)
    override type union[that <: Map]                          = that#putList[asList]

    override def canEqual(that: scala.Any) = that.isInstanceOf[Map]
}
