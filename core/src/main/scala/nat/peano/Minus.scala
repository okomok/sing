

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat; package peano


private[sing]
object Minus {
     def apply[x <: Peano, y <: Peano](x: x, y: y): apply[x, y] = y.foldRight(x, Step).asNat.asPeano
    type apply[x <: Peano, y <: Peano]                          = y#foldRight[x, Step]#asNat#asPeano

    val Step = new Step
    class Step extends Function2 {
        type self = Step
        override  def apply[a <: Any, b <: Any](a: a, b: b): apply[a, b] = b.asNat.asPeano.decrement
        override type apply[a <: Any, b <: Any]                          = b#asNat#asPeano#decrement
    }
}
