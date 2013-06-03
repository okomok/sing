

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


private[sing]
final class BooleanNaturalOrdering extends AsOrdering {
    type self = BooleanNaturalOrdering

    override  def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = x.asBoolean.equal(y.asBoolean)
    override type equiv[x <: Any, y <: Any]                          = x#asBoolean#equal[y#asBoolean]

    override  def compare[x <: Any, y <: Any](x: x, y: y): compare[x, y] = _compare(x.asBoolean, y.asBoolean)
    override type compare[x <: Any, y <: Any]                            = _compare[x#asBoolean, y#asBoolean]

    private[this]  def _compare[x <: Boolean, y <: Boolean](x: x, y: y): _compare[x, y] =
        `if`(x.not.and(y),
            const0(LT),
            `if`(x.and(y.not),
                const0(GT),
                const0(EQ)
            )
        ).apply.asOrderingResult.asInstanceOf[_compare[x, y]]
    private[this] type _compare[x <: Boolean, y <: Boolean] =
        `if`[x#not#and[y],
            const0[LT],
            `if`[x#and[y#not],
                const0[GT],
                const0[EQ]
            ]
        ]#apply#asOrderingResult
}
