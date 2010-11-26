

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


final case class Tuple3[v1 <: Any, v2 <: Any, v3 <: Any](override val _1: v1, override val _2: v2, override val _3: v3) extends AbstractProduct3 {
    type self = Tuple3[v1, v2, v3]

    override type _1 = v1
    override type _2 = v2
    override type _3 = v3

    override  def unsing: unsing = scala.Tuple3(_1.unsing, _2.unsing, _3.unsing)
    override type unsing         = scala.Tuple3[_1#unsing, _2#unsing, _3#unsing]
}
