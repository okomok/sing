

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


sealed trait KindId extends Any {
    override type self <: KindId
    override type unsing <: scala.collection.immutable.Seq[scala.Any]

     def hasBitOf[that <: KindId](that: that): hasBitOf[that]
    type hasBitOf[that <: KindId] <: Boolean
}
