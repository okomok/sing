

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsProduct extends Product with AsAny with UnsingEquals with ListLike {

//    override  def kind: kind = Product
//    override type kind       = Product.type

    override  def asProduct: asProduct = self
    override type asProduct            = self

    override  def productElement[n <: Nat](n: n): productElement[n] = asList.nth(n)
    override type productElement[n <: Nat]                          = asList#nth[n]

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product]
}
