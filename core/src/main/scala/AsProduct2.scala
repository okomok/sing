

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsProduct2 extends Product2 with AsProduct {
    override  def kind: kind = Product2.kind
    override type kind       = Product2.kind

    override  def asProduct2: asProduct2 = self
    override type asProduct2             = self

    override  def arity: arity = Peano._2
    override type arity        = Peano._2

    override  def productElement[n <: Nat](n: n): productElement[n] =
        `if`(n.equal(Peano._0),
            Const(_1),
            `if`(n.equal(Peano._1),
                Const(_2),
                Throw(new IndexOutOfBoundsException(n.toString))
            )
        ).apply.asInstanceOf[productElement[n]]

    override type productElement[n <: Nat] =
        `if`[n#equal[Peano._0],
            Const[_1],
            `if`[n#equal[Peano._1],
                Const[_2],
                Throw
            ]
        ]#apply

    override  def asList: asList = _1 :: _2 :: Nil
    override type asList         = _1 :: _2 :: Nil

    override def canEqual(that: scala.Any) = that.isInstanceOf[Product2]
}
