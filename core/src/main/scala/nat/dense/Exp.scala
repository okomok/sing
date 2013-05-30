

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
object ConsExp {
     def apply[x <: Dense, n <: Nat](x: x, n: n): apply[x, n] = n.asNat.asPeano.foldRight(_1, Step(x)).asNat.asDense
    type apply[x <: Dense, n <: Nat]                          = n#asNat#asPeano#foldRight[_1, Step[x]]#asNat#asDense

    case class Step[x <: Dense](x: x) extends Function2 {
        type self = Step[x]
        override  def apply[a <: Any, b <: Any](a: a, b: b): apply[a, b] = x.times(b.asNat.asDense)
        override type apply[a <: Any, b <: Any]                          = x#times[b#asNat#asDense]
    }
}
