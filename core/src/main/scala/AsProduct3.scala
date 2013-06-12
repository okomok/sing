

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsProduct3 extends Product3 with AsProduct {
    override  def kind: kind = Product3.kind
    override type kind       = Product3.kind

    override  def asProduct3: asProduct3 = self
    override type asProduct3             = self

    override  def arity: arity = Peano._3
    override type arity        = Peano._3

    override  def productElement[n <: Nat](n: n): productElement[n] =
        `if`(n.equal(Peano._0),
            Const(_1),
            `if`(n.equal(Peano._1),
                Const(_2),
                `if`(n.equal(Peano._2),
                    Const(_3),
                    Throw(new IndexOutOfBoundsException(n.toString))
                )
            )
        ).apply.asInstanceOf[productElement[n]]

    override type productElement[n <: Nat] =
        `if`[n#equal[Peano._0],
            Const[_1],
            `if`[n#equal[Peano._1],
                Const[_2],
                `if`[n#equal[Peano._2],
                    Const[_3],
                    Throw
                ]
            ]
        ]#apply

    override  def asList: asList = _1 :: _2 :: _3 :: Nil
    override type asList         = _1 :: _2 :: _3 :: Nil

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product3]
}
