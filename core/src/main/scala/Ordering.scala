

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


object Ordering extends AsKind {
    override  def kindId: kindId = KindId.ofOrdering
    override type kindId         = KindId.ofOrdering
}


trait Ordering extends PartialOrdering {
    override type self <: Ordering

     def compare[x <: Any, y <: Any](x: x, y: y): compare[x, y]
    type compare[x <: Any, y <: Any] <: OrderingResult

     def lteq[x <: Any, y <: Any](x: x, y: y): lteq[x, y]
    type lteq[x <: Any, y <: Any] <: Boolean

     def gteq[x <: Any, y <: Any](x: x, y: y): gteq[x, y]
    type gteq[x <: Any, y <: Any] <: Boolean

     def lt[x <: Any, y <: Any](x: x, y: y): lt[x, y]
    type lt[x <: Any, y <: Any] <: Boolean

     def gt[x <: Any, y <: Any](x: x, y: y): gt[x, y]
    type gt[x <: Any, y <: Any] <: Boolean

     def `match`[x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0](x: x, y: y, flt: flt, fgt: fgt, feq: feq): `match`[x, y, flt, fgt, feq]
    type `match`[x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0] <: Any
}


trait AsOrdering extends OrderingImpl {
    override  def kind: kind = Ordering
    override type kind       = Ordering.type
}


trait OrderingImpl extends Ordering with EquivImpl with RefEquals {
    import OrderingImpl._

    override  def asOrdering: asOrdering = self
    override type asOrdering             = self

    override  def tryCompare[x <: Any, y <: Any](x: x, y: y): tryCompare[x, y] = Some(compare(x, y))
    override type tryCompare[x <: Any, y <: Any]                               = Some[compare[x, y]]

    override  def lteq[x <: Any, y <: Any](x: x, y: y): lteq[x, y] = compare(x, y).isLTEQ
    override type lteq[x <: Any, y <: Any]                         = compare[x, y]#isLTEQ

    override  def gteq[x <: Any, y <: Any](x: x, y: y): gteq[x, y] = compare(x, y).isGTEQ
    override type gteq[x <: Any, y <: Any]                         = compare[x, y]#isGTEQ

    override  def lt[x <: Any, y <: Any](x: x, y: y): lt[x, y] = compare(x, y).isLT
    override type lt[x <: Any, y <: Any]                       = compare[x, y]#isLT

    override  def gt[x <: Any, y <: Any](x: x, y: y): gt[x, y] = compare(x, y).isGT
    override type gt[x <: Any, y <: Any]                       = compare[x, y]#isGT

    override  def reverse: reverse = PartialOrderingImpl.Reverse(self)
    override type reverse          = PartialOrderingImpl.Reverse[self]

    override  def `match`[x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0](x: x, y: y, flt: flt, fgt: fgt, feq: feq): `match`[x, y, flt, fgt, feq] =
        Match(self, x, y, flt, fgt, feq).apply
    override type `match`[x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0] =
        Match[self, x, y, flt, fgt, feq]#apply
}


private[sing]
object OrderingImpl {
    final case class Match[o <: Ordering, x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0](
        o: o, x: x, y: y, flt: flt, fgt: fgt, feq: feq) extends AsFunction0
    {
        override type self = Match[o, x, y, flt, fgt, feq]

        private[this] lazy val c: c = o.compare(x, y)
        private[this]     type c    = o#compare[x, y]

        override  def apply: apply = `if`(id(c).equal(LT), flt, `if`(id(c).equal(GT), fgt, feq)).apply
        override type apply        = `if`[id[c]#equal[LT], flt, `if`[id[c]#equal[GT], fgt, feq]]#apply
    }
}
