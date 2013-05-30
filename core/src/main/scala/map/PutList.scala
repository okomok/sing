

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package map


private[sing]
object PutList {
     def apply[m <: Map, xs <: List](m: m, xs: xs): apply[m, xs] = xs.foldLeft(m, Step).asMap
    type apply[m <: Map, xs <: List]                             = xs#foldLeft[m, Step]#asMap

    val Step = new Step
    class Step extends Function2 {
        type self = Step
        override  def apply[b <: Any, a <: Any](b: b, a: a): apply[b, a] =
            b.asMap.put(a.asProduct2._1, a.asProduct2._2)
        override type apply[b <: Any, a <: Any] =
            b#asMap#put[a#asProduct2#_1, a#asProduct2#_2]
    }
}
