

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


// See: http://stackoverflow.com/questions/16267771/how-to-convert-a-seqbyte-into-an-arrayboolean-representing-each-bit-in-scala


private object Bits {
    def apply(from: String): scala.List[scala.Boolean] = {
        removeTrailingFalse(stringToBooleans(from)).toList
    }

    // For the constraint of dense
    private def removeTrailingFalse(from: scala.List[scala.Boolean]): scala.List[scala.Boolean] = {
        from.reverse.dropWhile(_ == false).reverse.toList
    }

    private def stringToBooleans(from: String): scala.List[scala.Boolean] = {
        from.getBytes("UTF-8").flatMap(b => byteToBooleans(b)).toList
    }

    private def byteToBooleans(b: Byte): scala.List[scala.Boolean] = (0 to 7).map(isBitSet(b)).toList

    private def isBitSet(byte: Byte)(bit: Int): scala.Boolean = ((byte >> bit) & 1) == 1
}
