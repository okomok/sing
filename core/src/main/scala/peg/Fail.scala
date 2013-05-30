

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
final class Fail extends AbstractPeg with ZeroWidth {
    type self = Fail

    override  def parse[xs <: List](xs: xs): parse[xs] = Failure(xs)
    override type parse[xs <: List]                    = Failure[xs]
}