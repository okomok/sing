

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


/**
 * List of Nats
 */
sealed trait KindId extends Any {
    type self <: KindId
    type unsing <: scala.collection.immutable.Seq[scala.Any]

     def equal[that <: KindId](that: that): equal[that]
    type equal[that <: KindId] <: Boolean
}


// private[sing]
object KindId {

    @annotation.visibleForMacro
    final case class From[ns <: List](override val asList: ns) extends KindId {
        type self = From[ns]

        override  def asKindId: asKindId = self
        override type asKindId           = self

        override type asList = ns

        override  def naturalOrdering = asList.naturalOrdering
        override type naturalOrdering = asList#naturalOrdering

        override  def equal[that <: KindId](that: that): equal[that] = naturalOrdering.equiv(asList, that.asList)
        override type equal[that <: KindId]                          = naturalOrdering#equiv[asList, that#asList]

        override  def unsing: unsing = asList.unsing
        override type unsing         = asList#unsing
    }

}

