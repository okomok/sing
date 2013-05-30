

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
object ConsIncrement {
     def apply[x <: Boolean, xs <: Dense](x: x, xs: xs): apply[x, xs] =
        `if`(x, Then(x, xs), Else(x, xs)).apply.asNat.asDense
    type apply[x <: Boolean, xs <: Dense] =
        `if`[x, Then[x, xs], Else[x, xs]]#apply#asNat#asDense

    // (`true` :: xs).increment
    case class Then[x <: Boolean, xs <: Dense](x: x, xs: xs) extends Function0 {
        type self = Then[x, xs]
        override  def apply: apply = Cons(`false`, xs.increment)
        override type apply        = Cons[`false`, xs#increment]
    }

    // (`false` :: xs).increment
    case class Else[x <: Boolean, xs <: Dense](x: x, xs: xs) extends Function0 {
        type self = Else[x, xs]
        override  def apply: apply = Cons(`true`, xs)
        override type apply        = Cons[`true`, xs]
    }
}
