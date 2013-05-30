

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package function


private[sing]
object Compose {

    final case class Impl[f <: Function1, g <: Function1](f: f, g: g) extends Function1 {
        type self = Impl[f, g]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = f.apply(g.apply(v1))
        override type apply[v1 <: Any]                    = f#apply[g#apply[v1]]
    }

}
