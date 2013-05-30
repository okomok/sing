

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


abstract class Strong[p <: Peg](p: p) extends AbstractPeg {
    override  def parse[xs <: List](xs: xs): parse[xs] = p.parse(xs)
    override type parse[xs <: List]                    = p#parse[xs]
    override  def width: width = p.width
    override type width        = p#width
}
