

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


/**
 * The sing Any
 */
trait Any extends Term with scala.Equals {

    @annotation.returnThis
    final val self: self = this.asInstanceOf[self]
    type self <: Any

    final override  def is[K <: Type](K: K): is[K] = typeId.equal(K.typeId)
    final override type is[K <: Type]              = typeId#equal[K#typeId]

     def asBoolean: asBoolean = unsupported("Any.asBoolean")
    type asBoolean <: Boolean

     def asEither: asEither = unsupported("Any.asBoolean")
    type asEither <: Either

     def asFunction0: asFunction0 = unsupported("Any.asFunction0")
    type asFunction0 <: Function0

     def asFunction1: asFunction1 = unsupported("Any.asFunction1")
    type asFunction1 <: Function1

     def asFunction2: asFunction2 = unsupported("Any.asFunction2")
    type asFunction2 <: Function2

     def asFunction3: asFunction3 = unsupported("Any.asFunction3")
    type asFunction3 <: Function3

     def asList: asList = unsupported("Any.asList")
    type asList <: List

     def asMap: asMap = unsupported("Any.asMap")
    type asMap <: Map

     def asNat: asNat = unsupported("Any.asNat")
    type asNat <: Nat

     def asSet: asSet = unsupported("Any.asSet")
    type asSet <: Set

     def asOption: asOption = unsupported("Any.asOption")
    type asOption <: Option

     def asEquiv: asEquiv = unsupported("Any.asEquiv")
    type asEquiv <: Equiv

     def asOrdering: asOrdering = unsupported("Any.asOrdering")
    type asOrdering <: Ordering

     def asOrderingResult: asOrderingResult = unsupported("Any.asOrderingResult")
    type asOrderingResult <: ordering.Result

     def asPeg: asPeg = unsupported("Any.asPeg")
    type asPeg <: Peg

     def asPegResult: asPegResult = unsupported("Any.asPegResult")
    type asPegResult <: peg.Result

     def asProduct: asProduct = unsupported("Any.asProduct")
    type asProduct <: Product

     def asProduct1: asProduct1 = unsupported("Any.asProduct1")
    type asProduct1 <: Product1

     def asProduct2: asProduct2 = unsupported("Any.asProduct2")
    type asProduct2 <: Product2

     def asProduct3: asProduct3 = unsupported("Any.asProduct3")
    type asProduct3 <: Product3

     def asUnit: asUnit = unsupported("Any.asUnit")
    type asUnit <: Unit

    /**
     * Returns the natural ordering.
     */
     def naturalOrdering: naturalOrdering = unsupported("Any.naturalOrdering")
    type naturalOrdering <: Ordering

    /**
     * Escapes from the sing world.
     */
     def unsing: unsing = unsupported("Any.unsing")
    type unsing

    override def equals(that: scala.Any) = that match {
        case that: Any => (this eq that) || (that canEqual this) && (unsing == that.unsing)
        case _ => false
    }
    override def hashCode = unsing.hashCode
    override def toString = "sing." + unsing.toString

    final protected def refEquals(that: scala.Any) = super.equals(that)
    final protected def refHashCode = super.hashCode
    final protected def refToString = super.toString

    /**
     * Trivial helper to throw UnsupportedOperationException
     */
    protected  def unsupported(what: Predef.String): unsupported[_] = throw new UnsupportedOperationException("sing." + what)
    protected type unsupported[_] = Nothing

    /**
     * Trivial helper to throw NoSuchElementException
     */
    protected  def noSuchElement(what: Predef.String): noSuchElement[_] = throw new NoSuchElementException("sing." + what)
    protected type noSuchElement[_] = Nothing

}
