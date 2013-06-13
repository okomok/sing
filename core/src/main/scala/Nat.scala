

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Nat extends AsKind {
    import NatImpl._

    override lazy val naturalOrdering: naturalOrdering = new NaturalOrdering
    override     type naturalOrdering                  =     NaturalOrdering
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


trait AsNat extends NatImpl {
    override  def kind: kind = Nat
    override type kind       = Nat.type
}


trait NatImpl extends Nat with AnyImpl with UnsingEquals {
    override  def asNat: asNat = self
    override type asNat        = self

    override  def quot[that <: Nat](that: that): quot[that] = quotRem(that)._1.asNat
    override type quot[that <: Nat]                         = quotRem[that]#_1#asNat

    override  def rem[that <: Nat](that: that): rem[that] = quotRem(that)._2.asNat
    override type rem[that <: Nat]                        = quotRem[that]#_2#asNat

    override  def gt[that <: Nat](that: that): gt[that] = that.lt(self)
    override type gt[that <: Nat]                       = that#lt[self]

    override  def gteq[that <: Nat](that: that): gteq[that] = that.lteq(self)
    override type gteq[that <: Nat]                         = that#lteq[self]

    override def canEqual(that: scala.Any) = that.isInstanceOf[Nat]
}


private[sing]
object NatImpl {
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
