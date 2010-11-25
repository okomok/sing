

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


trait Forwarder extends Any {
    protected  def delegate: delegate
    protected type delegate <: Any
/*
    final override  def asBoolean: asBoolean = delegate.asBoolean
    final override type asBoolean            = delegate#asBoolean

    final override  def asEither: asEither = delegate.asEither
    final override type asEither           = delegate#asEither

    final override  def asFunction0: asFunction0 = delegate.asFunction0
    final override type asFunction0              = delegate#asFunction0

    final override  def asFunction1: asFunction1 = delegate.asFunction1
    final override type asFunction1              = delegate#asFunction1

    final override  def asFunction2: asFunction2 = delegate.asFunction2
    final override type asFunction2              = delegate#asFunction2

    final override  def asFunction3: asFunction3 = delegate.asFunction3
    final override type asFunction3              = delegate#asFunction3

    final override  def asList: asList = delegate.asList
    final override type asList         = delegate#asList

    final override  def asMap: asMap = delegate.asMap
    final override type asMap        = delegate#asMap

    final override  def asNat: asNat = delegate.asNat
    final override type asNat        = delegate#asNat

    final override  def asSet: asSet = delegate.asSet
    final override type asSet        = delegate#asSet

    final override  def asOption: asOption = delegate.asOption
    final override type asOption           = delegate#asOption

    final override  def asEquiv: asEquiv = delegate.asEquiv
    final override type asEquiv          = delegate#asEquiv

    final override  def asOrdering: asOrdering = delegate.asOrdering
    final override type asOrdering             = delegate#asOrdering

    final override  def asOrderingResult: asOrderingResult = delegate.asOrderingResult
    final override type asOrderingResult                   = delegate#asOrderingResult

    final override  def asPeg: asPeg = delegate.asPeg
    final override type asPeg        = delegate#asPeg

    final override  def asPegResult: asPegResult = delegate.asPegResult
    final override type asPegResult              = delegate#asPegResult

    final override  def asProduct: asProduct = delegate.asProduct
    final override type asProduct            = delegate#asProduct

    final override  def asProduct1: asProduct1 = delegate.asProduct1
    final override type asProduct1             = delegate#asProduct1

    final override  def asProduct2: asProduct2 = delegate.asProduct2
    final override type asProduct2             = delegate#asProduct2

    final override  def asProduct3: asProduct3 = delegate.asProduct3
    final override type asProduct3             = delegate#asProduct3

    final override  def asUnit: asUnit = delegate.asUnit
    final override type asUnit         = delegate#asUnit
*/
    final override  def naturalOrdering: naturalOrdering = delegate.naturalOrdering
    final override type naturalOrdering                  = delegate#naturalOrdering

    final override  def unsung: unsung = delegate.unsung
    final override type unsung         = delegate#unsung

    override def equals(that: scala.Any) = that match {
        case that: Forwarder => delegate.equals(that.delegate)
        case _ => false
    }
    override  def hashCode = delegate.hashCode
    override  def toString = delegate.toString
    override  def canEqual(that: scala.Any) = delegate.canEqual(that)
}
