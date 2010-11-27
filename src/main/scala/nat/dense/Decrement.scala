

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
object ConsDecrement {
     def apply[x <: Boolean, xs <: Dense](x: x, xs: xs): apply[x, xs] =
        `if`(xs.isZero, const0(xs), `if`(x, Then(x, xs), Else(x, xs))).apply.asNat.asDense.asInstanceOf[apply[x, xs]]
    type apply[x <: Boolean, xs <: Dense] =
        `if`[xs#isZero, const0[xs], `if`[x, Then[x, xs], Else[x, xs]]]#apply#asNat#asDense

    // (`true` :: xs).decrement
    case class Then[x <: Boolean, xs <: Dense](x: x, xs: xs) extends Function0 {
        type self = Then[x, xs]
        override  def apply: apply = Cons(`false`, xs)
        override type apply        = Cons[`false`, xs]
    }

    // (`false` :: xs).decrement
    case class Else[x <: Boolean, xs <: Dense](x: x, xs: xs) extends Function0 {
        type self = Else[x, xs]
        override  def apply: apply = Cons(`true`, xs.decrement)
        override type apply        = Cons[`true`, xs#decrement]
    }
}
