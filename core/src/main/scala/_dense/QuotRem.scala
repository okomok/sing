

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _dense


import Dense._1


private[sing]
object QuotRem {
     def apply[x <: Dense, y <: Dense](x: x, y: y): apply[x, y] =
        `if`(id(y).size.lt(id(x).size), Then(x, y), Else(x, y)).apply.asProduct2
    type apply[x <: Dense, y <: Dense] =
        `if`[id[y]#size#lt[id[x]#size], Then[x, y], Else[x, y]]#apply#asProduct2

    case class Then[x <: Dense, y <: Dense](x: x, y: y) extends AsFunction0 {
        override type self = Then[x, y]

        lazy val count2: count2 = x.size.minus(y.size)
            type count2         = x#size#minus[y#size]

        lazy val count1: count1 = count2.decrement
            type count1         = count2#decrement

        lazy val canMinus1: canMinus1 = y.shiftLeftBy(count1)
            type canMinus1            = y#shiftLeftBy[count1]

        lazy val canMinus2: canMinus2 = canMinus1.shiftLeft
            type canMinus2            = canMinus1#shiftLeft

        lazy val quot1: quot1 = _1.shiftLeftBy(count1)
            type quot1        = _1#shiftLeftBy[count1]

        lazy val quot2: quot2 = _1.shiftLeftBy(count2)
            type quot2        = _1#shiftLeftBy[count2]

        override  def apply: apply =
            `if`(canMinus2.lteq(x), Next(x, y, quot2, canMinus2), Next(x, y, quot1, canMinus1)).apply
        override type apply =
            `if`[canMinus2#lteq[x], Next[x, y, quot2, canMinus2], Next[x, y, quot1, canMinus1]]#apply
    }

    case class Next[x <: Dense, y <: Dense, quot <: Dense, canMinus <: Dense](x: x, y: y, quot: quot, canMinus: canMinus) extends AsFunction0 {
        override type self = Next[x, y, quot, canMinus]

        lazy val r: r = x.minus(canMinus).quotRem(y)
            type r    = x#minus[canMinus]#quotRem[y]

        override  def apply: apply = Tuple2(quot.plus(r._1.asNat), r._2)
        override type apply        = Tuple2[quot#plus[r#_1#asNat], r#_2]
    }

    case class Else[x <: Dense, y <: Dense](x: x, y: y) extends AsFunction0 {
        override type self = Else[x, y]
        override  def apply: apply = `if`(x.lt(y), Const(Tuple2(DNil, x)), ElseElse(x, y)).apply
        override type apply        = `if`[x#lt[y], Const[Tuple2[DNil, x]], ElseElse[x, y]]#apply
    }

    case class ElseElse[x <: Dense, y <: Dense](x: x, y: y) extends AsFunction0 {
        override type self = ElseElse[x, y]
        override  def apply: apply = Tuple2(_1, x.minus(y))
        override type apply        = Tuple2[_1, x#minus[y]]
    }
}


private[sing]
object DConsShiftLeftBy {
     def apply[x <: Dense, n <: Peano](x: x, n: n): apply[x, n] = n.foldRight(x, Step).asNat.asDense
    type apply[x <: Dense, n <: Peano]                          = n#foldRight[x, Step]#asNat#asDense

    val Step = new Step
    class Step extends AsFunction2 {
        override type self = Step
        override  def apply[a <: Any, b <: Any](a: a, b: b): apply[a, b] = DCons(`false`, b.asNat.asDense)
        override type apply[a <: Any, b <: Any]                          = DCons[`false`, b#asNat#asDense]
    }
}
