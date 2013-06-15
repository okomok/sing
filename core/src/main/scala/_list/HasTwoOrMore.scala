

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _list


private[sing]
object HasTwoOrMore {
     def apply[xs <: List](xs: xs): apply[xs] =
        `if`(xs.isEmpty, Const(`false`), Else(xs)).apply.asBoolean
    type apply[xs <: List] =
        `if`[xs#isEmpty, Const[`false`], Else[xs]]#apply#asBoolean

    case class Else[xs <: List](xs: xs) extends AsFunction0 {
        override type self = Else[xs]
        override  def apply: apply = `if`(xs.tail.isEmpty, Const(`false`), Const(`true`)).apply
        override type apply        = `if`[xs#tail#isEmpty, Const[`false`], Const[`true`]]#apply
    }
}