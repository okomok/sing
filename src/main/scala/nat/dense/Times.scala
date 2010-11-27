

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
object ConsTimes {
     def apply[x <: Boolean, xs <: Dense, ys <: Dense](x: x, xs: xs, ys: ys): apply[x, xs, ys] =
        `if`(x, Then(x, xs, ys), Else(x, xs, ys)).apply.asNat.asDense
    type apply[x <: Boolean, xs <: Dense, ys <: Dense] =
        `if`[x, Then[x, xs, ys], Else[x, xs, ys]]#apply#asNat#asDense

    case class Then[x <: Boolean, xs <: Dense, ys <: Dense](x: x, xs: xs, ys: ys) extends Function0 {
        type self = Then[x, xs, ys]
        override  def apply: apply = ys.plus(xs.times(ys).shiftLeft).asInstanceOf[apply]
        override type apply        = ys#plus[xs.times[ys]#shiftLeft]
    }

    case class Else[x <: Boolean, xs <: Dense, ys <: Dense](x: x, xs: xs, ys: ys) extends Function0 {
        type self = Else[x, xs, ys]
        override  def apply: apply = xs.times(ys).shiftLeft
        override type apply        = xs#times[ys]#shiftLeft
    }
}
