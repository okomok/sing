

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait Equiv extends Relation {
    override type self <: Equiv

     def equiv[x <: Any, y <: Any](x: x, y: y): equiv[x, y]
    type equiv[x <: Any, y <: Any] <: Boolean
}
