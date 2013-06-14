

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package set


private[sing]
object SubsetOf {
     def apply[s <: Set, z <: Set](s: s, z: z): apply[s, z] = s.asList.forall(Pred(z))
    type apply[s <: Set, z <: Set]                          = s#asList#forall[Pred[z]]

    case class Pred[z <: Set](z: z) extends AsFunction1 {
        override type self = Pred[z]
        override  def apply[k <: Any](k: k): apply[k] = z.contains(k)
        override type apply[k <: Any]                 = z#contains[k]
    }
}
