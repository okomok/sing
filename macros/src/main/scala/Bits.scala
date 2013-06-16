

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


// See: http://stackoverflow.com/questions/16267771/how-to-convert-a-seqbyte-into-an-arrayboolean-representing-each-bit-in-scala


object Bits {
    def apply(from: String): List[Boolean] = {
        removeTrailingFalse(stringToBooleans(from)).toList
    }

    // For the constraint of dense
    private def removeTrailingFalse(from: List[Boolean]): List[Boolean] = {
        from.reverse.dropWhile(_ == false).reverse.toList
    }

    private def stringToBooleans(from: String): List[Boolean] = {
        from.getBytes("UTF-8").flatMap(b => byteToBooleans(b)).toList
    }

    private def byteToBooleans(b: Byte): List[Boolean] = (0 to 7).map(isBitSet(b)).toList

    private def isBitSet(byte: Byte)(bit: Int): Boolean = ((byte >> bit) & 1) == 1
}
