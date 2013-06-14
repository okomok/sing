

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Product2 extends AsKind with ListLikeKind {
    override  def kindId: kindId = KindId.ofProduct2
    override type kindId         = KindId.ofProduct2
}


trait Product2 extends Product {
    override type self <: Product2

     def _1: _1
    type _1 <: Any

     def _2: _2
    type _2 <: Any
}


trait AsProduct2 extends Product2Impl {
    override  def kind: kind = Product2
    override type kind       = Product2.type
}


trait Product2Impl extends Product2 with ProductImpl {
    override  def asProduct2: asProduct2 = self
    override type asProduct2             = self

    override  def arity: arity = Peano._2
    override type arity        = Peano._2

    override  def asList: asList = _1 :: _2 :: Nil
    override type asList         = _1 :: _2 :: Nil

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product2]
}
