

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


/**
 * Mixin for List-like structure based on asList.
 */
trait ListLikeKind extends Kind {
    override lazy val naturalOrdering: naturalOrdering = List.naturalOrdering
    override     type naturalOrdering                  = List.naturalOrdering
}
