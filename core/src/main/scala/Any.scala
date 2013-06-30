

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Any extends AsKind {
    override  def kindId: kindId = KindId.ofAny
    override type kindId         = KindId.ofAny
}


/**
 * The sing Any
 */
trait Any extends scala.Equals {

    @Annotation.returnThis
    final val self: self = this.asInstanceOf[self]
    type self <: Any

     def kind: kind = makro.Unsupported.apply("Any.kind")
    type kind <: Kind

    // likely to work
     def is[K <: Kind](K: K): is[K] = makro.Unsupported.apply("Any.is")
    type is[K <: Kind] <: Boolean

    // unlikely to work
     def as[K <: Kind](K: K): as[K] = ???
    type as[K <: Kind] <: K

     def asBoolean: asBoolean = makro.Unsupported.apply("Any.asBoolean")
    type asBoolean <: Boolean

     def asBoxed: asBoxed = makro.Unsupported.apply("Any.asBoxed")
    type asBoxed <: Boxed

     def asEither: asEither = makro.Unsupported.apply("Any.asBoolean")
    type asEither <: Either

     def asFunction0: asFunction0 = makro.Unsupported.apply("Any.asFunction0")
    type asFunction0 <: Function0

     def asFunction1: asFunction1 = makro.Unsupported.apply("Any.asFunction1")
    type asFunction1 <: Function1

     def asFunction2: asFunction2 = makro.Unsupported.apply("Any.asFunction2")
    type asFunction2 <: Function2

     def asFunction3: asFunction3 = makro.Unsupported.apply("Any.asFunction3")
    type asFunction3 <: Function3

     def asPartialFunction: asPartialFunction = makro.Unsupported.apply("Any.asPartialFunction")
    type asPartialFunction <: PartialFunction

     def asKind: asKind = makro.Unsupported.apply("Any.asKind")
    type asKind <: Kind

     def asList: asList = makro.Unsupported.apply("Any.asList")
    type asList <: List

     def asMap: asMap = makro.Unsupported.apply("Any.asMap")
    type asMap <: Map

     def asNat: asNat = makro.Unsupported.apply("Any.asNat")
    type asNat <: Nat

     def asSet: asSet = makro.Unsupported.apply("Any.asSet")
    type asSet <: Set

     def asOption: asOption = makro.Unsupported.apply("Any.asOption")
    type asOption <: Option

     def asRelation: asRelation = makro.Unsupported.apply("Any.asRelation")
    type asRelation <: Relation

     def asEquiv: asEquiv = makro.Unsupported.apply("Any.asEquiv")
    type asEquiv <: Equiv

     def asPartialOrdering: asPartialOrdering = makro.Unsupported.apply("Any.asPartialOrdering")
    type asPartialOrdering <: PartialOrdering

     def asOrdering: asOrdering = makro.Unsupported.apply("Any.asOrdering")
    type asOrdering <: Ordering

     def asOrderingResult: asOrderingResult = makro.Unsupported.apply("Any.asOrderingResult")
    type asOrderingResult <: OrderingResult

     def asProduct: asProduct = makro.Unsupported.apply("Any.asProduct")
    type asProduct <: Product

     def asProduct1: asProduct1 = makro.Unsupported.apply("Any.asProduct1")
    type asProduct1 <: Product1

     def asProduct2: asProduct2 = makro.Unsupported.apply("Any.asProduct2")
    type asProduct2 <: Product2

     def asProduct3: asProduct3 = makro.Unsupported.apply("Any.asProduct3")
    type asProduct3 <: Product3

     def asUnit: asUnit = makro.Unsupported.apply("Any.asUnit")
    type asUnit <: Unit

     def equal[that <: Any](that: that): equal[that] = makro.Unsupported.apply("Any.equal")
    type equal[that <: Any] <: Boolean

     def nequal[that <: Any](that: that): nequal[that] = makro.Unsupported.apply("Any.nequal")
    type nequal[that <: Any] <: Boolean

    /**
     * Escapes from the sing world.
     */
     def unsing: unsing = makro.Unsupported.apply("Any.unsing")
    type unsing

    final protected def refEquals(that: scala.Any) = super.equals(that)
    final protected def refHashCode = super.hashCode
    final protected def refToString = super.toString
}


trait AsAny extends AnyImpl {
    override  def kind: kind = Any
    override type kind       = Any.type
}


trait AnyImpl extends Any {
    override  def is[K <: Kind](K: K): is[K] = kind.conformsTo(K)
    override type is[K <: Kind]              = kind#conformsTo[K]

    override  def nequal[that <: Any](that: that): nequal[that] = equal(that).not
    override type nequal[that <: Any]                           = equal[that]#not
}
