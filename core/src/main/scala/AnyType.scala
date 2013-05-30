

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


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

