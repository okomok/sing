

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package nat


abstract class Strong[n <: Nat](final override protected val delegate: n) extends Forwarder {
    final override protected type delegate = n

    final override  def asNat: asNat = self
    final override type asNat        = self
}
