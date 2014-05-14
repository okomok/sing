

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _dense


private[sing]
object DConsTimes {
     def apply[x <: Boolean, xs <: Dense, ys <: Dense](x: x, xs: xs, ys: ys): apply[x, xs, ys] =
        `if`(x, Then(x, xs, ys), Else(x, xs, ys)).apply.asNat.asDense
    type apply[x <: Boolean, xs <: Dense, ys <: Dense] =
        `if`[x, Then[x, xs, ys], Else[x, xs, ys]]#apply#asNat#asDense

    case class Then[x <: Boolean, xs <: Dense, ys <: Dense](x: x, xs: xs, ys: ys) extends AsFunction0 {
        override type self = Then[x, xs, ys]
        override  def apply: apply = ys.plus(xs.times(ys).shiftLeft)
        override type apply        = ys#plus[xs.times[ys]#shiftLeft]
    }

    case class Else[x <: Boolean, xs <: Dense, ys <: Dense](x: x, xs: xs, ys: ys) extends AsFunction0 {
        override type self = Else[x, xs, ys]
        override  def apply: apply = xs.times(ys).shiftLeft
        override type apply        = xs#times[ys]#shiftLeft
    }
}
