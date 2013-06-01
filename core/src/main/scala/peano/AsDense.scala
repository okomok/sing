

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peano


import Peano._2


private[sing]
object AsDense {
     def apply[x <: Peano](x: x): apply[x] = `if`(x.isZero, const0(DNil), Else(x)).apply.asNat.asDense
    type apply[x <: Peano]                 = `if`[x#isZero, const0[DNil], Else[x]]#apply#asNat#asDense

    case class Else[x <: Peano](x: x) extends Function0 {
         type self = Else[x]
         override  def apply: apply = DCons(x.isOdd, Div2.apply(x).asNat.asDense) // `ConsFalse` is redundant.
         override type apply        = DCons[x#isOdd, Div2.apply[x]#asNat#asDense]
     }
}


private[sing]
object Div2 {
     def apply[x <: Peano](x: x): apply[x] = `if`(x.lt(_2), const0(Zero), Else(x)).apply.asNat.asPeano
    type apply[x <: Peano]                 = `if`[x#lt[_2], const0[Zero], Else[x]]#apply#asNat#asPeano

    case class Else[x <: Peano](x: x) extends Function0 {
        type self = Else[x]
        override  def apply: apply = Div2.apply(x.decrement.decrement).increment.asInstanceOf[apply]
        override type apply        = Div2.apply[x#decrement#decrement]#increment
    }
}
