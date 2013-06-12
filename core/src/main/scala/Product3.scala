

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Product3 extends HasKind {
    override lazy val kind: kind = new Product3Kind
    override     type kind       =     Product3Kind
}


trait Product3 extends Product {
    override type self <: Product3

     def _1: _1
    type _1 <: Any

     def _2: _2
    type _2 <: Any

     def _3: _3
    type _3 <: Any
}
