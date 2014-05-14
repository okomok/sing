

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


object Boolean extends AsKind {
    override  def kindId: kindId = KindId.ofBoolean
    override type kindId         = KindId.ofBoolean

    override lazy val naturalOrdering: naturalOrdering = new NaturalOrdering
    override     type naturalOrdering                  =     NaturalOrdering

    private[sing]
    final class NaturalOrdering extends AsOrdering {
        override type self = NaturalOrdering

        override  def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = x.asBoolean.equal(y.asBoolean)
        override type equiv[x <: Any, y <: Any]                          = x#asBoolean#equal[y#asBoolean]

        override  def compare[x <: Any, y <: Any](x: x, y: y): compare[x, y] = _compare(x.asBoolean, y.asBoolean)
        override type compare[x <: Any, y <: Any]                            = _compare[x#asBoolean, y#asBoolean]

        private[this]  def _compare[x <: Boolean, y <: Boolean](x: x, y: y): _compare[x, y] =
            `if`(id(x).not.and(y),
                Const(LT),
                `if`(id(x).and(id(y).not),
                    Const(GT),
                    Const(EQ)
                )
            ).apply.asOrderingResult
        private[this] type _compare[x <: Boolean, y <: Boolean] =
            `if`[id[x]#not#and[y],
                Const[LT],
                `if`[id[x]#and[id[y]#not],
                    Const[GT],
                    Const[EQ]
                ]
            ]#apply#asOrderingResult
    }
}


/**
 * The sing Boolean
 */
sealed abstract class Boolean extends Any {
    override type self <: Boolean
    override type unsing = scala.Boolean

     def not: not
    type not <: Boolean

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
sealed abstract class AsBoolean extends BooleanImpl {
    override  def kind: kind = Boolean
    override type kind       = Boolean.type
}


private[sing]
sealed abstract class BooleanImpl extends Boolean with AnyImpl with UnsingEquals {
    override  def asBoolean: asBoolean = self
    override type asBoolean            = self

    override def canEqual(that: scala.Any) = that.isInstanceOf[Boolean]
}


/**
 * The sing true
 */
sealed abstract class `true` extends AsBoolean {
    override type self = `true`

    override  def unsing: unsing = true

    override  def not: not = `false`
    override type not      = `false`

    override  def equal[that <: Any](that: that): equal[that] = that.asBoolean.isTrue
    override type equal[that <: Any]                          = that#asBoolean#isTrue

    override  def and[that <: Boolean](that: that): and[that] = that
    override type and[that <: Boolean]                        = that

    override  def or[that <: Boolean](that: that): or[that] = `true`
    override type or[that <: Boolean]                       = `true`

    override  def `if`[_then <: Function0, _else <: Function0](_then: _then, _else: _else): `if`[_then, _else] = _then
    override type `if`[_then <: Function0, _else <: Function0]                                                 = _then

    override  def asNat: asNat = Peano._1
    override type asNat        = Peano._1

    override private[sing]  def isTrue: isTrue = `true`
    override private[sing] type isTrue         = `true`

    override private[sing]  def isFalse: isFalse = `false`
    override private[sing] type isFalse          = `false`
}

private[sing]
object _TermOfTrue {
    val apply: `true` = new `true`{}
}


/**
 * The sing false
 */
sealed abstract class `false` extends AsBoolean {
    override type self = `false`

    override  def unsing: unsing = false

    override  def not: not = `true`
    override type not      = `true`

    override  def equal[that <: Any](that: that): equal[that] = that.asBoolean.isFalse
    override type equal[that <: Any]                          = that#asBoolean#isFalse

    override  def and[that <: Boolean](that: that): and[that] = `false`
    override type and[that <: Boolean]                        = `false`

    override  def or[that <: Boolean](that: that): or[that] = that
    override type or[that <: Boolean]                       = that

    override  def `if`[_then <: Function0, _else <: Function0](_then: _then, _else: _else): `if`[_then, _else] = _else
    override type `if`[_then <: Function0, _else <: Function0]                                                 = _else

    override  def asNat: asNat = Peano._0
    override type asNat        = Peano._0

    override private[sing]  def isTrue: isTrue = `false`
    override private[sing] type isTrue         = `false`

    override private[sing]  def isFalse: isFalse = `true`
    override private[sing] type isFalse          = `true`
}

private[sing]
object _TermOfFalse {
    val apply: `false` = new `false`{}
}
