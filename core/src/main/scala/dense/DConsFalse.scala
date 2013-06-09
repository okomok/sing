

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package dense


private[sing]
object DConsFalse {
     def apply[xs <: Dense](xs: xs): apply[xs] = `if`(xs.isZero, Const(xs), Else(xs)).apply
    type apply[xs <: Dense]                    = `if`[xs#isZero, Const[xs], Else[xs]]#apply

    case class Else[xs <: Dense](xs: xs) extends AsFunction0 {
        override type self = Else[xs]
        override  def apply: apply = DCons(`false`, xs)
        override type apply        = DCons[`false`, xs]
    }
}
