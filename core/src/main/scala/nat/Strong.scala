

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat


abstract class Strong[n <: Nat](final override protected val delegate: n) extends NatForwarder {
    final override protected type delegate = n

    final override  def asNat: asNat = self
    final override type asNat        = self
}
