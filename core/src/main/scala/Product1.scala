

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import nat.peano


trait Product1 extends Product {
    type self <: Product1

    final override  def asProduct1: asProduct1 = self
    final override type asProduct1             = self

     def _1: _1
    type _1 <: Any

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product1]
}


private[sing]
trait AbstractProduct1 extends Product1 {
    final override  def arity: arity = peano._1
    final override type arity        = peano._1

    final override  def productElement[n <: Nat](n: n): productElement[n] =
        `if`(n.equal(peano._0),
            const0(_1),
            throw0(new IndexOutOfBoundsException(n.toString))
        ).apply

    final override type productElement[n <: Nat] =
        `if`[n#equal[peano._0],
            const0[_1],
            throw0[_]
        ]#apply

    final override  def asList: asList = _1 :: Nil
    final override type asList         = _1 :: Nil

    final override  def naturalOrdering: naturalOrdering = list.naturalOrdering
    final override type naturalOrdering                  = list.naturalOrdering
}
