

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


final case class Tuple1[v1 <: Any](override val _1: v1) extends Product1Impl {
    type self = Tuple1[v1]

    override type _1 = v1

    override  def unsing: unsing = scala.Tuple1(_1.unsing)
    override type unsing         = scala.Tuple1[_1#unsing]
}
