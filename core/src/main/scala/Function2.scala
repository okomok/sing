

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Function2 extends AsKind


trait Function2 extends Any {
    override type self <: Function2

     def apply[v1 <: Any, v2 <: Any](v1: v1, v2: v2): apply[v1, v2]
    type apply[v1 <: Any, v2 <: Any] <: Any

     def curried: curried
    type curried <: Function1

     def tupled: tupled
    type tupled  <: Function1

     def not: not
    type not <: Function2
}


trait AsFunction2 extends Function2Impl {
    override  def kind: kind = Function2
    override type kind       = Function2.type
}


trait Function2Impl extends Function2 with AnyImpl with RefEquals {
    import Function2Impl._

    override  def asFunction2: asFunction2 = self
    override type asFunction2              = self

    override  def curried: curried = Curried(self)
    override type curried          = Curried[self]

    override  def tupled: tupled = Tupled(self)
    override type tupled         = Tupled[self]

    override  def not: not = Not(self)
    override type not      = Not[self]
}


private[sing]
object Function2Impl {
    final case class Curried[f <: Function2](f: f) extends AsFunction1 {
        override type self = Curried[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = Bind1(f, v1)
        override type apply[v1 <: Any]                    = Bind1[f, v1]
    }

    final case class Bind1[f <: Function2, v1 <: Any](f: f, v1: v1) extends AsFunction1 {
        override type self = Bind1[f, v1]
        override  def apply[v2 <: Any](v2: v2): apply[v2] = f.apply(v1, v2)
        override type apply[v2 <: Any]                    = f#apply[v1, v2]
    }

    final case class Tupled[f <: Function2](f: f) extends AsFunction1 {
        override type self = Tupled[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = _aux(v1.asProduct2)
        override type apply[v1 <: Any]                    = _aux[v1#asProduct2]

        private[this]  def _aux[p <: Product2](p: p): _aux[p] = f.apply(p._1, p._2)
        private[this] type _aux[p <: Product2]                = f#apply[p#_1, p#_2]
    }

    final case class Not[f <: Function2](f: f) extends AsFunction2 {
        override type self = Not[f]
        override  def apply[v1 <: Any, v2 <: Any](v1: v1, v2: v2): apply[v1, v2] = f.apply(v1, v2).asBoolean.not
        override type apply[v1 <: Any, v2 <: Any]                                = f#apply[v1, v2]#asBoolean#not
    }
}
