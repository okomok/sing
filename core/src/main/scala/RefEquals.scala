

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


/**
 * Mixin for a metatype whose `equals` is reference-equality.
 */
trait RefEquals extends Any {
    override def equals(that: scala.Any) = refEquals(that)
    override def hashCode = refHashCode
    override def toString = refToString
    override def canEqual(that: scala.Any): scala.Boolean = throw new UnsupportedOperationException("RefEquals.canEqual")
}
