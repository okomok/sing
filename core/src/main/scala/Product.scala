

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait Product extends Any {
    type self <: Product

     def arity: arity
    type arity <: Nat

     def productElement[n <: Nat](n: n): productElement[n]
    type productElement[n <: Nat] <: Any
}
