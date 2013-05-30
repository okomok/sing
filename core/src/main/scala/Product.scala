

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


trait Product extends Any {
    type self <: Product

    final override  def asProduct: asProduct = self
    final override type asProduct            = self

     def arity: arity
    type arity <: Nat

     def productElement[n <: Nat](n: n): productElement[n]
    type productElement[n <: Nat] <: Any

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product]
}
