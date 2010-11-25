

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package nat; package peano


private[sing]
object SuccEq {
     def apply[x <: Peano, y <: Peano](x: x, y: y): apply[x, y] =
        `if`(y.isZero, const0(`false`), Else(x, y)).apply.asBoolean
    type apply[x <: Peano, y <: Peano] =
        `if`[y#isZero, const0[`false`], Else[x, y]]#apply#asBoolean

    case class Else[x <: Peano, y <: Peano](x: x, y: y) extends Function0 {
         type self = Else[x, y]
         override  def apply: apply = x.decrement.equal(y.decrement)
         override type apply        = x#decrement#equal[y#decrement]
     }
}

private[sing]
object SuccLtEq {
     def apply[x <: Peano, y <: Peano](x: x, y: y): apply[x, y] =
        `if`(y.isZero, const0(`false`), Else(x, y)).apply.asBoolean
    type apply[x <: Peano, y <: Peano] =
        `if`[y#isZero, const0[`false`], Else[x, y]]#apply#asBoolean

    case class Else[x <: Peano, y <: Peano](x: x, y: y) extends Function0 {
         type self = Else[x, y]
         override  def apply: apply = x.decrement.lteq(y.decrement)
         override type apply        = x#decrement#lteq[y#decrement]
     }
}
