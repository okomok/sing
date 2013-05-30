

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package ordering


private[sing]
trait Common {
    val LT: LT = _Result.LT
    val GT: GT = _Result.GT
    val EQ: EQ = _Result.EQ

    /**
     * Always returns `EQ`.
     */
     val alwaysEQ = new AlwaysEQ
    type alwaysEQ = AlwaysEQ

    /*
     * The ordering based on typeId

     val typeIdOrdering: typeIdOrdering = new TypeIdOrdering
    type typeIdOrdering                 =     TypeIdOrdering     */
}
