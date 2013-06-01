

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
object Matches {
     def apply[p <: Peg, xs <: List](p: p, xs: xs): apply[p, xs] = _aux(p.parse(xs))
    type apply[p <: Peg, xs <: List]                             = _aux[p#parse[xs]]

    private[this]  def _aux[r <: PegResult](r: r): _aux[r] =
        `if`(r.successful, Then(r), const0(`false`)).apply.asBoolean
    private[this] type _aux[r <: PegResult] =
        `if`[r#successful, Then[r], const0[`false`]]#apply#asBoolean

    final case class Then[r <: PegResult](r: r) extends Function0 {
        type self = Then[r]
        override  def apply: apply = r.next.isEmpty
        override type apply        = r#next#isEmpty
    }
}
