

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _set


private[sing]
object Intersect {
     def apply[s <: Set, z <: Set](s: s, z: z): apply[s, z] = s.clear.addList(s.asList.filter(Pred(z)))
    type apply[s <: Set, z <: Set]                          = s#clear#addList[s#asList#filter[Pred[z]]]

    case class Pred[z <: Set](z: z) extends AsFunction1 {
        override type self = Pred[z]
        override  def apply[k <: Any](k: k): apply[k] = z.contains(k)
        override type apply[k <: Any]                 = z#contains[k]
    }
}
