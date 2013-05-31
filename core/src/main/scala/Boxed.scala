

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.language.existentials
import scala.language.experimental.macros
import scala.reflect.macros.Context


// Must be placed in top-level for implicit lookup?
trait BoxedKind[A] extends AnyKind {
     val self: self = this
    type self = this.type // K.type seems broken.

     def box(x: A): box = new Boxed[A, self](x, self)
    type box = Boxed[A, self]
}

object BoxedKind {

    implicit def _ofScalaAny[A]: BoxedKind[A] = macro _ofScalaAnyImpl[A]

    def _ofScalaAnyImpl[A: c.WeakTypeTag](c: Context): c.Expr[BoxedKind[A]] = {
        import c.universe._

        val fullName = weakTypeOf[A].typeSymbol.fullName.toString
        val (vkid, tkid) = Macros.skindId(c)(fullName)

        val res = q"""
            new BoxedKind[${weakTypeOf[A]}] {
                override lazy val kindId: kindId = $vkid
                override     type kindId         = $tkid
            }
        """
        c.Expr[BoxedKind[A]](c.typeCheck(res))
    }
}


// Boxed type is equivalent to its kindId in type-level world.
// You need a strong type for correctly defined `self`.

//private[sing]
final class Boxed[A, K <: BoxedKind[A]](override val unsing: A, K: K) extends Any with ValueEquality {
    type self = Boxed[A, K]

    override type unsing = A

    override  def kindId: kindId = K.kindId
    override type kindId         = K#kindId

    override  def asKindId: asKindId = kindId
    override type asKindId           = kindId

    override  def asList: asList = kindId.asList
    override type asList         = kindId#asList

    override  def naturalOrdering: naturalOrdering = asKindId.naturalOrdering
    override type naturalOrdering                  = asKindId#naturalOrdering

     def equal[that <: Any](that: that): equal[that] = naturalOrdering.equiv(asKindId, that.asKindId)
    type equal[that <: Any]                          = naturalOrdering#equiv[asKindId, that#asKindId]

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Boxed[_, _]]
}

object Boxed {
    // Typemethod part is clearly infeasible, but you have weak.typeOf.

     val Kind = BoxedKind
    type Kind[A] = BoxedKind[A]

    def apply[A](from: A)(implicit K: Kind[A]): Boxed[A, K.self] = new Boxed[A, K.self](from, K)
    def kindOf[A](implicit K: Kind[A]): K.self = K
    def kindIdOf[A](implicit i: Kind[A]): i.kindId = i.kindId


    final class Lift1[T1, R, _T1 <: Kind[T1], _R <: Kind[R]](override val unsing: T1 => R, _T1: _T1, _R: _R) extends Function1 with ValueEquality {
        type self = Lift1[T1, R, _T1, _R]
        override type unsing = T1 => R

        override  def apply[v1 <: Any](v1: v1): apply[v1] = _R.box(unsing(v1.unsing.asInstanceOf[T1]))
        override type apply[v1 <: Any]                    = _R#box

        override  def canEqual(that: scala.Any) = that.isInstanceOf[Lift1[_, _, _, _]]
    }

    def lift1[T1, R](f: T1 => R)(implicit _T1: Kind[T1], _R: Kind[R]): Lift1[T1, R, _T1.self, _R.self] = new Lift1[T1, R, _T1.self, _R.self](f, _T1, _R)

}

