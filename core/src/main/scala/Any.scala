

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
trait Any extends scala.Equals with TermWrapper {

    @Annotation.returnThis
    final val self: self = this.asInstanceOf[self]
    type self <: Any

     def kind: kind = Unsupported("Any.kind").unwrap
    type kind <: Kind

    // likely to work
     def is[K <: Kind](K: K): is[K] = Unsupported("Any.is").unwrap
    type is[K <: Kind] <: Boolean

    // unlikely to work
     def as[K <: Kind](K: K): as[K] = ???
    type as[K <: Kind] <: K

     def asBoolean: asBoolean = Unsupported("Any.asBoolean").unwrap
    type asBoolean <: Boolean

     def asBoxed: asBoxed = Unsupported("Any.asBoxed").unwrap
    type asBoxed <: Boxed

     def asEither: asEither = Unsupported("Any.asBoolean").unwrap
    type asEither <: Either

     def asFunction0: asFunction0 = Unsupported("Any.asFunction0").unwrap
    type asFunction0 <: Function0

     def asFunction1: asFunction1 = Unsupported("Any.asFunction1").unwrap
    type asFunction1 <: Function1

     def asFunction2: asFunction2 = Unsupported("Any.asFunction2").unwrap
    type asFunction2 <: Function2

     def asFunction3: asFunction3 = Unsupported("Any.asFunction3").unwrap
    type asFunction3 <: Function3

     def asPartialFunction: asPartialFunction = Unsupported("Any.asPartialFunction").unwrap
    type asPartialFunction <: PartialFunction

     def asKind: asKind = Unsupported("Any.asKind").unwrap
    type asKind <: Kind

     def asList: asList = Unsupported("Any.asList").unwrap
    type asList <: List

     def asMap: asMap = Unsupported("Any.asMap").unwrap
    type asMap <: Map

     def asNat: asNat = Unsupported("Any.asNat").unwrap
    type asNat <: Nat

     def asSet: asSet = Unsupported("Any.asSet").unwrap
    type asSet <: Set

     def asOption: asOption = Unsupported("Any.asOption").unwrap
    type asOption <: Option

     def asRelation: asRelation = Unsupported("Any.asRelation").unwrap
    type asRelation <: Relation

     def asEquiv: asEquiv = Unsupported("Any.asEquiv").unwrap
    type asEquiv <: Equiv

     def asPartialOrdering: asPartialOrdering = Unsupported("Any.asPartialOrdering").unwrap
    type asPartialOrdering <: PartialOrdering

     def asOrdering: asOrdering = Unsupported("Any.asOrdering").unwrap
    type asOrdering <: Ordering

     def asOrderingResult: asOrderingResult = Unsupported("Any.asOrderingResult").unwrap
    type asOrderingResult <: OrderingResult

     def asProduct: asProduct = Unsupported("Any.asProduct").unwrap
    type asProduct <: Product

     def asProduct1: asProduct1 = Unsupported("Any.asProduct1").unwrap
    type asProduct1 <: Product1

     def asProduct2: asProduct2 = Unsupported("Any.asProduct2").unwrap
    type asProduct2 <: Product2

     def asProduct3: asProduct3 = Unsupported("Any.asProduct3").unwrap
    type asProduct3 <: Product3

     def asUnit: asUnit = Unsupported("Any.asUnit").unwrap
    type asUnit <: Unit

     def equal[that <: Any](that: that): equal[that] = Unsupported("Any.equal").unwrap
    type equal[that <: Any] <: Boolean

     def nequal[that <: Any](that: that): nequal[that] = Unsupported("Any.nequal").unwrap
    type nequal[that <: Any] <: Boolean

    /**
     * Escapes from the sing world.
     */
     def unsing: unsing = Unsupported("Any.unsing").unwrap
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
    override  def unwrap: unwrap = self
    override type unwrap         = self

    override  def is[K <: Kind](K: K): is[K] = kind.conformsTo(K)
    override type is[K <: Kind]              = kind#conformsTo[K]

    override  def nequal[that <: Any](that: that): nequal[that] = equal(that).not
    override type nequal[that <: Any]                           = equal[that]#not
}
