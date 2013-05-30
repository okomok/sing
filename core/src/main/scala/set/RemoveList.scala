

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package set


private[sing]
object RemoveList {
     def apply[s <: Set, xs <: List](s: s, xs: xs): apply[s, xs] = xs.foldLeft(s, Step).asSet
    type apply[s <: Set, xs <: List]                             = xs#foldLeft[s, Step]#asSet

    val Step = new Step
    class Step extends Function2 {
        type self = Step
        override  def apply[b <: Any, a <: Any](b: b, a: a): apply[b, a] = b.asSet.remove(a)
        override type apply[b <: Any, a <: Any]                          = b#asSet#remove[a]
    }
}
