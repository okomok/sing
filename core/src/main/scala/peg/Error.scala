

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package peg


private[sing]
final class Error extends AsPeg with ZeroWidth {
    override type self = Error

    override  def parse[xs <: List](xs: xs): parse[xs] = throw new ParseError(xs.unsing.toString)
//    override type parse[xs <: List]                    = Nothing
}

final case class ParseError(input: String) extends java.lang.Error
