

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsFunction3 extends Function3 with AsAny with RefEquals {
    import AsFunction3._

    override  def asFunction3: asFunction3 = self
    override type asFunction3              = self

    override  def apply[v1 <: Any, v2 <: Any, v3 <: Any](v1: v1, v2: v2, v3: v3): apply[v1, v2, v3]
    override type apply[v1 <: Any, v2 <: Any, v3 <: Any] <: Any

    override  def curried: curried = Curried(self)
    override type curried          = Curried[self]

    override  def tupled: tupled = Tupled(self)
    override type tupled         = Tupled[self]

    override  def tupledLeft: tupledLeft = TupledLeft(self)
    override type tupledLeft             = TupledLeft[self]

    override  def not: not = Not(self)
    override type not      = Not[self]
}


private[sing]
object AsFunction3 {

    final case class Curried[f <: Function3](f: f) extends AsFunction1 {
        override type self = Curried[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = Bind1(f, v1)
        override type apply[v1 <: Any]                    = Bind1[f, v1]
    }

    final case class Bind1[f <: Function3, v1 <: Any](f: f, v1: v1) extends AsFunction1 {
        override type self = Bind1[f, v1]
        override  def apply[v2 <: Any](v2: v2): apply[v2] = Bind2(f, v1, v2)
        override type apply[v2 <: Any]                    = Bind2[f, v1, v2]
    }

    final case class Bind2[f <: Function3, v1 <: Any, v2 <: Any](f: f, v1: v1, v2: v2) extends AsFunction1 {
        override type self = Bind2[f, v1, v2]
        override  def apply[v3 <: Any](v3: v3): apply[v3] = f.apply(v1, v2, v3)
        override type apply[v3 <: Any]                    = f#apply[v1, v2, v3]
    }

    final case class Tupled[f <: Function3](f: f) extends AsFunction1 {
        override type self = Tupled[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = _aux(v1.asProduct3)
        override type apply[v1 <: Any]                    = _aux[v1#asProduct3]

        private[this]  def _aux[p <: Product3](p: p): _aux[p] = f.apply(p._1, p._2, p._3)
        private[this] type _aux[p <: Product3]                = f#apply[p#_1, p#_2, p#_3]
    }

    final case class TupledLeft[f <: Function3](f: f) extends AsFunction1 {
        override type self = TupledLeft[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = _aux(v1.asProduct2)
        override type apply[v1 <: Any]                    = _aux[v1#asProduct2]

        private[this]  def _aux[p <: Product2](p: p): _aux[p] = _aux2(p._1.asProduct2, p._2)
        private[this] type _aux[p <: Product2]                = _aux2[p#_1#asProduct2, p#_2]

        private[this]  def _aux2[p <: Product2, v3 <: Any](p: p, v3: v3): _aux2[p, v3] = f.apply(p._1, p._2, v3)
        private[this] type _aux2[p <: Product2, v3 <: Any]                             = f#apply[p#_1, p#_2, v3]
    }

    final case class Not[f <: Function3](f: f) extends AsFunction3 {
        override type self = Not[f]
        override  def apply[v1 <: Any, v2 <: Any, v3 <: Any](v1: v1, v2: v2, v3: v3): apply[v1, v2, v3] = f.apply(v1, v2, v3).asBoolean.not
        override type apply[v1 <: Any, v2 <: Any, v3 <: Any]                                            = f#apply[v1, v2, v3]#asBoolean#not
    }
}
