

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import set._


trait AsSet extends Set with AsSetKind {
    final override  def asSet: asSet = self
    final override type asSet        = self

    final override  def addList[xs <: List](xs: xs): addList[xs] = AddList.apply(self, xs)
    final override type addList[xs <: List]                      = AddList.apply[self, xs]

    final override  def removeList[xs <: List](xs: xs): removeList[xs] = RemoveList.apply(self, xs)
    final override type removeList[xs <: List]                         = RemoveList.apply[self, xs]

    final override  def equal[that <: Set](that: that): equal[that] = Equal.apply(self, that)
    final override type equal[that <: Set]                          = Equal.apply[self, that]

    final override  def intersect[that <: Set](that: that): intersect[that] = Intersect.apply(self, that)
    final override type intersect[that <: Set]                              = Intersect.apply[self, that]

    final override  def union[that <: Set](that: that): union[that] = addList(that.asList)
    final override type union[that <: Set]                          = addList[that#asList]

    final override  def diff[that <: Set](that: that): diff[that] = removeList(that.asList)
    final override type diff[that <: Set]                         = removeList[that#asList]

    final override  def subsetOf[that <: Set](that: that): subsetOf[that] = SubsetOf.apply(self, that)
    final override type subsetOf[that <: Set]                             = SubsetOf.apply[self, that]

    override def canEqual(that: scala.Any) = that.isInstanceOf[Set]
}
