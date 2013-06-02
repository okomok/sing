

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
object Map {
     def apply[p <: Peg, f <: Function1](p: p, f: f): apply[p, f] = Impl(p, f)
    type apply[p <: Peg, f <: Function1]                          = Impl[p, f]

    final case class Impl[p <: Peg, f <: Function1](p: p, f: f) extends PegImpl {
        type self = Impl[p, f]

        override  def parse[xs <: List](xs: xs): parse[xs] = p.parse(xs).map(f)
        override type parse[xs <: List]                    = p#parse[xs]#map[f]

        override  def width: width = p.width
        override type width        = p#width
    }
}
