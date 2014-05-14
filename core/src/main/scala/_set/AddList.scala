

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _set


private[sing]
object AddList {
     def apply[s <: Set, xs <: List](s: s, xs: xs): apply[s, xs] = xs.foldLeft(s, Step).asSet
    type apply[s <: Set, xs <: List]                             = xs#foldLeft[s, Step]#asSet

    val Step = new Step
    class Step extends AsFunction2 {
        override type self = Step
        override  def apply[b <: Any, a <: Any](b: b, a: a): apply[b, a] = b.asSet.add(a)
        override type apply[b <: Any, a <: Any]                          = b#asSet#add[a]
    }
}
