

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsBooleanKind extends AnyKind {
    final override lazy val kindId: kindId = KindId.From(DNil :: DNil :: Nil)
    final override     type kindId         = KindId.From[DNil :: DNil :: Nil]

    final override lazy val naturalOrdering: naturalOrdering = new BooleanNaturalOrdering
    final override     type naturalOrdering                  =     BooleanNaturalOrdering
}
