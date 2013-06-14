

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object PartialOrdering extends AsKind {
    override  def kindId: kindId = KindId.ofPartialOrdering
    override type kindId         = KindId.ofPartialOrdering
}


trait PartialOrdering extends Equiv {
    override type self <: PartialOrdering

     def tryCompare[x <: Any, y <: Any](x: x, y: y): tryCompare[x, y]
    type tryCompare[x <: Any, y <: Any] <: Option

     def lteq[x <: Any, y <: Any](x: x, y: y): lteq[x, y]
    type lteq[x <: Any, y <: Any] <: Boolean

     def gteq[x <: Any, y <: Any](x: x, y: y): gteq[x, y]
    type gteq[x <: Any, y <: Any] <: Boolean

     def lt[x <: Any, y <: Any](x: x, y: y): lt[x, y]
    type lt[x <: Any, y <: Any] <: Boolean

     def gt[x <: Any, y <: Any](x: x, y: y): gt[x, y]
    type gt[x <: Any, y <: Any] <: Boolean

     def reverse: reverse
    type reverse <: PartialOrdering
}


trait AsPartialOrdering extends PartialOrderingImpl {
    override  def kind: kind = PartialOrdering
    override type kind       = PartialOrdering.type
}


trait PartialOrderingImpl extends PartialOrdering with EquivImpl with RefEquals {
    import PartialOrderingImpl._

    override  def asPartialOrdering: asPartialOrdering = self
    override type asPartialOrdering                    = self

    override  def gteq[x <: Any, y <: Any](x: x, y: y): gteq[x, y] = lteq(y, x)
    override type gteq[x <: Any, y <: Any]                         = lteq[y, x]

    override  def lt[x <: Any, y <: Any](x: x, y: y): lt[x, y] = lteq(x, y).and(equiv(x, y).not)
    override type lt[x <: Any, y <: Any]                       = lteq[x, y]#and[equiv[x, y]#not]

    override  def gt[x <: Any, y <: Any](x: x, y: y): gt[x, y] = gteq(x, y).and(equiv(x, y).not)
    override type gt[x <: Any, y <: Any]                       = gteq[x, y]#and[equiv[x, y]#not]

    override  def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = lteq(x, y).and(lteq(y, x))
    override type equiv[x <: Any, y <: Any]                          = lteq[x, y]#and[lteq[y, x]]

    override  def reverse: reverse = Reverse(self)
    override type reverse          = Reverse[self]

    override def canEqual(that: scala.Any) = that.isInstanceOf[PartialOrdering]
}


private[sing]
object PartialOrderingImpl {
    final case class Reverse[po <: PartialOrdering](po: po) extends AsPartialOrdering {
        override type self = Reverse[po]

        override  def tryCompare[x <: Any, y <: Any](x: x, y: y): tryCompare[x, y] = po.tryCompare(y, x)
        override type tryCompare[x <: Any, y <: Any]                               = po#tryCompare[y, x]

        override  def lteq[x <: Any, y <: Any](x: x, y: y): lteq[x, y]             = po.lteq(y, x)
        override type lteq[x <: Any, y <: Any]                                     = po#lteq[y, x]
    }
}
