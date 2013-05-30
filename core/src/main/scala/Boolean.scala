

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Boolean extends Macros.HasKindId


/**
 * The sing Boolean
 */
sealed abstract class Boolean extends Macros.NewKind {
    type self <: Boolean
    type unsing = scala.Boolean

     def not: not
    type not <: Boolean

     def equal[that <: Boolean](that: that): equal[that]
    type equal[that <: Boolean] <: Boolean

     def nequal[that <: Boolean](that: that): nequal[that]
    type nequal[that <: Boolean] <: Boolean

     def and[that <: Boolean](that: that): and[that]
    type and[that <: Boolean] <: Boolean

     def or[that <: Boolean](that: that): or[that]
    type or[that <: Boolean] <: Boolean

     def `if`[_then <: Function0, _else <: Function0](_then: _then, _else: _else): `if`[_then, _else]
    type `if`[_then <: Function0, _else <: Function0] <: Function0

    private[sing]  def isTrue: isTrue
    private[sing] type isTrue <: Boolean

    private[sing]  def isFalse: isFalse
    private[sing] type isFalse <: Boolean
}


private[sing]
sealed abstract class AbstractBoolean extends Boolean {
    final override  def asBoolean: asBoolean = self
    final override type asBoolean            = self

    final override  def nequal[that <: Boolean](that: that): nequal[that] = equal(that).not
    final override type nequal[that <: Boolean]                           = equal[that]#not

    final override  def naturalOrdering: naturalOrdering = _Boolean.NaturalOrdering
    final override type naturalOrdering                  = _Boolean.NaturalOrdering

    final override  def canEqual(that: scala.Any) = that.isInstanceOf[Boolean]
}


/**
 * The sing true
 */
sealed abstract class `true` extends AbstractBoolean {
    type self = `true`

    override  def unsing: unsing = true

    override  def not: not = `false`
    override type not      = `false`

    override  def equal[that <: Boolean](that: that): equal[that] = that.isTrue
    override type equal[that <: Boolean]                          = that#isTrue

    override  def and[that <: Boolean](that: that): and[that] = that
    override type and[that <: Boolean]                        = that

    override  def or[that <: Boolean](that: that): or[that] = `true`
    override type or[that <: Boolean]                       = `true`

    override  def `if`[_then <: Function0, _else <: Function0](_then: _then, _else: _else): `if`[_then, _else] = _then
    override type `if`[_then <: Function0, _else <: Function0]                                              = _then

    override  def asNat: asNat = nat.peano._1
    override type asNat        = nat.peano._1

    override private[sing]  def isTrue: isTrue = `true`
    override private[sing] type isTrue         = `true`

    override private[sing]  def isFalse: isFalse = `false`
    override private[sing] type isFalse          = `false`
}


/**
 * The sing false
 */
sealed abstract class `false` extends AbstractBoolean {
    type self = `false`

    override  def unsing: unsing = false

    override  def not: not = `true`
    override type not      = `true`

    override  def equal[that <: Boolean](that: that): equal[that] = that.isFalse
    override type equal[that <: Boolean]                          = that#isFalse

    override  def and[that <: Boolean](that: that): and[that] = `false`
    override type and[that <: Boolean]                        = `false`

    override  def or[that <: Boolean](that: that): or[that] = that
    override type or[that <: Boolean]                       = that

    override  def `if`[_then <: Function0, _else <: Function0](_then: _then, _else: _else): `if`[_then, _else] = _else
    override type `if`[_then <: Function0, _else <: Function0]                                              = _else

    override  def asNat: asNat = nat.peano._0
    override type asNat        = nat.peano._0

    override private[sing]  def isTrue: isTrue = `false`
    override private[sing] type isTrue         = `false`

    override private[sing]  def isFalse: isFalse = `true`
    override private[sing] type isFalse          = `true`
}


private[sing]
object _Boolean {
    val `true` = new `true`{}
    val `false` = new `false`{}

    import ordering.{LT, GT, EQ}

    val NaturalOrdering = new NaturalOrdering
    final class NaturalOrdering extends ordering.AbstractOrdering {
        type self = NaturalOrdering

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
}
