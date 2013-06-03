

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package ordering


private[sing]
final case class Match[o <: Ordering, x <: Any, y <: Any, flt <: Function0, fgt <: Function0, feq <: Function0](
    o: o, x: x, y: y, flt: flt, fgt: fgt, feq: feq) extends AsFunction0
{
    override type self = Match[o, x, y, flt, fgt, feq]

    private[this] lazy val c: c = o.compare(x, y)
    private[this]     type c    = o#compare[x, y]

    override  def apply: apply = `if`(c.equal(LT), flt, `if`(c.equal(GT), fgt, feq)).apply.asInstanceOf[apply]
    override type apply        = `if`[c#equal[LT], flt, `if`[c#equal[GT], fgt, feq]]#apply
}
