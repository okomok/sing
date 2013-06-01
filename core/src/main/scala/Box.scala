

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.language.existentials
import scala.language.experimental.macros
import scala.reflect.macros.Context


// Must be placed in top-level for implicit lookup?
trait BoxKind[A] extends AnyKind {
     val self: self = this
    type self = this.type // K.type seems broken.

     def box(x: A): box = new Box[A, self](x, self)
    type box = Box[A, self]
}

object BoxKind {

    implicit def _ofScalaAny[A]: BoxKind[A] = macro _ofScalaAnyImpl[A]

    def _ofScalaAnyImpl[A: c.WeakTypeTag](c: Context): c.Expr[BoxKind[A]] = {
        import c.universe._

        val fullName = weakTypeOf[A].typeSymbol.fullName.toString
        val (vkid, tkid) = Macros.skindId(c)(fullName)

        val res = q"""
            new BoxKind[${weakTypeOf[A]}] {
                override lazy val kindId: kindId = $vkid
                override     type kindId         = $tkid
            }
        """
        c.Expr[BoxKind[A]](c.typeCheck(res))
    }
}


// Box type is equivalent to its kindId in type-level world.
// You need a strong type for correctly defined `self`.
final class Box[A, _A <: BoxKind[A]](override val unsing: A, _A: _A) extends Any with ValueEquality {
    type self = Box[A, _A]

    override type unsing = A

    override  def kindId: kindId = _A.kindId
    override type kindId         = _A#kindId

    override  def asKindId: asKindId = kindId
    override type asKindId           = kindId

    override  def asList: asList = kindId.asList
    override type asList         = kindId#asList

    override  def naturalOrdering: naturalOrdering = asKindId.naturalOrdering
    override type naturalOrdering                  = asKindId#naturalOrdering

     def equal[that <: Any](that: that): equal[that] = naturalOrdering.equiv(asKindId, that.asKindId)
    type equal[that <: Any]                          = naturalOrdering#equiv[asKindId, that#asKindId]

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Box[_, _]]
}

object Box {
    // Typemethod part is clearly infeasible, but you have Weak.typeOf.

//  Implicit lookup fails...
//     val Kind    = BoxKind
//    type Kind[A] = BoxKind[A]

    def apply[A](from: A)(implicit _A: BoxKind[A]): Box[A, _A.self] = new Box[A, _A.self](from, _A)
    def unapply[b <: Any](b: b): scala.Option[b#unsing] = scala.Some(b.unsing)

    def kindOf[A](implicit _A: BoxKind[A]): _A.self = _A
    def kindIdOf[A](implicit _A: BoxKind[A]): _A.kindId = _A.kindId

}

