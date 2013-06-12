

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Boolean extends HasKind {
    override lazy val kind: kind = new BooleanKind
    override     type kind       =     BooleanKind
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
sealed abstract class AsBoolean extends Boolean with AsAny with UnsingEquals {
    override  def kind: kind = Boolean.kind
    override type kind       = Boolean.kind

    override  def asBoolean: asBoolean = self
    override type asBoolean            = self

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Boolean]
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
