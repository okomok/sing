

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


/**
 * Mixin for List-like structure based on asList.
 */
trait ListLikeKind extends Kind {
    override lazy val naturalOrdering: naturalOrdering = List.naturalOrdering
    override     type naturalOrdering                  = List.naturalOrdering
}
