

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsNat extends Nat with AsAny with UnsingEquals with AsNatKind {
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

    override  def canEqual(that: scala.Any) = that.isInstanceOf[Nat]
}
