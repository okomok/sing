

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
final case class MakeCons[a <: Any](a: a) extends AsFunction1 {
    override type self = MakeCons[a]
    override  def apply[b <: Any](b: b): apply[b] = a :: b.asList
    override type apply[b <: Any]                 = a :: b#asList
}
