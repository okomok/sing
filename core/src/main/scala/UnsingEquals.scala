

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


/**
 * Mixin for a metatype whose `equals` is value-equality.
 */
trait UnsingEquals extends Any {
    override def equals(that: scala.Any) = that match {
        case that: Any => (this eq that) || (that canEqual this) && (unsing == that.unsing)
        case _ => false
    }
    override def hashCode = unsing.hashCode
    override def toString = "sing." + unsing.toString
}
