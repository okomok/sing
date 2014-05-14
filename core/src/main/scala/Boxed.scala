

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Boxed extends AsKind {
    override  def kindId: kindId = KindId.ofBoxed
    override type kindId         = KindId.ofBoxed
}


/**
 * The kind of boxed types
 */
trait Boxed extends Any {
    override type self <: Boxed

     def boxId: boxId
    type boxId <: List
}


private[sing]
sealed abstract class AsBoxed extends BoxedImpl {
    override  def kind: kind = Boxed
    override type kind       = Boxed.type
}


private[sing]
sealed abstract class BoxedImpl extends Boxed with AnyImpl with UnsingEquals {
    override  def asBoxed: asBoxed = self
    override type asBoxed          = self

    override  def equal[that <: Any](that: that): equal[that] = boxId.equal(that.asBoxed.boxId)
    override type equal[that <: Any]                          = boxId#equal[that#asBoxed#boxId]

    override def canEqual(that: scala.Any) = that.isInstanceOf[Boxed]
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
    // this.type seems broken, so we define...
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
    implicit def apply[x]: Boxer[x] = macro impl[x]

    def impl[x](c: Context)(implicit tx: c.WeakTypeTag[x]): c.Expr[Boxer[x]] = {
        import c.universe._
        import makro._

        val vid = TypeId.inTerm(c)(tx.tpe)
        val tid = TypeId.inType(c)(tx.tpe)

        val res = q"""
            new ${sing_(c)}.Boxer[${tx.tpe}] {
                override lazy val boxId: boxId = $vid
                override     type boxId        = $tid
            }
        """
        c.Expr[Boxer[x]](c.typecheck(res))
    }
}
