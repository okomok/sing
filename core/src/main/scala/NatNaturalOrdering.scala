

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


private[sing]
final class NatNaturalOrdering extends AsOrdering {
    type self = NatNaturalOrdering

    override  def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = x.asNat.equal(y.asNat)
    override type equiv[x <: Any, y <: Any]                          = x#asNat#equal[y#asNat]

    override  def compare[x <: Any, y <: Any](x: x, y: y): compare[x, y] =
        `if`(x.asNat.lt(y.asNat),
            const0(LT),
            `if`(x.asNat.gt(y.asNat),
                const0(GT),
                const0(EQ)
            )
        ).apply.asOrderingResult.asInstanceOf[compare[x, y]]
    override type compare[x <: Any, y <: Any] =
        `if`[x#asNat#lt[y#asNat],
            const0[LT],
            `if`[x#asNat#gt[y#asNat],
                const0[GT],
                const0[EQ]
            ]
        ]#apply#asOrderingResult
}
