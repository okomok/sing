

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Product extends HasKind {
    override lazy val kind: kind = new ProductKind
    override     type kind       =     ProductKind
}


trait Product extends Any {
    override type self <: Product

     def arity: arity
    type arity <: Nat

     def productElement[n <: Nat](n: n): productElement[n]
    type productElement[n <: Nat] <: Any
}
