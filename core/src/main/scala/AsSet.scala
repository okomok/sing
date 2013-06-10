

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import set._


trait AsSet extends Set with AsAny with UnsingEquals with AsSetKind {
    override  def asSet: asSet = self
    override type asSet        = self

    override  def addList[xs <: List](xs: xs): addList[xs] = AddList.apply(self, xs)
    override type addList[xs <: List]                      = AddList.apply[self, xs]

    override  def removeList[xs <: List](xs: xs): removeList[xs] = RemoveList.apply(self, xs)
    override type removeList[xs <: List]                         = RemoveList.apply[self, xs]

    override  def equal[that <: Any](that: that): equal[that] = Equal.apply(self, that.asSet)
    override type equal[that <: Any]                          = Equal.apply[self, that#asSet]

    override  def intersect[that <: Set](that: that): intersect[that] = Intersect.apply(self, that)
    override type intersect[that <: Set]                              = Intersect.apply[self, that]

    override  def union[that <: Set](that: that): union[that] = addList(that.asList)
    override type union[that <: Set]                          = addList[that#asList]

    override  def diff[that <: Set](that: that): diff[that] = removeList(that.asList)
    override type diff[that <: Set]                         = removeList[that#asList]

    override  def subsetOf[that <: Set](that: that): subsetOf[that] = SubsetOf.apply(self, that)
    override type subsetOf[that <: Set]                             = SubsetOf.apply[self, that]

    override def canEqual(that: scala.Any) = that.isInstanceOf[Set]
}
