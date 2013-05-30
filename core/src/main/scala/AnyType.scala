

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


/**
 * Metatype, or kind
 */
trait AnyType {

    /**
     * ID number
     */
     def typeId: typeId = ???
    type typeId <: TypeId

}

