

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsPartialFunction extends PartialFunction with AsFunction1 {
    import AsPartialFunction._

    override  def asFunction1: asFunction1 = self
    override type asFunction1              = self

    override  def asPartialFunction: asPartialFunction = self
    override type asPartialFunction                    = self

    override  def orElse[that <: PartialFunction](that: that): orElse[that] = OrElse(self, that)
    override type orElse[that <: PartialFunction]                           = OrElse[self, that]

    override  def lift: lift = Lift(self)
    override type lift       = Lift[self]

    override  def applyOrElse[x <: Any, d <: Function1](x: x, d: d): applyOrElse[x, d] = `if`(isDefinedAt(x), Const(self), Const(d)).apply.asFunction1.apply(x)//.asInstanceOf[applyOrElse[x, d]]
    override type applyOrElse[x <: Any, d <: Function1]                                = `if`[isDefinedAt[x], Const[self], Const[d]]#apply#asFunction1#apply[x]
}


private[sing]
object AsPartialFunction {

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

    final case class AndThen[pf <: PartialFunction, k <: Function1](pf: pf, k: k) extends AsPartialFunction {
        override type self = AndThen[pf, k]
        override  def isDefinedAt[x <: Any](x: x): isDefinedAt[x] = pf.isDefinedAt(x)
        override type isDefinedAt[x <: Any]                       = pf#isDefinedAt[x]
        override  def apply[x <: Any](x: x): apply[x] = k.apply(pf.apply(x))
        override type apply[x <: Any]                 = k#apply[pf#apply[x]]
    }
}
