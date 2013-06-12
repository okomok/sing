

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


private[sing]
final class BooleanKind extends AsKind {
    import BooleanKind._

    override lazy val kindId: kindId = ???
    override     type kindId         = Nothing

    override lazy val naturalOrdering: naturalOrdering = new NaturalOrdering
    override     type naturalOrdering                  =     NaturalOrdering
}


private[sing]
object BooleanKind {

    final class NaturalOrdering extends AsOrdering {
        override type self = NaturalOrdering

        override  def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = x.asBoolean.equal(y.asBoolean)
        override type equiv[x <: Any, y <: Any]                          = x#asBoolean#equal[y#asBoolean]

        override  def compare[x <: Any, y <: Any](x: x, y: y): compare[x, y] = _compare(x.asBoolean, y.asBoolean)
        override type compare[x <: Any, y <: Any]                            = _compare[x#asBoolean, y#asBoolean]

        private[this]  def _compare[x <: Boolean, y <: Boolean](x: x, y: y): _compare[x, y] =
            `if`(x.not.and(y),
                Const(LT),
                `if`(x.and(y.not),
                    Const(GT),
                    Const(EQ)
                )
            ).apply.asOrderingResult.asInstanceOf[_compare[x, y]]
        private[this] type _compare[x <: Boolean, y <: Boolean] =
            `if`[x#not#and[y],
                Const[LT],
                `if`[x#and[y#not],
                    Const[GT],
                    Const[EQ]
                ]
            ]#apply#asOrderingResult
    }
}
