

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


/**
 * Mixin for List-like structure based on asList.
 */
trait ListLike extends Any {
    override  def equal[that <: Any](that: that): equal[that] = asList.equal(that.asList)
    override type equal[that <: Any]                          = asList#equal[that#asList]

    override  def naturalOrdering: naturalOrdering = List.naturalOrdering
    override type naturalOrdering                  = List.naturalOrdering
}
