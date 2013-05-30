

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package function


private[sing]
final class Const0[v <: Any](v: => v) extends Function0 {
    type self = Const0[v]

    @annotation.compilerWorkaround("2.9.0") // crashes in `override lazy val`.
    private[this] lazy val _apply: apply = v
    override  def apply: apply = _apply
    override type apply        = v
}
