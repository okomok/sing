

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _peano


import Peano._2


private[sing]
object AsDense {
     def apply[x <: Peano](x: x): apply[x] = `if`(x.isZero, Const(DNil), Else(x)).apply.asNat.asDense
    type apply[x <: Peano]                 = `if`[x#isZero, Const[DNil], Else[x]]#apply#asNat#asDense

    case class Else[x <: Peano](x: x) extends AsFunction0 {
         override type self = Else[x]
         override  def apply: apply = DCons(x.isOdd, Div2.apply(x).asNat.asDense) // `ConsFalse` is redundant.
         override type apply        = DCons[x#isOdd, Div2.apply[x]#asNat#asDense]
     }
}


private[sing]
object Div2 {
     def apply[x <: Peano](x: x): apply[x] = `if`(x.lt(_2), Const(Zero), Else(x)).apply.asNat.asPeano
    type apply[x <: Peano]                 = `if`[x#lt[_2], Const[Zero], Else[x]]#apply#asNat#asPeano

    case class Else[x <: Peano](x: x) extends AsFunction0 {
        override type self = Else[x]
        override  def apply: apply = Div2.apply(id(x).decrement.decrement).increment
        override type apply        = Div2.apply[id[x]#decrement#decrement]#increment
    }
}
