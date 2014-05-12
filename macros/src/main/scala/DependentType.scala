

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


trait DependentType {
    // `this.type` seems broken, so we define...
     val self: self = this
    type self       = this.type

     def apply: apply
    type apply
}
