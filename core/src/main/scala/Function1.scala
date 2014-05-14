

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


object Function1 extends AsKind {
    override  def kindId: kindId = KindId.ofFunction1
    override type kindId         = KindId.ofFunction1
}


trait Function1 extends Relation {
    override type self <: Function1

     def apply[v1 <: Any](v1: v1): apply[v1]
    type apply[v1 <: Any] <: Any

     def compose[that <: Function1](that: that): compose[that]
    type compose[that <: Function1] <: Function1

     def andThen[that <: Function1](that: that): andThen[that]
    type andThen[that <: Function1] <: Function1

     def not: not
    type not <: Function1
}


trait AsFunction1 extends Function1Impl {
    override  def kind: kind = Function1
    override type kind       = Function1.type
}


trait Function1Impl extends Function1 with RelationImpl with RefEquals {
    import Function1Impl._

    override  def asFunction1: asFunction1 = self
    override type asFunction1              = self

    override  def compose[that <: Function1](that: that): compose[that] = Compose(self, that)
    override type compose[that <: Function1]                            = Compose[self, that]

    override  def andThen[that <: Function1](that: that): andThen[that] = Compose(that, self)
    override type andThen[that <: Function1]                            = Compose[that, self]

    override  def not: not = Not(self)
    override type not      = Not[self]

    override  def related[x <: Any, y <: Any](x: x, y: y): related[x, y] = y.equal(apply(x))
    override type related[x <: Any, y <: Any]                            = y#equal[apply[x]]
}


private[sing]
object Function1Impl {
    final case class Compose[f <: Function1, g <: Function1](f: f, g: g) extends AsFunction1 {
        override type self = Compose[f, g]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = f.apply(g.apply(v1))
        override type apply[v1 <: Any]                    = f#apply[g#apply[v1]]
    }

    final case class Not[f <: Function1](f: f) extends AsFunction1 {
        override type self = Not[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = f.apply(v1).asBoolean.not
        override type apply[v1 <: Any]                    = f#apply[v1]#asBoolean#not
    }
}
