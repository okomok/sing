

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package function


private[sing]
object Not1 {

    final case class Impl[f <: Function1](f: f) extends Function1 {
        type self = Impl[f]
        override  def apply[v1 <: Any](v1: v1): apply[v1] =
            f.apply(v1).asBoolean.not
        override type apply[v1 <: Any] =
            f#apply[v1]#asBoolean#not
    }

}


private[sing]
object Not2 {

    final case class Impl[f <: Function2](f: f) extends Function2 {
        type self = Impl[f]
        override  def apply[v1 <: Any, v2 <: Any](v1: v1, v2: v2): apply[v1, v2] =
            f.apply(v1, v2).asBoolean.not
        override type apply[v1 <: Any, v2 <: Any] =
            f#apply[v1, v2]#asBoolean#not
    }

}


private[sing]
object Not3 {

    final case class Impl[f <: Function3](f: f) extends Function3 {
        type self = Impl[f]
        override  def apply[v1 <: Any, v2 <: Any, v3 <: Any](v1: v1, v2: v2, v3: v3): apply[v1, v2, v3] =
            f.apply(v1, v2, v3).asBoolean.not
        override type apply[v1 <: Any, v2 <: Any, v3 <: Any] =
            f#apply[v1, v2, v3]#asBoolean#not
    }

}
