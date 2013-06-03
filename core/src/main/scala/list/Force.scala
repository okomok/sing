

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object Force {
     def apply[xs <: List](xs: xs): apply[xs] = `if`(xs.isEmpty, const0(Nil), Else(xs)).apply.asList
    type apply[xs <: List]                    = `if`[xs#isEmpty, const0[Nil], Else[xs]]#apply#asList

    case class Else[xs <: List](xs: xs) extends AsFunction0 {
        override type self = Else[xs]
        private[this] lazy val r: r = Force.apply(xs.tail).asInstanceOf[r]
        private[this]     type r    = Force.apply[xs#tail]
        override  def apply: apply = Cons(xs.head, r)
        override type apply        = Cons[xs#head, r]
    }
}
