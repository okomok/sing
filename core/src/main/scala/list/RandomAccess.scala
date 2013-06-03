

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


/**
 * Marker trait for random-access list
 */
trait RandomAccess extends List {
    override type self <: RandomAccess

    @Annotation.constantTime
    override  def length: length
    override type length <: Nat

    @Annotation.constantTime
    override  def nth[n <: Nat](n: n): nth[n]
    override type nth[n <: Nat] <: Any
}
