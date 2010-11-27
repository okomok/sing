

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


private[sing]
object Last {
     def apply[xs <: List](xs: xs) = `if`(xs.tail.isEmpty, const0(xs.head), Else(xs)).apply.asInstanceOf[apply[xs]]
    type apply[xs <: List]         = `if`[xs#tail#isEmpty, const0[xs#head], Else[xs]]#apply

    case class Else[xs <: List](xs: xs) extends Function0 {
        type self = Else[xs]
        override  def apply: apply = Last.apply(xs.tail).asInstanceOf[apply]
        override type apply        = Last.apply[xs#tail]
    }
}
