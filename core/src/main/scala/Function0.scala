

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait Function0 extends Any {
    override type self <: Function0

     def apply: apply
    type apply <: Any
}
