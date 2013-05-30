

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat


private[sing]
trait AbstractNat extends Nat {
    final override  def asNat: asNat = self
    final override type asNat        = self

    final override  def nequal[that <: Nat](that: that): nequal[that] = equal(that).not
    final override type nequal[that <: Nat]                           = equal[that]#not

    final override  def quot[that <: Nat](that: that): quot[that] = quotRem(that)._1.asNat
    final override type quot[that <: Nat]                         = quotRem[that]#_1#asNat

    final override  def rem[that <: Nat](that: that): rem[that] = quotRem(that)._2.asNat
    final override type rem[that <: Nat]                        = quotRem[that]#_2#asNat

    final override  def gt[that <: Nat](that: that): gt[that] = that.lt(self)
    final override type gt[that <: Nat]                       = that#lt[self]

    final override  def gteq[that <: Nat](that: that): gteq[that] = that.lteq(self)
    final override type gteq[that <: Nat]                         = that#lteq[self]

    final override  def naturalOrdering: naturalOrdering = nat.naturalOrdering
    final override type naturalOrdering                  = nat.naturalOrdering

    final override  def canEqual(that: scala.Any) = that.isInstanceOf[Nat]
}
