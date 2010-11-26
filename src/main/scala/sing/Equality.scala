

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


/**
 * Mixin for a metatype whose `equals` is reference-equality.
 */
trait ReferenceEquality extends Any {
    override def equals(that: scala.Any) = refEquals(that)
    override def hashCode = refHashCode
    override def toString = refToString
    override def canEqual(that: scala.Any): scala.Boolean = throw new UnsupportedOperationException("ReferenceEquality.canEqual")
}

/**
 * Mixin for a metatype whose `equals` is value-equality.
 */
trait ValueEquality extends Any {
    override def equals(that: scala.Any) = that match {
        case that: Any => (this eq that) || (that canEqual this) && (unsing == that.unsing)
        case _ => false
    }
    override def hashCode = unsing.hashCode
    override def toString = "sing." + unsing.toString
}
