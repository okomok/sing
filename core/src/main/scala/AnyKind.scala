

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

}
