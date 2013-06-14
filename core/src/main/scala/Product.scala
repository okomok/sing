

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Product extends AsKind with ListLikeKind {
    override  def kindId: kindId = KindId.ofProduct
    override type kindId         = KindId.ofProduct
}


trait Product extends Any {
    override type self <: Product

     def arity: arity
    type arity <: Nat

     def productElement[n <: Nat](n: n): productElement[n]
    type productElement[n <: Nat] <: Any
}


trait AsProduct extends ProductImpl {
    override  def kind: kind = Product
    override type kind       = Product.type
}


trait ProductImpl extends Product with AnyImpl with UnsingEquals with ListLike {
    override  def asProduct: asProduct = self
    override type asProduct            = self

    override  def productElement[n <: Nat](n: n): productElement[n] = asList.nth(n)
    override type productElement[n <: Nat]                          = asList#nth[n]

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product]
}
