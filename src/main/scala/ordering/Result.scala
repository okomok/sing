

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package ordering


sealed abstract class Result extends Any {
    type self <: Result
    type unsing = scala.Int

     def equal[that <: Result](that: that): equal[that]
    type equal[that <: Result] <: Boolean

     def nequal[that <: Result](that: that): nequal[that]
    type nequal[that <: Result] <: Boolean

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
sealed abstract class AbstractResult extends Result {
    final override  def asOrderingResult: asOrderingResult = self
    final override type asOrderingResult                   = self

    final override  def nequal[that <: Result](that: that): nequal[that] = equal(that).not
    final override type nequal[that <: Result]                           = equal[that]#not

    final override  def isLTEQ: isLTEQ = isLT.or(isEQ)
    final override type isLTEQ         = isLT#or[isEQ]
    final override  def isGTEQ: isGTEQ = isGT.or(isEQ)
    final override type isGTEQ         = isGT#or[isEQ]

    final override def canEqual(that: scala.Any) = that.isInstanceOf[Result]
}


sealed abstract class LT extends AbstractResult {
    type self = LT

    override  def unsing: unsing = -1

    override  def equal[that <: Result](that: that): equal[that] = that.isLT
    override type equal[that <: Result]                          = that#isLT

    override  def isLT: isLT = `true`
    override type isLT       = `true`
    override  def isGT: isGT = `false`
    override type isGT       = `false`
    override  def isEQ: isEQ = `false`
    override type isEQ       = `false`
}

sealed abstract class GT extends AbstractResult {
    type self = GT

    override  def unsing: unsing = 1

    override  def equal[that <: Result](that: that): equal[that] = that.isGT
    override type equal[that <: Result]                          = that#isGT

    override  def isLT: isLT = `false`
    override type isLT       = `false`
    override  def isGT: isGT = `true`
    override type isGT       = `true`
    override  def isEQ: isEQ = `false`
    override type isEQ       = `false`
}

sealed abstract class EQ extends AbstractResult {
    type self = EQ

    override  def unsing: unsing = 0

    override  def equal[that <: Result](that: that): equal[that] = that.isEQ
    override type equal[that <: Result]                          = that#isEQ

    override  def isLT: isLT = `false`
    override type isLT       = `false`
    override  def isGT: isGT = `false`
    override type isGT       = `false`
    override  def isEQ: isEQ = `true`
    override type isEQ       = `true`
}


private[sing]
object _Result {
    val LT = new LT{}
    val GT = new GT{}
    val EQ = new EQ{}
}
