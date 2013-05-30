

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat


private[sing]
trait Common {
    @annotation.aliasOf("dense.Dense")
     val Dense = dense.Dense
    type Dense = dense.Dense

    @annotation.aliasOf("peano.Peano")
     val Peano = peano.Peano
    type Peano = peano.Peano

    /**
     * The natural ordering of Nat
     */
     val naturalOrdering: naturalOrdering = new NaturalOrdering
    type naturalOrdering                  =     NaturalOrdering
}