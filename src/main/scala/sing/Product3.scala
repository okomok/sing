

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


import nat.peano


trait Product3 extends Product {
    type self <: Product3

    final override  def asProduct3: asProduct3 = self
    final override type asProduct3             = self

     def _1: _1
    type _1 <: Any

     def _2: _2
    type _2 <: Any

     def _3: _3
    type _3 <: Any

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product3]
}


private[sing]
trait AbstractProduct3 extends Product3 {
    final override  def arity: arity = peano._3
    final override type arity        = peano._3

    final override  def productElement[n <: Nat](n: n): productElement[n] =
        `if`(n.equal(peano._0),
            const0(_1),
            `if`(n.equal(peano._1),
                const0(_2),
                `if`(n.equal(peano._2),
                    const0(_3),
                    throw0(new IndexOutOfBoundsException(n.toString))
                )
            )
        ).apply.asInstanceOf[productElement[n]]

    final override type productElement[n <: Nat] =
        `if`[n#equal[peano._0],
            const0[_1],
            `if`[n#equal[peano._1],
                const0[_2],
                `if`[n#equal[peano._2],
                    const0[_3],
                    throw0[_]
                ]
            ]
        ]#apply

    final override  def asList: asList = _1 :: _2 :: _3 :: Nil
    final override type asList         = _1 :: _2 :: _3 :: Nil

    final override  def naturalOrdering: naturalOrdering = list.naturalOrdering
    final override type naturalOrdering                  = list.naturalOrdering
}
