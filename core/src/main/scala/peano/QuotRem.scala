

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peano


private[sing]
object QuotRem {
     def apply[x <: Nat, y <: Nat](x: x, y: y): apply[x, y] =
        `if`(x.lt(y), const0(Tuple2(Zero, x)), Else(x, y)).apply.asProduct2
    type apply[x <: Nat, y <: Nat] =
        `if`[x#lt[y], const0[Tuple2[Zero, x]], Else[x, y]]#apply#asProduct2

    case class Else[x <: Nat, y <: Nat](x: x, y: y) extends Function0 {
        type self = Else[x, y]
        private[this] lazy val r: r = x.minus(y).quotRem(y)
        private[this]     type r    = x#minus[y]#quotRem[y]
        override  def apply: apply = Tuple2(r._1.asNat.increment, r._2)
        override type apply        = Tuple2[r#_1#asNat#increment, r#_2]
    }
}
