

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
final class Fail extends AsPeg with ZeroWidth {
    override type self = Fail

    override  def parse[xs <: List](xs: xs): parse[xs] = PegFailure(xs)
    override type parse[xs <: List]                    = PegFailure[xs]
}
