

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object FoldLeft {
     def apply[xs <: List, z <: Any, f <: Function2](xs: xs, z: z, f: f): apply[xs, z, f] =
        `if`(xs.isEmpty, const0(z), Else(xs, z, f)).apply
    type apply[xs <: List, z <: Any, f <: Function2] =
        `if`[xs#isEmpty, const0[z], Else[xs, z, f]]#apply

    case class Else[xs <: List, z <: Any, f <: Function2](xs: xs, z: z, f: f) extends AsFunction0 {
        override type self = Else[xs, z, f]
        override  def apply: apply = FoldLeft.apply(xs.tail, f.apply(z, xs.head), f).asInstanceOf[apply]
        override type apply        = FoldLeft.apply[xs#tail, f#apply[z, xs#head], f]
    }
}


private[sing]
object FoldRight {
     def apply[xs <: List, z <: Any, f <: Function2](xs: xs, z: z, f: f): apply[xs, z, f] =
        `if`(xs.isEmpty, const0(z), Else(xs, z, f)).apply
    type apply[xs <: List, z <: Any, f <: Function2] =
        `if`[xs#isEmpty, const0[z], Else[xs, z, f]]#apply

    case class Else[xs <: List, z <: Any, f <: Function2](xs: xs, z: z, f: f) extends AsFunction0 {
        override type self = Else[xs, z, f]
        override  def apply: apply = f.apply(xs.head, FoldRight.apply(xs.tail, z, f)).asInstanceOf[apply]
        override type apply        = f#apply[xs#head, FoldRight.apply[xs#tail, z, f]]
    }
}
