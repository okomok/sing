

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _list


// No bounds-checking for infinite lists
private[sing]
object Nth {
     def apply[xs <: List, n <: Nat](xs: xs, n: n): apply[xs, n] = Impl(xs, n).apply
/*
        `if`(id(n).lt(id(xs).length),
            Impl(xs, n),
            Throw(new IndexOutOfBoundsException(n.toString))
         ).apply
*/
    type apply[xs <: List, n <: Nat] =                             Impl[xs, n]#apply
/*
        `if`[id[n]#lt[id[xs]#length],
            Impl[xs, n],
            Throw
         ]#apply
*/
    case class Impl[xs <: List, n <: Nat](xs: xs, n: n) extends AsFunction0 {
        override type self = Impl[xs, n]
        override  def apply: apply = `if`(id(n).isZero, Const(id(xs).head), Else(xs, n)).apply
        override type apply        = `if`[id[n]#isZero, Const[id[xs]#head], Else[xs, n]]#apply
    }

    case class Else[xs <: List, n <: Nat](xs: xs, n: n) extends AsFunction0 {
        override type self = Else[xs, n]
        override  def apply: apply = Nth.apply(xs.tail, n.decrement)
        override type apply        = Nth.apply[xs#tail, n#decrement]
    }
}
