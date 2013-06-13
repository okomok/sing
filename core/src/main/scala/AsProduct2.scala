

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsProduct2 extends Product2 with AsProduct {
    override  def kind: kind = Product2
    override type kind       = Product2.type

    override  def asProduct2: asProduct2 = self
    override type asProduct2             = self

    override  def arity: arity = Peano._2
    override type arity        = Peano._2

    override  def asList: asList = _1 :: _2 :: Nil
    override type asList         = _1 :: _2 :: Nil

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product2]
}
