

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


final case class Tuple1[v1 <: Any](override val _1: v1) extends AbstractProduct1 {
    type self = Tuple1[v1]

    override type _1 = v1

    override  def unsung: unsung = scala.Tuple1(_1.unsung)
    override type unsung         = scala.Tuple1[_1#unsung]
}
