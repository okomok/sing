

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object HasTwoOrMore {
     def apply[xs <: List](xs: xs): apply[xs] =
        `if`(xs.isEmpty, const0(`false`), Else(xs)).apply.asBoolean
    type apply[xs <: List] =
        `if`[xs#isEmpty, const0[`false`], Else[xs]]#apply#asBoolean

    case class Else[xs <: List](xs: xs) extends Function0 {
        type self = Else[xs]
        override  def apply: apply = `if`(xs.tail.isEmpty, const0(`false`), const0(`true`)).apply
        override type apply        = `if`[xs#tail#isEmpty, const0[`false`], const0[`true`]]#apply
    }
}
