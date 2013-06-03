

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsNatKind extends AnyKind {
    // You can't use macros
    //   whic, depend on Dense, which in turn, needs Nat.
    //   Then kindId can't be defined. (AbstractMethodError)
    override lazy val kindId: kindId = KindId.From(DNil :: Nil)
    override     type kindId         = KindId.From[DNil :: Nil]

    override lazy val naturalOrdering: naturalOrdering = new NatNaturalOrdering
    override     type naturalOrdering                  =     NatNaturalOrdering
}
