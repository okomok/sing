

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import peg._


trait AbstractPeg extends Peg {
    final override  def asPeg: asPeg = self
    final override type asPeg        = self

    final override  def seq[that <: Peg](that: that): seq[that] = Seq.apply(self, that)
    final override type seq[that <: Peg]                        = Seq.apply[self, that]

    final override  def or[that <: Peg](that: that): or[that] = Or.apply(self, that)
    final override type or[that <: Peg]                       = Or.apply[self, that]

    final override  def star: star = Star.apply(self)
    final override type star       = Star.apply[self]

    final override  def plus: plus = Plus.apply(self)
    final override type plus       = Plus.apply[self]

    final override  def opt: opt = Opt.apply(self)
    final override type opt      = Opt.apply[self]

    final override  def and: and = And.apply(self)
    final override type and      = And.apply[self]

    final override  def not: not = Not.apply(self)
    final override type not      = Not.apply[self]

    final override  def repeat[n <: Nat, m <: Nat](n: n, m: m): repeat[n, m] = Repeat.apply(self, n, m)
    final override type repeat[n <: Nat, m <: Nat]                           = Repeat.apply[self, n, m]

    final override  def map[f <: Function1](f: f): map[f] = Map.apply(self, f)
    final override type map[f <: Function1]               = Map.apply[self, f]

    final override  def matches[xs <: List](xs: xs): matches[xs] = Matches.apply(self, xs)
    final override type matches[xs <: List]                      = Matches.apply[self, xs]
}

