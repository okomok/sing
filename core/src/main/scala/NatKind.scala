

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


private[sing]
final class NatKind extends AsKind {
    import NatKind._

    // You can't use macros
    //   whic, depend on Dense, which in turn, needs Nat.
    //   Then kindId can't be defined. (AbstractMethodError)
    override lazy val kindId: kindId = ???
    override     type kindId         = Nothing

    override lazy val naturalOrdering: naturalOrdering = new NaturalOrdering
    override     type naturalOrdering                  =     NaturalOrdering
}


private[sing]
object NatKind {

    private[sing]
    final class NaturalOrdering extends AsOrdering {
        override type self = NaturalOrdering

        override  def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = x.asNat.equal(y.asNat)
        override type equiv[x <: Any, y <: Any]                          = x#asNat#equal[y#asNat]

        override  def compare[x <: Any, y <: Any](x: x, y: y): compare[x, y] =
            `if`(x.asNat.lt(y.asNat),
                Const(LT),
                `if`(x.asNat.gt(y.asNat),
                    Const(GT),
                    Const(EQ)
                )
            ).apply.asOrderingResult.asInstanceOf[compare[x, y]]
        override type compare[x <: Any, y <: Any] =
            `if`[x#asNat#lt[y#asNat],
                Const[LT],
                `if`[x#asNat#gt[y#asNat],
                    Const[GT],
                    Const[EQ]
                ]
            ]#apply#asOrderingResult
    }
}
