

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsBooleanKind extends AnyKind {
    override lazy val kindId: kindId = ???
    override     type kindId         = Nothing

    override lazy val naturalOrdering: naturalOrdering = new BooleanNaturalOrdering
    override     type naturalOrdering                  =     BooleanNaturalOrdering
}
