

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


sealed abstract class Unit extends Any {
    override type self = Unit

    override  def unsing: unsing = ()
    override type unsing         = scala.Unit

    override  def asUnit: asUnit = self
    override type asUnit         = self

    override  def naturalOrdering: naturalOrdering = Ordering.alwaysEQ
    override type naturalOrdering                  = Ordering.alwaysEQ

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Unit]
}


private[sing]
object _TermOfUnit {
    val apply: Unit = new Unit{}
}
