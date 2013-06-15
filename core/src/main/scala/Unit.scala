

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object _Unit_ extends AsKind {
    override  def kindId: kindId = KindId.ofUnit
    override type kindId         = KindId.ofUnit

    override  def naturalOrdering: naturalOrdering = AlwaysEQ
    override type naturalOrdering                  = AlwaysEQ
}


sealed abstract class Unit extends AnyImpl {
    override  def kind: kind = _Unit_
    override type kind       = _Unit_.type

    override type self = Unit

    override  def unsing: unsing = ()
    override type unsing         = scala.Unit

    override  def asUnit: asUnit = self
    override type asUnit         = self

    override  def equal[that <: Any](that: that): equal[that] = `true`
    override type equal[that <: Any]                          = `true`

    override def canEqual(that: scala.Any) = that.isInstanceOf[Unit]
}


private[sing]
object _TermOfUnit {
    val apply: Unit = new Unit{}
}
