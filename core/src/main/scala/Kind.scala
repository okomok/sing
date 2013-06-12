

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


/**
 * Metatype, or kind
 */
trait Kind extends Any {

    /**
     * ID number
     */
     def kindId: kindId = unsupported("Kind.kindId")
    type kindId <: KindId

    /**
     * Checks the kind-conformance.
     */
     def conformsTo[that <: Kind](that: that): conformsTo[that] = unsupported("Kind.conformsTo")
    type conformsTo[that <: Kind] <: Boolean

    /**
     * Returns the natural ordering.
     */
     def naturalOrdering: naturalOrdering = unsupported("Kind.naturalOrdering")
    type naturalOrdering <: Ordering
}
