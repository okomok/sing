

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


// See: http://apocalisp.wordpress.com/2010/06/24/type-level-programming-in-scala-part-5a-binary-numbers/


import dense._


object Dense extends Literal {

    @Annotation.aliasOf("DCons")
     val :: = DCons
    type ::[x <: Boolean, xs <: Dense] = DCons[x, xs]

}


sealed abstract class Dense extends AbstractNat {
    type self <: Dense

     def head: head
    type head <: Boolean

     def tail: tail
    type tail <: Dense

     def size: size
    type size <: Peano

    override type increment <: Dense
    override type decrement <: Dense
    override type plus[that <: Nat] <: Dense
    override type minus[that <: Nat] <: Dense
    override type times[that <: Nat] <: Dense
    override type bitAnd[that <: Nat] <: Dense
    override type bitOr[that <: Nat] <: Dense

    @Annotation.equivalentTo("DCons(e. self)")
     def ::[e <: Boolean](e: e): ::[e]
    type ::[e <: Boolean] <: Dense

     def shiftLeft: shiftLeft
    type shiftLeft <: Dense

     def shiftRight: shiftRight
    type shiftRight <: Dense

     def foldRightWithNat[z <: Any, f <: Function2](z: z, f: f): foldRightWithNat[z, f]
    type foldRightWithNat[z <: Any, f <: Function2] <: Any

     def shiftLeftBy[n <: Peano](n: n): shiftLeftBy[n]
    type shiftLeftBy[n <: Peano] <: Dense
}


private[sing]
sealed abstract class AbstractDense extends Dense {
    final override  def asDense: asDense = self
    final override type asDense          = self

    @Annotation.equivalentTo("DCons(e. self)")
    final override  def ::[e <: Boolean](e: e): ::[e] = DCons(e, self)
    final override type ::[e <: Boolean]              = DCons[e, self]

    final override  def plus[that <: Nat](that: that): plus[that] = Plus.apply(self, that.asDense)
    final override type plus[that <: Nat]                         = Plus.apply[self, that#asDense]

    final override  def minus[that <: Nat](that: that): minus[that] = Minus.apply(self, that.asDense)
    final override type minus[that <: Nat]                          = Minus.apply[self, that#asDense]

    final override  def quotRem[that <: Nat](that: that): quotRem[that] = QuotRem.apply(self, that.asDense)
    final override type quotRem[that <: Nat]                            = QuotRem.apply[self, that#asDense]

    final override  def equal[that <: Nat](that: that): equal[that] = Equal.apply(self, that.asDense)
    final override type equal[that <: Nat]                          = Equal.apply[self, that#asDense]

    final override  def lt[that <: Nat](that: that): lt[that] = Lt.apply(self, that.asDense)
    final override type lt[that <: Nat]                       = Lt.apply[self, that#asDense]

    final override  def lteq[that <: Nat](that: that): lteq[that] = that.asDense.lt(self).not
    final override type lteq[that <: Nat]                         = that#asDense#lt[self]#not

    final override  def bitAnd[that <: Nat](that: that): bitAnd[that] = BitAnd.apply(self, that.asDense)
    final override type bitAnd[that <: Nat]                           = BitAnd.apply[self, that#asDense]

    final override  def bitOr[that <: Nat](that: that): bitOr[that] = BitOr.apply(self, that.asDense)
    final override type bitOr[that <: Nat]                          = BitOr.apply[self, that#asDense]
}


sealed class DNil extends AbstractDense {
    type self = DNil

    override  def asPeano: asPeano = Zero
    override type asPeano          = Zero

    override  def unsing: unsing = 0

    override  def head: head = noSuchElement("Dense.DNil.head")
    override type head       = noSuchElement[_]

    override  def tail: tail = noSuchElement("Dense.DNil.tail")
    override type tail       = noSuchElement[_]

    override  def size: size = Zero
    override type size       = Zero

    override  def isZero: isZero = `true`
    override type isZero         = `true`

    override  def increment: increment = DCons(`true`, self)
    override type increment            = DCons[`true`, self]

    override  def decrement: decrement = unsupported("Dense.DNil.decrement")
    override type decrement            = unsupported[_]

    override  def times[that <: Nat](that: that): times[that] = self
    override type times[that <: Nat]                          = self

    override  def exp[that <: Nat](that: that): exp[that] = `if`(that.isZero, const0(Dense._1), const0(self)).apply.asNat.asDense
    override type exp[that <: Nat]                        = `if`[that#isZero, const0[Dense._1], const0[self]]#apply#asNat#asDense

    override  def shiftLeft: shiftLeft = self
    override type shiftLeft            = self

    override  def shiftRight: shiftRight = self
    override type shiftRight             = self

    override  def foldRightWithNat[z <: Any, f <: Function2](z: z, f: f): foldRightWithNat[z, f] = z
    override type foldRightWithNat[z <: Any, f <: Function2]                                     = z

    override  def shiftLeftBy[n <: Peano](n: n): shiftLeftBy[n] = self
    override type shiftLeftBy[n <: Peano]                       = self
}

private[sing]
object _DNil {
    val value: DNil = new DNil{}
}


final case class DCons[x <: Boolean, xs <: Dense](override val head: x, override val tail: xs) extends AbstractDense {
    assert(head.or(tail.isZero.not))

    type self = DCons[x, xs]

    override  def asPeano: asPeano = Succ(decrement.asPeano)
    override type asPeano          = Succ[decrement#asPeano]

    override  def unsing: unsing = (if (head.unsing) 1 else 0) + (2 * tail.unsing)

    override type head = x
    override type tail = xs

    override  val size: size = tail.size.increment
    override type size       = tail#size#increment

    override  def isZero: isZero = `false`
    override type isZero         = `false`

    override  def increment: increment = DConsIncrement.apply(head, tail)
    override type increment            = DConsIncrement.apply[head, tail]

    override  def decrement: decrement = DConsDecrement.apply(head, tail)
    override type decrement            = DConsDecrement.apply[head, tail]

    override  def times[that <: Nat](that: that): times[that] = DConsTimes.apply(head, tail, that.asDense)
    override type times[that <: Nat]                          = DConsTimes.apply[head, tail, that#asDense]

    override  def exp[that <: Nat](that: that): exp[that] = DConsExp.apply(self, that)
    override type exp[that <: Nat]                        = DConsExp.apply[self, that]

    override  def shiftLeft: shiftLeft = DConsFalse.apply(self)
    override type shiftLeft            = DConsFalse.apply[self]

    override  def shiftRight: shiftRight = tail
    override type shiftRight             = tail

    override  def foldRightWithNat[z <: Any, f <: Function2](z: z, f: f): foldRightWithNat[z, f] = f.apply(self, decrement.foldRightWithNat(z, f))
    override type foldRightWithNat[z <: Any, f <: Function2]                                     = f#apply[self, decrement#foldRightWithNat[z, f]]

    override  def shiftLeftBy[n <: Peano](n: n): shiftLeftBy[n] = DConsShiftLeftBy.apply(self, n)
    override type shiftLeftBy[n <: Peano]                       = DConsShiftLeftBy.apply[self, n]
}

