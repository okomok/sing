

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


private[sing]
object Find {
     def apply[xs <: List, f <: Function1](xs: xs, f: f): apply[xs, f] = toOption(xs.dropWhile(Function1.not(f)))
    type apply[xs <: List, f <: Function1]                             = toOption[xs#dropWhile[Function1.not[f]]]

     def toOption[ys <: List](ys: ys): toOption[ys] =
        `if`(ys.isEmpty, const0(None), Else(ys)).apply.asOption//.asInstanceOf[toOption[ys]]
    type toOption[ys <: List] =
        `if`[ys#isEmpty, const0[None], Else[ys]]#apply#asOption

    case class Else[ys <: List](ys: ys) extends Function0 {
        type self = Else[ys]
        override  def apply: apply = Some(ys.head)
        override type apply        = Some[ys#head]
    }
}
