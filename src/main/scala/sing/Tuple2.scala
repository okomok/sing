

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


final case class Tuple2[v1 <: Any, v2 <: Any](override val _1: v1, override val _2: v2) extends AbstractProduct2 {
    type self = Tuple2[v1, v2]

    override type _1 = v1
    override type _2 = v2

    override  def unsing: unsing = scala.Tuple2(_1.unsing, _2.unsing)
    override type unsing         = scala.Tuple2[_1#unsing, _2#unsing]
}
