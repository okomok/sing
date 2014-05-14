

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


/**
 * Mixin for List-like structure based on asList.
 */
trait ListLike extends Any {
    override  def equal[that <: Any](that: that): equal[that] = asList.equal(that.asList)
    override type equal[that <: Any]                          = asList#equal[that#asList]
}
