

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _list


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
