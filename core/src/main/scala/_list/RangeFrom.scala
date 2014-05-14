

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _list


private[sing]
object RangeFrom {
     def apply[n <: Nat](n: n): apply[n] = List.iterate(n, Iter)
    type apply[n <: Nat]                 = List.iterate[n, Iter]

    sealed abstract class Iter extends AsFunction1 {
        override type self = Iter
        override  def apply[n <: Any](n: n): apply[n] = n.asNat.increment
        override type apply[n <: Any]                 = n#asNat#increment
    }
    lazy val Iter: Iter = new Iter{}

/*
    This implementation makes nullary typemethods concrete, so stack overflows.
    case class Impl[n <: Nat, m <: Nat](n: n, m: m) extends AsList {
        override type self = Impl[n, m]

        override  def isEmpty: isEmpty = `false`
        override type isEmpty          = `false`

        override  def head: head = n
        override type head       = n

        override  def tail: tail = Impl(n.increment)
        override type tail       = Impl[n#increment]
    }
*/
}
