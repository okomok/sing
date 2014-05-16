

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


object PartialFunction extends AsKind {
    import PartialFunctionImpl._

    override  def kindId: kindId = KindId.ofPartialFunction
    override type kindId         = KindId.ofPartialFunction

    lazy val empty: empty = new Empty
        type empty        =     Empty
}


trait PartialFunction extends Function1 {
    override type self <: PartialFunction

     def isDefinedAt[x <: Any](x: x): isDefinedAt[x]
    type isDefinedAt[x <: Any] <: Boolean

     def orElse[that <: PartialFunction](that: that): orElse[that]
    type orElse[that <: PartialFunction] <: PartialFunction

     def lift: lift
    type lift <: Function1

     def applyOrElse[x <: Any, d <: Function1](x: x, d: d): applyOrElse[x, d]
    type applyOrElse[x <: Any, d <: Function1] <: Any

    override type andThen[that <: Function1] <: PartialFunction
    override type not <: PartialFunction
}


trait AsPartialFunction extends PartialFunctionImpl {
    override  def kind: kind = PartialFunction
    override type kind       = PartialFunction.type
}


trait PartialFunctionImpl extends PartialFunction with RelationImpl with RefEquals {
    import PartialFunctionImpl._

    override  def asPartialFunction: asPartialFunction = self
    override type asPartialFunction                    = self

    override  def orElse[that <: PartialFunction](that: that): orElse[that] = OrElse(self, that)
    override type orElse[that <: PartialFunction]                           = OrElse[self, that]

    override  def lift: lift = Lift(self)
    override type lift       = Lift[self]

    override  def applyOrElse[x <: Any, d <: Function1](x: x, d: d): applyOrElse[x, d] = `if`(isDefinedAt(x), Const(self), Const(d)).apply.asFunction1.apply(x)
    override type applyOrElse[x <: Any, d <: Function1]                                = `if`[isDefinedAt[x], Const[self], Const[d]]#apply#asFunction1#apply[x]

// as Function1
    override  def asFunction1: asFunction1 = self
    override type asFunction1              = self

    override  def compose[that <: Function1](that: that): compose[that] = Function1Impl.Compose(self, that)
    override type compose[that <: Function1]                            = Function1Impl.Compose[self, that]

    override  def andThen[that <: Function1](that: that): andThen[that] = AndThen(self, that)
    override type andThen[that <: Function1]                            = AndThen[self, that]

    override  def not: not = Not(self)
    override type not      = Not[self]

    override  def related[x <: Any, y <: Any](x: x, y: y): related[x, y] = `if`(isDefinedAt(x), EqualApply(self, x, y), Const(`false`)).apply.asBoolean
    override type related[x <: Any, y <: Any]                            = `if`[isDefinedAt[x], EqualApply[self, x, y], Const[`false`]]#apply#asBoolean
}


private[sing]
object PartialFunctionImpl {
    final class Empty extends AsPartialFunction {
        override type self = Empty
        override  def isDefinedAt[x <: Any](x: x): isDefinedAt[x] = `false`
        override type isDefinedAt[x <: Any]                       = `false`

        private[sing] lazy val _apply = Unsupported("PartialFunction.empty.apply")
        override  def apply[x <: Any](x: x): apply[x] = _apply.apply
        override type apply[x <: Any]                 = _apply.apply
    }

    final case class OrElse[f1 <: PartialFunction, f2 <: PartialFunction](f1: f1, f2: f2) extends AsPartialFunction {
        override type self = OrElse[f1, f2]
        override  def isDefinedAt[x <: Any](x: x): isDefinedAt[x] = f1.isDefinedAt(x).or(f2.isDefinedAt(x))
        override type isDefinedAt[x <: Any]                       = f1#isDefinedAt[x]#or[f2#isDefinedAt[x]]
        override  def apply[x <: Any](x: x): apply[x] = f1.applyOrElse(x, f2)
        override type apply[x <: Any]                 = f1#applyOrElse[x, f2]
    }

    final case class Lift[pf <: PartialFunction](pf: pf) extends AsFunction1 {
        override type self = Lift[pf]
        override  def apply[x <: Any](x: x): apply[x] = `if`(pf.isDefinedAt(x), SomeApply(pf, x), Const(None)).apply
        override type apply[x <: Any]                 = `if`[pf#isDefinedAt[x], SomeApply[pf, x], Const[None]]#apply
    }

    final case class SomeApply[pf <: PartialFunction, x <: Any](pf: pf, x: x) extends AsFunction0 {
        override type self = SomeApply[pf, x]
        override  def apply: apply = Some(pf.apply(x))
        override type apply        = Some[pf#apply[x]]
    }

    final case class AndThen[pf <: PartialFunction, that <: Function1](pf: pf, that: that) extends AsPartialFunction {
        override type self = AndThen[pf, that]
        override  def isDefinedAt[x <: Any](x: x): isDefinedAt[x] = pf.isDefinedAt(x)
        override type isDefinedAt[x <: Any]                       = pf#isDefinedAt[x]
        override  def apply[x <: Any](x: x): apply[x] = that.apply(pf.apply(x))
        override type apply[x <: Any]                 = that#apply[pf#apply[x]]
    }

    final case class Not[pf <: PartialFunction](pf: pf) extends AsPartialFunction {
        override type self = Not[pf]
        override  def isDefinedAt[x <: Any](x: x): isDefinedAt[x] = pf.isDefinedAt(x)
        override type isDefinedAt[x <: Any]                       = pf#isDefinedAt[x]
        override  def apply[x <: Any](x: x): apply[x] = pf.apply(x).asBoolean.not
        override type apply[x <: Any]                 = pf#apply[x]#asBoolean#not
    }

    final case class EqualApply[pf <: PartialFunction, x <: Any, y <: Any](pf: pf, x: x, y: y) extends AsFunction0 {
        override type self = EqualApply[pf, x, y]
        override  def apply: apply = y.equal(pf.apply(x))
        override type apply        = y#equal[pf#apply[x]]
    }
}
