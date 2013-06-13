

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Product2 extends AsKind with ListLikeKind


trait Product2 extends Product {
    override type self <: Product2

     def _1: _1
    type _1 <: Any

     def _2: _2
    type _2 <: Any
}
