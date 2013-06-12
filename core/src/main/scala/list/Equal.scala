

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object Equal {
     def apply[xs <: List, ys <: List, ee <: Option](xs: xs, ys: ys, ee: ee): apply[xs, ys, ee] =
        `if`(xs.isEmpty.and(ys.isEmpty), Const(`true`), `if`(xs.isEmpty.nequal(ys.isEmpty), Const(`false`), Else(xs, ys, ee))).apply.asBoolean.asInstanceOf[apply[xs, ys, ee]]
    type apply[xs <: List, ys <: List, ee <: Option] =
        `if`[xs#isEmpty#and[ys#isEmpty], Const[`true`], `if`[xs#isEmpty#nequal[ys#isEmpty], Const[`false`], Else[xs, ys, ee]]]#apply#asBoolean

    case class Else[xs <: List, ys <: List, ee <: Option](xs: xs, ys: ys, ee: ee) extends AsFunction0 {
        override type self = Else[xs, ys, ee]
        private[this] lazy val _ee: _ee = ee.getOrNaturalEquiv(xs.head)
        private[this]     type _ee      = ee#getOrNaturalEquiv[xs#head]
        override  def apply: apply = `if`(_ee.equiv(xs.head, ys.head), Then(xs, ys, ee), Const(`false`)).apply.asInstanceOf[apply]
        override type apply        = `if`[_ee#equiv[xs#head, ys#head], Then[xs, ys, ee], Const[`false`]]#apply
    }

    case class Then[xs <: List, ys <: List, ee <: Option](xs: xs, ys: ys, ee: ee) extends AsFunction0 {
        override type self = Then[xs, ys, ee]
        override  def apply: apply = Equal.apply(xs.tail, ys.tail, ee)//.asInstanceOf[apply]
        override type apply        = Equal.apply[xs#tail, ys#tail, ee]
    }
}
