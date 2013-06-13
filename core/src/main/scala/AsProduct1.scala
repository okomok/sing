

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsProduct1 extends Product1 with AsProduct {
    override  def kind: kind = Product1
    override type kind       = Product1.type

    override  def asProduct1: asProduct1 = self
    override type asProduct1             = self

    override  def arity: arity = Peano._1
    override type arity        = Peano._1

    override  def asList: asList = _1 :: Nil
    override type asList         = _1 :: Nil

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product1]
}
