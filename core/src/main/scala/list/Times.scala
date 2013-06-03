

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package list


/* too slow to compile.
private[sing]
final class Times[xs <: List, n <: Nat](xs: xs, n: n) {
     def apply = repeat(Unit).take(n).flatMap(new Const)
    type apply = repeat[Unit]#take[n]#flatMap[    Const]

    class Const extends AsFunction1 {
        override type self = Const
        override  def apply[x <: Any](x: x): apply[x] = xs
        override type apply[x <: Any]                 = xs
    }
}
*/


private[sing]
object Times {
     def apply[xs <: List, n <: Nat](xs: xs, n: n): apply[xs, n] = Impl(xs, n)
    type apply[xs <: List, n <: Nat]                             = Impl[xs, n]

    case class Impl[xs <: List, n <: Nat](xs: xs, n: n) extends AsList {
        override type self = Impl[xs, n]

        override  def isEmpty: isEmpty = xs.isEmpty.or(n.isZero)
        override type isEmpty          = xs#isEmpty#or[n#isZero]

        override  def head: head = xs.head
        override type head       = xs#head

        override  def tail: tail = xs.tail.append(Impl(xs, n.decrement))
        override type tail       = xs#tail#append[Impl[xs, n#decrement]]
    }
}
