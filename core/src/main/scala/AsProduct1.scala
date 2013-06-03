

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsProduct1 extends Product1 with AsProduct {
    final override  def asProduct1: asProduct1 = self
    final override type asProduct1             = self

    final override  def arity: arity = Peano._1
    final override type arity        = Peano._1

    final override  def productElement[n <: Nat](n: n): productElement[n] =
        `if`(n.equal(Peano._0),
            const0(_1),
            throw0(new IndexOutOfBoundsException(n.toString))
        ).apply

    final override type productElement[n <: Nat] =
        `if`[n#equal[Peano._0],
            const0[_1],
            throw0[_]
        ]#apply

    final override  def asList: asList = _1 :: Nil
    final override type asList         = _1 :: Nil

    final override  def naturalOrdering: naturalOrdering = List.naturalOrdering
    final override type naturalOrdering                  = List.naturalOrdering

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product1]
}
