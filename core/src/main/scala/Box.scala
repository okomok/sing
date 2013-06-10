

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.language.existentials


// Box type is equivalent to its kindId in type-level world.
// You need a strong type for correctly defined `self`.
final class Box[A, _A <: BoxKind[A]](override val unsing: A, _A: _A) extends AsAny with UnsingEquals {
    override type self = Box[A, _A]

    override type unsing = A

    override  def kindId: kindId = _A.kindId
    override type kindId         = _A#kindId

    override  def asKindId: asKindId = kindId
    override type asKindId           = kindId

    override  def asList: asList = kindId.asList
    override type asList         = kindId#asList

    override  def naturalOrdering: naturalOrdering = asKindId.naturalOrdering
    override type naturalOrdering                  = asKindId#naturalOrdering

    override  def equal[that <: Any](that: that): equal[that] = naturalOrdering.equiv(asKindId, that.asKindId)
    override type equal[that <: Any]                          = naturalOrdering#equiv[asKindId, that#asKindId]

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Box[_, _]]
}


object Box {
    // Typemethod part is clearly infeasible, but you have typeOf.

//  Implicit lookup fails...
//     val Kind    = BoxKind
//    type Kind[A] = BoxKind[A]

    def apply[A](from: A)(implicit _A: BoxKind[A]): Box[A, _A.self] = new Box[A, _A.self](from, _A)
    def unapply[b <: Any](b: b): scala.Option[b#unsing] = scala.Some(b.unsing)

    def kindOf[A](implicit _A: BoxKind[A]): _A.self = _A
    def kindIdOf[A](implicit _A: BoxKind[A]): _A.kindId = _A.kindId

}

