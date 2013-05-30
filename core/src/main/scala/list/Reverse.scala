

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


private[sing]
object ReverseAppend {
     def apply[xs <: List, ys <: List](xs: xs, ys: ys): apply[xs, ys] =
        `if`(xs.isEmpty, const0(ys), Else(xs, ys)).apply.asList
    type apply[xs <: List, ys <: List] =
        `if`[xs#isEmpty, const0[ys], Else[xs, ys]]#apply#asList

    case class Else[xs <: List, ys <: List](xs: xs, ys: ys) extends Function0 {
        type self = Else[xs, ys]
        override  def apply: apply = ReverseAppend.apply(xs.tail, Cons(xs.head, ys))
        override type apply        = ReverseAppend.apply[xs#tail, Cons[xs#head, ys]]
    }
}
