

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsNatKind extends AnyKind {
    // You can't use macros
    //   whic, depend on Dense, which in turn, needs Nat.
    //   Then kindId can't be defined. (AbstractMethodError)
    final override lazy val kindId: kindId = KindId.From(DNil :: Nil)
    final override     type kindId         = KindId.From[DNil :: Nil]

    final override lazy val naturalOrdering: naturalOrdering = new NatNaturalOrdering
    final override     type naturalOrdering                  =     NatNaturalOrdering
}
