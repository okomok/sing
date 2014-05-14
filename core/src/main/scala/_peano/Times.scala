

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _peano


private[sing]
object Times {
    // fold in y, for `**` is left-associative.
     def apply[x <: Peano, y <: Peano](x: x, y: y): apply[x, y] = y.foldRight(Zero, Step(x)).asNat.asPeano
    type apply[x <: Peano, y <: Peano]                          = y#foldRight[Zero, Step[x]]#asNat#asPeano

    case class Step[x <: Peano](x: x) extends AsFunction2 {
        override type self = Step[x]
        override  def apply[a <: Any, b <: Any](a: a, b: b): apply[a, b] = x.plus(b.asNat.asPeano)
        override type apply[a <: Any, b <: Any]                          = x#plus[b#asNat#asPeano]
    }
}
