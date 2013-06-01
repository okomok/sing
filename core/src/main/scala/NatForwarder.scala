

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat


trait Forwarder extends Nat with sing.Forwarder {
    override protected type delegate <: Nat

    final override  def asDense: asDense = delegate.asDense
    final override type asDense          = delegate#asDense

    final override  def asPeano: asPeano = delegate.asPeano
    final override type asPeano          = delegate#asPeano

    final override  def isZero: isZero = delegate.isZero
    final override type isZero         = delegate#isZero

    final override  def increment: increment = delegate.increment
    final override type increment           = delegate#increment

    final override  def decrement: decrement = delegate.decrement
    final override type decrement            = delegate#decrement

    final override  def plus[that <: Nat](that: that): plus[that] = delegate.plus(that)
    final override type plus[that <: Nat]                         = delegate#plus[that]

    final override  def minus[that <: Nat](that: that): minus[that] = delegate.minus(that)
    final override type minus[that <: Nat]                          = delegate#minus[that]

    final override  def times[that <: Nat](that: that): times[that] = delegate.times(that)
    final override type times[that <: Nat]                          = delegate#times[that]

    final override  def quotRem[that <: Nat](that: that): quotRem[that] = delegate.quotRem(that)
    final override type quotRem[that <: Nat]                            = delegate#quotRem[that]

    final override  def exp[that <: Nat](that: that): exp[that] = delegate.exp(that)
    final override type exp[that <: Nat]                        = delegate#exp[that]

    final override  def equal[that <: Nat](that: that): equal[that] = delegate.equal(that)
    final override type equal[that <: Nat]                          = delegate#equal[that]

    final override  def nequal[that <: Nat](that: that): nequal[that] = delegate.nequal(that)
    final override type nequal[that <: Nat]                           = delegate#nequal[that]

    final override  def lteq[that <: Nat](that: that): lteq[that] = delegate.lteq(that)
    final override type lteq[that <: Nat]                         = delegate#lteq[that]

    final override  def lt[that <: Nat](that: that): lt[that] = delegate.lt(that)
    final override type lt[that <: Nat]                       = delegate#lt[that]

    final override  def quot[that <: Nat](that: that): quot[that] = delegate.quot(that)
    final override type quot[that <: Nat]                         = delegate#quot[that]

    final override  def rem[that <: Nat](that: that): rem[that] = delegate.rem(that)
    final override type rem[that <: Nat]                        = delegate#rem[that]

    final override  def gt[that <: Nat](that: that): gt[that] = delegate.gt(that)
    final override type gt[that <: Nat]                       = delegate#gt[that]

    final override  def gteq[that <: Nat](that: that): gteq[that] = delegate.gteq(that)
    final override type gteq[that <: Nat]                         = delegate#gteq[that]

    final override  def bitAnd[that <: Nat](that: that): bitAnd[that] = delegate.bitAnd(that)
    final override type bitAnd[that <: Nat]                           = delegate#bitAnd[that]

    final override  def bitOr[that <: Nat](that: that): bitOr[that] = delegate.bitOr(that)
    final override type bitOr[that <: Nat]                          = delegate#bitOr[that]
}
