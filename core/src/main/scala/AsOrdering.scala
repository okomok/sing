

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsOrdering extends Ordering with AsEquiv {
    import AsOrdering._

    override  def kind: kind = Ordering.kind
    override type kind       = Ordering.kind

    override  def asOrdering: asOrdering = self
    override type asOrdering             = self

    override  def lteq[x <: Any, y <: Any](x: x, y: y): lteq[x, y] = compare(x, y).isLTEQ
    override type lteq[x <: Any, y <: Any]                         = compare[x, y]#isLTEQ

    override  def gteq[x <: Any, y <: Any](x: x, y: y): gteq[x, y] = compare(x, y).isGTEQ
    override type gteq[x <: Any, y <: Any]                         = compare[x, y]#isGTEQ

    override  def lt[x <: Any, y <: Any](x: x, y: y): lt[x, y] = compare(x, y).isLT
    override type lt[x <: Any, y <: Any]                       = compare[x, y]#isLT

    override  def gt[x <: Any, y <: Any](x: x, y: y): gt[x, y] = compare(x, y).isGT
    override type gt[x <: Any, y <: Any]                       = compare[x, y]#isGT

    override  def `match`[x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0](x: x, y: y, flt: flt, fgt: fgt, feq: feq): `match`[x, y, flt, fgt, feq] =
        Match(self, x, y, flt, fgt, feq).apply
    override type `match`[x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0] =
        Match[self, x, y, flt, fgt, feq]#apply
}


private[sing]
object AsOrdering {
    final case class Match[o <: Ordering, x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0](
        o: o, x: x, y: y, flt: flt, fgt: fgt, feq: feq) extends AsFunction0
    {
        override type self = Match[o, x, y, flt, fgt, feq]

        private[this] lazy val c: c = o.compare(x, y)
        private[this]     type c    = o#compare[x, y]

        override  def apply: apply = `if`(c.equal(LT), flt, `if`(c.equal(GT), fgt, feq)).apply.asInstanceOf[apply]
        override type apply        = `if`[c#equal[LT], flt, `if`[c#equal[GT], fgt, feq]]#apply
    }
}
