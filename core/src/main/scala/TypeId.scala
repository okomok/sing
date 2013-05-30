

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


/**
 * List of Nats
 */
// private[sing]
sealed trait TypeId extends Any {
    type self <: TypeId
    type unsing <: scala.collection.immutable.Seq[scala.Any]

     def equal[that <: TypeId](that: that): equal[that]
    type equal[that <: TypeId] <: Boolean
}


// private[sing]
object TypeId {

    final case class From[ns <: List](override val asList: ns) extends TypeId {
        type self = From[ns]

        override  def asTypeId: asTypeId = self
        override type asTypeId           = self

        override type asList = ns

        override  def naturalOrdering = asList.naturalOrdering
        override type naturalOrdering = asList#naturalOrdering

        override  def equal[that <: TypeId](that: that): equal[that] = naturalOrdering.equiv(asList, that.asList)
        override type equal[that <: TypeId]                          = naturalOrdering#equiv[asList, that#asList]

        override  def unsing: unsing = asList.unsing
        override type unsing         = asList#unsing
    }

}

