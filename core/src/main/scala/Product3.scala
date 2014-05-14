

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


object Product3 extends AsKind with ListLikeKind {
    override  def kindId: kindId = KindId.ofProduct3
    override type kindId         = KindId.ofProduct3
}


trait Product3 extends Product {
    override type self <: Product3

     def _1: _1
    type _1 <: Any

     def _2: _2
    type _2 <: Any

     def _3: _3
    type _3 <: Any
}


trait AsProduct3 extends Product3Impl {
    override  def kind: kind = Product3
    override type kind       = Product3.type
}


trait Product3Impl extends Product3 with ProductImpl {
    override  def asProduct3: asProduct3 = self
    override type asProduct3             = self

    override  def arity: arity = Peano._3
    override type arity        = Peano._3

    override  def asList: asList = _1 :: _2 :: _3 :: Nil
    override type asList         = _1 :: _2 :: _3 :: Nil

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product3]
}
