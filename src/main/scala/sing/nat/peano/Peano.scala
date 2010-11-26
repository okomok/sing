

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package nat; package peano


// See: Nats.scala
//      at http://www.assembla.com/wiki/show/metascala


object Peano extends Common


sealed trait Peano extends AbstractNat {
    type self <: Peano

    override type increment <: Peano
    override type decrement <: Peano
    override type plus[that <: Nat] <: Peano
    override type minus[that <: Nat] <: Peano
    override type times[that <: Nat] <: Peano
    override type exp[that <: Nat] <: Peano
    override type bitAnd[that <: Nat] <: Peano
    override type bitOr[that <: Nat] <: Peano

     def foldRight[z <: Any, f <: Function2](z: z, f: f): foldRight[z, f]
    type foldRight[z <: Any, f <: Function2] <: Any

     def isEven: isEven
    type isEven <: Boolean

     def isOdd: isOdd
    type isOdd <: Boolean
}


private[sing]
sealed abstract class AbstractPeano extends Peano {
    final override  def asDense: asDense = AsDense.apply(self)
    final override type asDense          = AsDense.apply[self]

    final override  def asPeano: asPeano = self
    final override type asPeano          = self

    final override  def increment: increment = Succ(self)
    final override type increment            = Succ[self]

    final override  def plus[that <: Nat](that: that): plus[that] = Plus.apply(self, that.asPeano)
    final override type plus[that <: Nat]                         = Plus.apply[self, that#asPeano]

    final override  def minus[that <: Nat](that: that): minus[that] = Minus.apply(self, that.asPeano)
    final override type minus[that <: Nat]                          = Minus.apply[self, that#asPeano]

    final override  def times[that <: Nat](that: that): times[that] = Times.apply(self, that.asPeano)
    final override type times[that <: Nat]                          = Times.apply[self, that#asPeano]

    final override  def quotRem[that <: Nat](that: that): quotRem[that] = QuotRem.apply(self, that.asPeano).asInstanceOf[quotRem[that]]
    final override type quotRem[that <: Nat]                            = QuotRem.apply[self, that#asPeano]

    final override  def exp[that <: Nat](that: that): exp[that] = asDense.exp(that).asPeano
    final override type exp[that <: Nat]                        = asDense#exp[that]#asPeano

    final override  def lt[that <: Nat](that: that): lt[that] = that.asPeano.lteq(self).not
    final override type lt[that <: Nat]                       = that#asPeano#lteq[self]#not

    final override  def bitAnd[that <: Nat](that: that): bitAnd[that] = asDense.bitAnd(that).asPeano
    final override type bitAnd[that <: Nat]                           = asDense#bitAnd[that]#asPeano

    final override  def bitOr[that <: Nat](that: that): bitOr[that] = asDense.bitOr(that).asPeano
    final override type bitOr[that <: Nat]                          = asDense#bitOr[that]#asPeano

    final override  def isOdd: isOdd = isEven.not
    final override type isOdd        = isEven#not
}


sealed trait Zero extends AbstractPeano {
    type self = Zero

    override  def isZero: isZero = `true`
    override type isZero         = `true`

    override  def decrement: decrement = unsupported("nat.peano.Zero.decrement")
    override type decrement            = unsupported[_]

    override  def equal[that <: Nat](that: that): equal[that] = that.isZero
    override type equal[that <: Nat]                          = that#isZero

    override  def lteq[that <: Nat](that: that): lteq[that] = `true`
    override type lteq[that <: Nat]                         = `true`

    override  def foldRight[z <: Any, f <: Function2](z: z, f: f): foldRight[z, f] = z
    override type foldRight[z <: Any, f <: Function2]                              = z

    override  def isEven: isEven = `true`
    override type isEven         = `true`

    override def unsing: unsing = 0
}


final case class Succ[n <: Peano](override val decrement: n) extends AbstractPeano {
    type self = Succ[n]

    override  def isZero: isZero = `false`
    override type isZero         = `false`

    override type decrement = n

    override  def equal[that <: Nat](that: that): equal[that] = SuccEq.apply(self, that.asPeano)
    override type equal[that <: Nat]                          = SuccEq.apply[self, that#asPeano]

    override  def lteq[that <: Nat](that: that): lteq[that] = SuccLtEq.apply(self, that.asPeano)
    override type lteq[that <: Nat]                         = SuccLtEq.apply[self, that#asPeano]

    override  def foldRight[z <: Any, f <: Function2](z: z, f: f): foldRight[z, f] = f.apply(self, decrement.foldRight(z, f))
    override type foldRight[z <: Any, f <: Function2]                              = f#apply[self, decrement#foldRight[z, f]]

    override lazy val isEven: isEven = decrement.isEven.not
    override     type isEven         = decrement#isEven#not

    override def unsing: unsing = 1 + decrement.unsing
}


private[sing]
object _Peano {
    val Zero = new Zero{}
}
