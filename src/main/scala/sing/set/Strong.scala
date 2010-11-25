

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package set


abstract class Strong[s <: Set](final override protected val delegate: s) extends Forwarder {
    final override protected type delegate = s

    final override  def asSet: asSet = self
    final override type asSet        = self

    final override  def asList: asList = delegate.asList
    final override type asList         = delegate#asList
}
