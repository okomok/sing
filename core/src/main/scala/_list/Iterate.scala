

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _list


private[sing]
object Iterate {
     def apply[z <: Any, f <: Function1](z: z, f: f): apply[z, f] = List.unfoldRight(z, Iter(f))
    type apply[z <: Any, f <: Function1]                          = List.unfoldRight[z, Iter[f]]

    case class Iter[f <: Function1](f: f) extends AsFunction1 {
        override type self = Iter[f]
        override  def apply[x <: Any](x: x): apply[x] = Some(Tuple2(x, f.apply(x)))
        override type apply[x <: Any]                 = Some[Tuple2[x, f#apply[x]]]
    }
}
