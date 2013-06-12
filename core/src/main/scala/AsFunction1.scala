

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsFunction1 extends Function1 with AsRelation with RefEquals {
    import AsFunction1._

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
object AsFunction1 {

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
