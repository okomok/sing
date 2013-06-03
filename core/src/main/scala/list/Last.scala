

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object Last {
     def apply[xs <: List](xs: xs) = `if`(xs.tail.isEmpty, const0(xs.head), Else(xs)).apply.asInstanceOf[apply[xs]]
    type apply[xs <: List]         = `if`[xs#tail#isEmpty, const0[xs#head], Else[xs]]#apply

    case class Else[xs <: List](xs: xs) extends AsFunction0 {
        override type self = Else[xs]
        override  def apply: apply = Last.apply(xs.tail).asInstanceOf[apply]
        override type apply        = Last.apply[xs#tail]
    }
}
