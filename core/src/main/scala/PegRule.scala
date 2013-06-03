

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import peg._


/**
 * Helps to build a recursive grammar.
 */
trait PegRule extends AsPeg {
    protected  def rule: rule
    protected type rule <: Peg

    private[this] lazy val p: p = rule.asPeg
    private[this]     type p    = rule#asPeg

    final override  def parse[xs <: List](xs: xs): parse[xs] = p.parse(xs)
    final override type parse[xs <: List]                    = p#parse[xs]

    final override  def width: width = p.width
    final override type width        = p#width
}
