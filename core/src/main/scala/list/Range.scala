

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


private[sing]
object Range {
     def apply[n <: Nat, m <: Nat](n: n, m: m): apply[n, m] = Impl(n, m)
    type apply[n <: Nat, m <: Nat]                          = Impl[n, m]

    case class Impl[n <: Nat, m <: Nat](n: n, m: m) extends AsList {
        type self = Impl[n, m]

        override  def isEmpty: isEmpty = n.equal(m)
        override type isEmpty          = n#equal[m]

        override  def head: head = n
        override type head       = n

        override  def tail: tail = Impl(n.increment, m)
        override type tail       = Impl[n#increment, m]
    }
}
