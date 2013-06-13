

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Set extends AsKind


/**
 * The sing Set
 */
trait Set extends Any {
    override type self <: Set
    override type unsing <: scala.collection.Set[scala.Any]

     def size: size
    type size <: Nat

     def isEmpty: isEmpty
    type isEmpty <: Boolean

     def add[k <: Any](k: k): add[k]
    type add[k <: Any] <: Set

     def addList[xs <: List](xs: xs): addList[xs]
    type addList[xs <: List] <: Set

     def clear: clear
    type clear <: Set

     def remove[k <: Any](k: k): remove[k]
    type remove[k <: Any] <: Set

     def removeList[xs <: List](xs: xs): removeList[xs]
    type removeList[xs <: List] <: Set

     def contains[k <: Any](k: k): contains[k]
    type contains[k <: Any] <: Boolean

     def intersect[that <: Set](that: that): intersect[that]
    type intersect[that <: Set] <: Set

     def union[that <: Set](that: that): union[that]
    type union[that <: Set] <: Set

     def diff[that <: Set](that: that): diff[that]
    type diff[that <: Set] <: Set

     def subsetOf[that <: Set](that: that): subsetOf[that]
    type subsetOf[that <: Set] <: Boolean
}


trait AsSet extends SetImpl {
    override  def kind: kind = Set
    override type kind       = Set.type
}


trait SetImpl extends Set with AnyImpl with UnsingEquals {
    import set._

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
