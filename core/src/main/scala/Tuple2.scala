

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


final case class Tuple2[v1 <: Any, v2 <: Any](override val _1: v1, override val _2: v2) extends AsProduct2 {
    override type self = Tuple2[v1, v2]

    override type _1 = v1
    override type _2 = v2

    override  def unsing: unsing = scala.Tuple2(_1.unsing, _2.unsing)
    override type unsing         = scala.Tuple2[_1#unsing, _2#unsing]
}
