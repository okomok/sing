

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


/**
 * List of Nats
 */
sealed trait KindId extends Any {
    override type self <: KindId
    override type unsing <: scala.collection.immutable.Seq[scala.Any]
}


// private[sing]
object KindId {

    @Annotation.visibleForMacro
    final case class From[ns <: List](override val asList: ns) extends AsAny with KindId {
        override type self = From[ns]

        override  def asKindId: asKindId = self
        override type asKindId           = self

        override type asList = ns

        override  def naturalOrdering: naturalOrdering = asList.naturalOrdering
        override type naturalOrdering                  = asList#naturalOrdering

        override  def equal[that <: Any](that: that): equal[that] = naturalOrdering.equiv(asList, that.asList)
        override type equal[that <: Any]                          = naturalOrdering#equiv[asList, that#asList]

        override  def unsing: unsing = asList.unsing
        override type unsing         = asList#unsing
    }
}
