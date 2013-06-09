

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


final case class Const[v <: Any](v: v) extends AsFunction0 {
    override type self = Const[v]

    @Annotation.compilerWorkaround("2.9.0") // crashes in `override lazy val`.
    private[this] lazy val _apply: apply = v
    override  def apply: apply = _apply
    override type apply        = v
}
