

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


object Any extends AsKind {
    override  def kindId: kindId = KindId.ofAny
    override type kindId         = KindId.ofAny
}


/**
 * The sing Any
 */
trait Any extends scala.Equals with makro.DependentType {

    @Annotation.returnThis
    final val self: self = this.asInstanceOf[self]
    type self <: Any

     def kind: kind = makro.Unsupported("Any.kind").self
    type kind <: Kind

    // likely to work
     def is[K <: Kind](K: K): is[K] = makro.Unsupported("Any.is").self
    type is[K <: Kind] <: Boolean

    // unlikely to work
     def as[K <: Kind](K: K): as[K] = ???
    type as[K <: Kind] <: K

     def asBoolean: asBoolean = makro.Unsupported("Any.asBoolean").self
    type asBoolean <: Boolean

     def asBoxed: asBoxed = makro.Unsupported("Any.asBoxed").self
    type asBoxed <: Boxed

     def asEither: asEither = makro.Unsupported("Any.asBoolean").self
    type asEither <: Either

     def asFunction0: asFunction0 = makro.Unsupported("Any.asFunction0").self
    type asFunction0 <: Function0

     def asFunction1: asFunction1 = makro.Unsupported("Any.asFunction1").self
    type asFunction1 <: Function1

     def asFunction2: asFunction2 = makro.Unsupported("Any.asFunction2").self
    type asFunction2 <: Function2

     def asFunction3: asFunction3 = makro.Unsupported("Any.asFunction3").self
    type asFunction3 <: Function3

     def asPartialFunction: asPartialFunction = makro.Unsupported("Any.asPartialFunction").self
    type asPartialFunction <: PartialFunction

     def asKind: asKind = makro.Unsupported("Any.asKind").self
    type asKind <: Kind

     def asList: asList = makro.Unsupported("Any.asList").self
    type asList <: List

     def asMap: asMap = makro.Unsupported("Any.asMap").self
    type asMap <: Map

     def asNat: asNat = makro.Unsupported("Any.asNat").self
    type asNat <: Nat

     def asSet: asSet = makro.Unsupported("Any.asSet").self
    type asSet <: Set

     def asOption: asOption = makro.Unsupported("Any.asOption").self
    type asOption <: Option

     def asRelation: asRelation = makro.Unsupported("Any.asRelation").self
    type asRelation <: Relation

     def asEquiv: asEquiv = makro.Unsupported("Any.asEquiv").self
    type asEquiv <: Equiv

     def asPartialOrdering: asPartialOrdering = makro.Unsupported("Any.asPartialOrdering").self
    type asPartialOrdering <: PartialOrdering

     def asOrdering: asOrdering = makro.Unsupported("Any.asOrdering").self
    type asOrdering <: Ordering

     def asOrderingResult: asOrderingResult = makro.Unsupported("Any.asOrderingResult").self
    type asOrderingResult <: OrderingResult

     def asProduct: asProduct = makro.Unsupported("Any.asProduct").self
    type asProduct <: Product

     def asProduct1: asProduct1 = makro.Unsupported("Any.asProduct1").self
    type asProduct1 <: Product1

     def asProduct2: asProduct2 = makro.Unsupported("Any.asProduct2").self
    type asProduct2 <: Product2

     def asProduct3: asProduct3 = makro.Unsupported("Any.asProduct3").self
    type asProduct3 <: Product3

     def asUnit: asUnit = makro.Unsupported("Any.asUnit").self
    type asUnit <: Unit

     def equal[that <: Any](that: that): equal[that] = makro.Unsupported("Any.equal").self
    type equal[that <: Any] <: Boolean

     def nequal[that <: Any](that: that): nequal[that] = makro.Unsupported("Any.nequal").self
    type nequal[that <: Any] <: Boolean

    /**
     * Escapes from the sing world.
     */
     def unsing: unsing = makro.Unsupported("Any.unsing").self
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
