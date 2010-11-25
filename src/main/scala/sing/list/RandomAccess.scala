

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


/**
 * Marker trait for random-access list
 */
trait RandomAccess extends List {
    type self <: RandomAccess

    @constantTime
    override  def length: length
    override type length <: Nat

    @constantTime
    override  def nth[n <: Nat](n: n): nth[n]
    override type nth[n <: Nat] <: Any
}
