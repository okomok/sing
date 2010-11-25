

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


import nat.peano


trait Product2 extends Product {
    type self <: Product2

    final override  def asProduct2: asProduct2 = self
    final override type asProduct2             = self

     def _1: _1
    type _1 <: Any

     def _2: _2
    type _2 <: Any

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product2]
}


private[sing]
trait AbstractProduct2 extends Product2 {
    final override  def arity: arity = peano._2
    final override type arity        = peano._2

    final override  def productElement[n <: Nat](n: n): productElement[n] =
        `if`(n.equal(peano._0),
            const0(_1),
            `if`(n.equal(peano._1),
                const0(_2),
                throw0(new IndexOutOfBoundsException(n.toString))
            )
        ).apply.asInstanceOf[productElement[n]]

    final override type productElement[n <: Nat] =
        `if`[n#equal[peano._0],
            const0[_1],
            `if`[n#equal[peano._1],
                const0[_2],
                throw0[_]
            ]
        ]#apply

    final override  def asList: asList = _1 :: _2 :: Nil
    final override type asList         = _1 :: _2 :: Nil

    final override  def naturalOrdering: naturalOrdering = list.naturalOrdering
    final override type naturalOrdering                  = list.naturalOrdering
}
