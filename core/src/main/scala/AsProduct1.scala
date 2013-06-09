

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsProduct1 extends Product1 with AsProduct {
    override  def asProduct1: asProduct1 = self
    override type asProduct1             = self

    override  def arity: arity = Peano._1
    override type arity        = Peano._1

    override  def productElement[n <: Nat](n: n): productElement[n] =
        `if`(n.equal(Peano._0),
            Const(_1),
            Throw(new IndexOutOfBoundsException(n.toString))
        ).apply

    override type productElement[n <: Nat] =
        `if`[n#equal[Peano._0],
            Const[_1],
            Throw
        ]#apply

    override  def asList: asList = _1 :: Nil
    override type asList         = _1 :: Nil

    override  def naturalOrdering: naturalOrdering = List.naturalOrdering
    override type naturalOrdering                  = List.naturalOrdering

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product1]
}
