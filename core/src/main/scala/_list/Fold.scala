

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _list


private[sing]
object FoldLeft {
     def apply[xs <: List, z <: Any, f <: Function2](xs: xs, z: z, f: f): apply[xs, z, f] =
        `if`(xs.isEmpty, Const(z), Else(xs, z, f)).apply
    type apply[xs <: List, z <: Any, f <: Function2] =
        `if`[xs#isEmpty, Const[z], Else[xs, z, f]]#apply

    case class Else[xs <: List, z <: Any, f <: Function2](xs: xs, z: z, f: f) extends AsFunction0 {
        override type self = Else[xs, z, f]
        override  def apply: apply = FoldLeft.apply(xs.tail, f.apply(z, xs.head), f)
        override type apply        = FoldLeft.apply[xs#tail, f#apply[z, xs#head], f]
    }
}


private[sing]
object FoldRight {
     def apply[xs <: List, z <: Any, f <: Function2](xs: xs, z: z, f: f): apply[xs, z, f] =
        `if`(xs.isEmpty, Const(z), Else(xs, z, f)).apply
    type apply[xs <: List, z <: Any, f <: Function2] =
        `if`[xs#isEmpty, Const[z], Else[xs, z, f]]#apply

    case class Else[xs <: List, z <: Any, f <: Function2](xs: xs, z: z, f: f) extends AsFunction0 {
        override type self = Else[xs, z, f]
        override  def apply: apply = f.apply(xs.head, FoldRight.apply(xs.tail, z, f))
        override type apply        = f#apply[xs#head, FoldRight.apply[xs#tail, z, f]]
    }
}
