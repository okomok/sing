

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Nat extends AsKind {

    // You can't use macros
    //   whic, depend on Dense, which in turn, needs Nat.
    //   Then kindId can't be defined. (AbstractMethodError)
    override lazy val kindId: kindId = ???
    override     type kindId         = Nothing

    override lazy val naturalOrdering: naturalOrdering = new NaturalOrdering
    override     type naturalOrdering                  =     NaturalOrdering

    private[sing]
    final class NaturalOrdering extends AsOrdering {
        override type self = NaturalOrdering

        override  def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y] = x.asNat.equal(y.asNat)
        override type equiv[x <: Any, y <: Any]                          = x#asNat#equal[y#asNat]

        override  def compare[x <: Any, y <: Any](x: x, y: y): compare[x, y] =
            `if`(x.asNat.lt(y.asNat),
                Const(LT),
                `if`(x.asNat.gt(y.asNat),
                    Const(GT),
                    Const(EQ)
                )
            ).apply.asOrderingResult.asInstanceOf[compare[x, y]]
        override type compare[x <: Any, y <: Any] =
            `if`[x#asNat#lt[y#asNat],
                Const[LT],
                `if`[x#asNat#gt[y#asNat],
                    Const[GT],
                    Const[EQ]
                ]
            ]#apply#asOrderingResult
    }
}


/**
 * The sing natural number
 */
trait Nat extends Any {
    override type self <: Nat
    override type unsing = scala.Int

     def asDense: asDense
    type asDense <: Dense

     def asPeano: asPeano
    type asPeano <: Peano

    @Annotation.constantTime
     def isZero: isZero
    type isZero <: Boolean

    @Annotation.constantTime
     def increment: increment
    type increment <: Nat

    @Annotation.constantTime
     def decrement: decrement
    type decrement <: Nat

     def plus[that <: Nat](that: that): plus[that]
    type plus[that <: Nat] <: Nat

     def minus[that <: Nat](that: that): minus[that]
    type minus[that <: Nat] <: Nat

     def times[that <: Nat](that: that): times[that]
    type times[that <: Nat] <: Nat

     def quotRem[that <: Nat](that: that): quotRem[that]
    type quotRem[that <: Nat] <: Product2

     def exp[that <: Nat](that: that): exp[that]
    type exp[that <: Nat] <: Nat

     def lteq[that <: Nat](that: that): lteq[that]
    type lteq[that <: Nat] <: Boolean

     def lt[that <: Nat](that: that): lt[that]
    type lt[that <: Nat] <: Boolean

     def quot[that <: Nat](that: that): quot[that]
    type quot[that <: Nat] <: Nat

     def rem[that <: Nat](that: that): rem[that]
    type rem[that <: Nat] <: Nat

     def gt[that <: Nat](that: that): gt[that]
    type gt[that <: Nat] <: Boolean

     def gteq[that <: Nat](that: that): gteq[that]
    type gteq[that <: Nat] <: Boolean

     def bitAnd[that <: Nat](that: that): bitAnd[that]
    type bitAnd[that <: Nat] <: Nat

     def bitOr[that <: Nat](that: that): bitOr[that]
    type bitOr[that <: Nat] <: Nat
}
