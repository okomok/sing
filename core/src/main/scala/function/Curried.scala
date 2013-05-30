

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package function


private[sing]
object Curried2 {

    final case class Impl[f <: Function2](f: f) extends Function1 {
        type self = Impl[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = Bind1(f, v1)
        override type apply[v1 <: Any]                    = Bind1[f, v1]
    }

    final case class Bind1[f <: Function2, v1 <: Any](f: f, v1: v1) extends Function1 {
        type self = Bind1[f, v1]
        override  def apply[v2 <: Any](v2: v2): apply[v2] = f.apply(v1, v2)
        override type apply[v2 <: Any]                    = f#apply[v1, v2]
    }

}


private[sing]
object Curried3 {

    final case class Impl[f <: Function3](f: f) extends Function1 {
        type self = Impl[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] = Bind1(f, v1)
        override type apply[v1 <: Any]                    = Bind1[f, v1]
    }

    final case class Bind1[f <: Function3, v1 <: Any](f: f, v1: v1) extends Function1 {
        type self = Bind1[f, v1]
        override  def apply[v2 <: Any](v2: v2): apply[v2] = Bind2(f, v1, v2)
        override type apply[v2 <: Any]                    = Bind2[f, v1, v2]
    }

    final case class Bind2[f <: Function3, v1 <: Any, v2 <: Any](f: f, v1: v1, v2: v2) extends Function1 {
        type self = Bind2[f, v1, v2]
        override  def apply[v3 <: Any](v3: v3): apply[v3] = f.apply(v1, v2, v3)
        override type apply[v3 <: Any]                    = f#apply[v1, v2, v3]
    }

}
