

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

     def kind: kind = makro.Unsupported("Any.kind").apply
    type kind <: Kind

    // likely to work
     def is[K <: Kind](K: K): is[K] = makro.Unsupported("Any.is").apply
    type is[K <: Kind] <: Boolean

    // unlikely to work
     def as[K <: Kind](K: K): as[K] = ???
    type as[K <: Kind] <: K

     def asBoolean: asBoolean = makro.Unsupported("Any.asBoolean").apply
    type asBoolean <: Boolean

     def asBoxed: asBoxed = makro.Unsupported("Any.asBoxed").apply
    type asBoxed <: Boxed

     def asEither: asEither = makro.Unsupported("Any.asBoolean").apply
    type asEither <: Either

     def asFunction0: asFunction0 = makro.Unsupported("Any.asFunction0").apply
    type asFunction0 <: Function0

     def asFunction1: asFunction1 = makro.Unsupported("Any.asFunction1").apply
    type asFunction1 <: Function1

     def asFunction2: asFunction2 = makro.Unsupported("Any.asFunction2").apply
    type asFunction2 <: Function2

     def asFunction3: asFunction3 = makro.Unsupported("Any.asFunction3").apply
    type asFunction3 <: Function3

     def asPartialFunction: asPartialFunction = makro.Unsupported("Any.asPartialFunction").apply
    type asPartialFunction <: PartialFunction

     def asKind: asKind = makro.Unsupported("Any.asKind").apply
    type asKind <: Kind

     def asList: asList = makro.Unsupported("Any.asList").apply
    type asList <: List

     def asMap: asMap = makro.Unsupported("Any.asMap").apply
    type asMap <: Map

     def asNat: asNat = makro.Unsupported("Any.asNat").apply
    type asNat <: Nat

     def asSet: asSet = makro.Unsupported("Any.asSet").apply
    type asSet <: Set

     def asOption: asOption = makro.Unsupported("Any.asOption").apply
    type asOption <: Option

     def asRelation: asRelation = makro.Unsupported("Any.asRelation").apply
    type asRelation <: Relation

     def asEquiv: asEquiv = makro.Unsupported("Any.asEquiv").apply
    type asEquiv <: Equiv

     def asPartialOrdering: asPartialOrdering = makro.Unsupported("Any.asPartialOrdering").apply
    type asPartialOrdering <: PartialOrdering

     def asOrdering: asOrdering = makro.Unsupported("Any.asOrdering").apply
    type asOrdering <: Ordering

     def asOrderingResult: asOrderingResult = makro.Unsupported("Any.asOrderingResult").apply
    type asOrderingResult <: OrderingResult

     def asProduct: asProduct = makro.Unsupported("Any.asProduct").apply
    type asProduct <: Product

     def asProduct1: asProduct1 = makro.Unsupported("Any.asProduct1").apply
    type asProduct1 <: Product1

     def asProduct2: asProduct2 = makro.Unsupported("Any.asProduct2").apply
    type asProduct2 <: Product2

     def asProduct3: asProduct3 = makro.Unsupported("Any.asProduct3").apply
    type asProduct3 <: Product3

     def asUnit: asUnit = makro.Unsupported("Any.asUnit").apply
    type asUnit <: Unit

     def equal[that <: Any](that: that): equal[that] = makro.Unsupported("Any.equal").apply
    type equal[that <: Any] <: Boolean

     def nequal[that <: Any](that: that): nequal[that] = makro.Unsupported("Any.nequal").apply
    type nequal[that <: Any] <: Boolean

    /**
     * Escapes from the sing world.
     */
     def unsing: unsing = makro.Unsupported("Any.unsing").apply
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
