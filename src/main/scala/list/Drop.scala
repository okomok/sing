

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package list


private[sing]
object Drop {
     def apply[xs <: List, n <: Nat](xs: xs, n: n) =
        `if`(xs.isEmpty.or(n.isZero), const0(xs), Else(xs, n)).apply.asList.asInstanceOf[apply[xs, n]]
    type apply[xs <: List, n <: Nat] =
        `if`[xs#isEmpty#or[n#isZero], const0[xs], Else[xs, n]]#apply#asList

    case class Else[xs <: List, n <: Nat](xs: xs, n: n) extends Function0 {
        type self = Else[xs, n]
        override  def apply: apply = Drop.apply(xs.tail, n.decrement)
        override type apply        = Drop.apply[xs#tail, n#decrement]
    }
}


private[sing]
object DropWhile {
     def apply[xs <: List, f <: Function1](xs: xs, f: f): apply[xs, f] =
        `if`(xs.isEmpty, const0(xs), Else(xs, f)).apply.asList
    type apply[xs <: List, f <: Function1] =
        `if`[xs#isEmpty, const0[xs], Else[xs, f]]#apply#asList

    case class Else[xs <: List, f <: Function1](xs: xs, f: f) extends Function0 {
        type self = Else[xs, f]
        override  def apply: apply = `if`(f.apply(xs.head).asBoolean, ElseThen(xs, f), const0(xs)).apply.asInstanceOf[apply]
        override type apply        = `if`[f#apply[xs#head]#asBoolean, ElseThen[xs, f], const0[xs]]#apply
    }

    case class ElseThen[xs <: List, f <: Function1](xs: xs, f: f) extends Function0 {
        type self = ElseThen[xs, f]
        override  def apply: apply = DropWhile.apply(xs.tail, f)
        override type apply        = DropWhile.apply[xs#tail, f]
    }
}
