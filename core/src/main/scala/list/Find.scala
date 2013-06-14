

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object Find {
     def apply[xs <: List, f <: Function1](xs: xs, f: f): apply[xs, f] = toOption(xs.dropWhile(f.not))
    type apply[xs <: List, f <: Function1]                             = toOption[xs#dropWhile[f#not]]

     def toOption[ys <: List](ys: ys): toOption[ys] =
        `if`(ys.isEmpty, Const(None), Else(ys)).apply.asOption
    type toOption[ys <: List] =
        `if`[ys#isEmpty, Const[None], Else[ys]]#apply#asOption

    case class Else[ys <: List](ys: ys) extends AsFunction0 {
        override type self = Else[ys]
        override  def apply: apply = Some(ys.head)
        override type apply        = Some[ys#head]
    }
}
