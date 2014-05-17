

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


// See: Nats.scala
//      at http://www.assembla.com/wiki/show/metascala


import _peano._


object Peano extends Literal


sealed trait Peano extends Nat {
    override type self <: Peano

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
sealed abstract class AsPeano extends Peano with AsNat {
    override  def asDense: asDense = AsDense.apply(self)
    override type asDense          = AsDense.apply[self]

    override  def asPeano: asPeano = self
    override type asPeano          = self

    override  def increment: increment = Succ(self)
    override type increment            = Succ[self]

    override  def plus[that <: Nat](that: that): plus[that] = Plus.apply(self, that.asPeano)
    override type plus[that <: Nat]                         = Plus.apply[self, that#asPeano]

    override  def minus[that <: Nat](that: that): minus[that] = Minus.apply(self, that.asPeano)
    override type minus[that <: Nat]                          = Minus.apply[self, that#asPeano]

    override  def times[that <: Nat](that: that): times[that] = Times.apply(self, that.asPeano)
    override type times[that <: Nat]                          = Times.apply[self, that#asPeano]

    override  def quotRem[that <: Nat](that: that): quotRem[that] = QuotRem.apply(self, that.asPeano)
    override type quotRem[that <: Nat]                            = QuotRem.apply[self, that#asPeano]

    override  def exp[that <: Nat](that: that): exp[that] = asDense.exp(that).asPeano
    override type exp[that <: Nat]                        = asDense#exp[that]#asPeano

    override  def lt[that <: Nat](that: that): lt[that] = that.asPeano.lteq(self).not
    override type lt[that <: Nat]                       = that#asPeano#lteq[self]#not

    override  def bitAnd[that <: Nat](that: that): bitAnd[that] = asDense.bitAnd(that).asPeano
    override type bitAnd[that <: Nat]                           = asDense#bitAnd[that]#asPeano

    override  def bitOr[that <: Nat](that: that): bitOr[that] = asDense.bitOr(that).asPeano
    override type bitOr[that <: Nat]                          = asDense#bitOr[that]#asPeano

    override  def isOdd: isOdd = isEven.not
    override type isOdd        = isEven#not
}


sealed trait Zero extends AsPeano {
    override type self = Zero

    override  def isZero: isZero = `true`
    override type isZero         = `true`

    private[sing] lazy val _decrement = Unsupported("Zero.decrement")
    override  def decrement: decrement = _decrement.unwrap
    override type decrement            = _decrement.unwrap

    override  def equal[that <: Any](that: that): equal[that] = that.asNat.isZero
    override type equal[that <: Any]                          = that#asNat#isZero

    override  def lteq[that <: Nat](that: that): lteq[that] = `true`
    override type lteq[that <: Nat]                         = `true`

    override  def foldRight[z <: Any, f <: Function2](z: z, f: f): foldRight[z, f] = z
    override type foldRight[z <: Any, f <: Function2]                              = z

    override  def isEven: isEven = `true`
    override type isEven         = `true`

    override def unsing: unsing = 0
}

private[sing]
object _TermOfZero {
    val apply: Zero = new Zero{}
}


final case class Succ[n <: Peano](override val decrement: n) extends AsPeano {
    override type self = Succ[n]

    override  def isZero: isZero = `false`
    override type isZero         = `false`

    override type decrement = n

    override  def equal[that <: Any](that: that): equal[that] = SuccEq.apply(self, that.asNat.asPeano)
    override type equal[that <: Any]                          = SuccEq.apply[self, that#asNat#asPeano]

    override  def lteq[that <: Nat](that: that): lteq[that] = SuccLtEq.apply(self, that.asPeano)
    override type lteq[that <: Nat]                         = SuccLtEq.apply[self, that#asPeano]

    override  def foldRight[z <: Any, f <: Function2](z: z, f: f): foldRight[z, f] = f.apply(self, decrement.foldRight(z, f))
    override type foldRight[z <: Any, f <: Function2]                              = f#apply[self, decrement#foldRight[z, f]]

    @Annotation.compilerWorkaround("2.9.0") // crashes in `override lazy val`.
    private[this] lazy val _isEven: isEven = decrement.isEven.not
    override  def isEven: isEven = _isEven
    override type isEven         = decrement#isEven#not

    override def unsing: unsing = 1 + decrement.unsing
}
