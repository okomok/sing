

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _list


private[sing]
object IsSorted {
     def apply[xs <: List, o <: Option](xs: xs, o: o): apply[xs, o] =
        `if`(HasTwoOrMore.apply(xs), Then(xs, o), Const(`true`)).apply.asBoolean
    type apply[xs <: List, o <: Option] =
        `if`[HasTwoOrMore.apply[xs], Then[xs, o], Const[`true`]]#apply#asBoolean

    case class Then[xs <: List, o <: Option](xs: xs, o: o) extends AsFunction0 {
        override type self = Then[xs, o]
        private[this] lazy val _o: _o = o.getOrNaturalOrdering(xs.head)
        private[this]     type _o     = o#getOrNaturalOrdering[xs#head]
        override  def apply: apply = `if`(id(_o).lt(id(xs).tail.head, id(xs).head), Const(`false`), ThenElse(xs, o)).apply
        override type apply        = `if`[id[_o]#lt[id[xs]#tail#head, id[xs]#head], Const[`false`], ThenElse[xs, o]]#apply
    }

    case class ThenElse[xs <: List, o <: Option](xs: xs, o: o) extends AsFunction0 {
        override type self = ThenElse[xs, o]
        override  def apply: apply = IsSorted.apply(xs.tail, o)
        override type apply        = IsSorted.apply[xs#tail, o]
    }
}
