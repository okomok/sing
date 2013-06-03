

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


/**
 * Metatype, or kind
 */
trait AnyKind {

    /**
     * ID number
     */
     def kindId: kindId = ???
    type kindId <: KindId

    /**
     * Returns the natural ordering.
     */
     def naturalOrdering: naturalOrdering = unsupported("Any.naturalOrdering")
    type naturalOrdering <: Ordering

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
