

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import list._


trait AsListKind extends makro.AsKind.apply {
    /**
     * Makes a lexicographical Ordering from element natural ordering.
     */
    // `lazy` because `None` is initialized later in `package sing`.
    final override lazy val naturalOrdering: naturalOrdering = LexicographicalOrdering.apply(None)
    final override     type naturalOrdering                  = LexicographicalOrdering.apply[None]
}
