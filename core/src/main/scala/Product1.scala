

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait Product1 extends Product {
    type self <: Product1

     def _1: _1
    type _1 <: Any
}
