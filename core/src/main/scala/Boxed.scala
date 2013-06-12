

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Boxed {
    lazy val kind: kind = new BoxedKind
        type kind       =     BoxedKind
}


/**
 * The kind of boxed types
 */
trait Boxed extends Any {
    override type self <: Boxed

    // List of Denses
     def boxId: boxId
    type boxId <: List
}


private[sing]
sealed abstract class AsBoxed extends Boxed with AsAny with UnsingEquals with ListLike {
    override  def kind: kind = Boxed.kind
    override type kind       = Boxed.kind

    override  def asBoxed: asBoxed = self
    override type asBoxed          = self

    override  def asList: asList = boxId
    override type asList         = boxId

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Boxed]
}


private[sing]
final case class BoxOf[x, id <: List](override val unsing: x, override val boxId: id) extends AsBoxed {
    override type self = BoxOf[x, id]
    override type unsing = x
    override type boxId = id
}


private[sing]
final case class EmptyBox[x, id <: List](override val boxId: id) extends AsBoxed {
    override type self = EmptyBox[x, id]
    override type unsing = x
    override type boxId = id
}


object Box {
    def apply[x](x: x)(implicit _B: Boxer[x]): _B.box = _B.box(x)
    def unapply[b <: Boxed](b: b): scala.Option[b#unsing] = scala.Some(b.unsing)

    def empty[x](implicit _B: Boxer[x]): _B.empty = _B.empty
}


trait Boxer[x] {
     val self: self = this
    type self       = this.type

     def boxId: boxId
    type boxId <: List

     def box(x: x): box = BoxOf(x, boxId)
    type box            = BoxOf[x, boxId]

     def empty: empty = EmptyBox(boxId)
    type empty        = EmptyBox[x, boxId]
}

object Boxer {
    // Macro is smart enough to keep types structural.
    implicit def apply[A]: Boxer[A] = macro impl[A]

    def impl[A: c.WeakTypeTag](c: Context): c.Expr[Boxer[A]] = {
        import c.universe._

        val fullName = weakTypeOf[A].typeSymbol.fullName.toString
        val (vid, tid) = makro.BoxId(c)(fullName)

        val res = q"""
            new Boxer[${weakTypeOf[A]}] {
                override lazy val boxId: boxId = $vid
                override     type boxId        = $tid
            }
        """
        c.Expr[Boxer[A]](c.typeCheck(res))
    }
}
