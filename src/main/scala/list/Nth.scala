

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


private[sing]
object Nth {
     def apply[xs <: List, n <: Nat](xs: xs, n: n) =
        `if`(n.isZero, const0(xs.head), Else(xs, n)).apply.asInstanceOf[apply[xs, n]]
    type apply[xs <: List, n <: Nat] =
        `if`[n#isZero, const0[xs#head], Else[xs, n]]#apply

    case class Else[xs <: List, n <: Nat](xs: xs, n: n) extends Function0 {
        type self = Else[xs, n]
        override  def apply: apply = Nth.apply(xs.tail, n.decrement).asInstanceOf[apply]
        override type apply        = Nth.apply[xs#tail, n#decrement]
    }
}
