

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import ordering._


sealed abstract class OrderingResult extends Any {
    type self <: OrderingResult
    type unsing = scala.Int

     def equal[that <: OrderingResult](that: that): equal[that]
    type equal[that <: OrderingResult] <: Boolean

     def nequal[that <: OrderingResult](that: that): nequal[that]
    type nequal[that <: OrderingResult] <: Boolean

     def isLT: isLT
    type isLT <: Boolean
     def isGT: isGT
    type isGT <: Boolean
     def isEQ: isEQ
    type isEQ <: Boolean

     def isLTEQ: isLTEQ
    type isLTEQ <: Boolean
     def isGTEQ: isGTEQ
    type isGTEQ <: Boolean
}


private[sing]
sealed abstract class AbstractOrderingResult extends OrderingResult {
    final override  def asOrderingResult: asOrderingResult = self
    final override type asOrderingResult                   = self

    final override  def nequal[that <: OrderingResult](that: that): nequal[that] = equal(that).not
    final override type nequal[that <: OrderingResult]                           = equal[that]#not

    final override  def isLTEQ: isLTEQ = isLT.or(isEQ)
    final override type isLTEQ         = isLT#or[isEQ]
    final override  def isGTEQ: isGTEQ = isGT.or(isEQ)
    final override type isGTEQ         = isGT#or[isEQ]

    final override def canEqual(that: scala.Any) = that.isInstanceOf[OrderingResult]
}


sealed abstract class LT extends AbstractOrderingResult {
    type self = LT

    override  def unsing: unsing = -1

    override  def equal[that <: OrderingResult](that: that): equal[that] = that.isLT
    override type equal[that <: OrderingResult]                          = that#isLT

    override  def isLT: isLT = `true`
    override type isLT       = `true`
    override  def isGT: isGT = `false`
    override type isGT       = `false`
    override  def isEQ: isEQ = `false`
    override type isEQ       = `false`
}

sealed abstract class GT extends AbstractOrderingResult {
    type self = GT

    override  def unsing: unsing = 1

    override  def equal[that <: OrderingResult](that: that): equal[that] = that.isGT
    override type equal[that <: OrderingResult]                          = that#isGT

    override  def isLT: isLT = `false`
    override type isLT       = `false`
    override  def isGT: isGT = `true`
    override type isGT       = `true`
    override  def isEQ: isEQ = `false`
    override type isEQ       = `false`
}

sealed abstract class EQ extends AbstractOrderingResult {
    type self = EQ

    override  def unsing: unsing = 0

    override  def equal[that <: OrderingResult](that: that): equal[that] = that.isEQ
    override type equal[that <: OrderingResult]                          = that#isEQ

    override  def isLT: isLT = `false`
    override type isLT       = `false`
    override  def isGT: isGT = `false`
    override type isGT       = `false`
    override  def isEQ: isEQ = `true`
    override type isEQ       = `true`
}


private[sing]
object _OrderingResult {
    val LT: LT = new LT{}
    val GT: GT = new GT{}
    val EQ: EQ = new EQ{}
}

