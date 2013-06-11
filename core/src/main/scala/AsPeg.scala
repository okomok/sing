

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import peg._


trait AsPegKind


trait AsPeg extends Peg with AsAny with RefEquals with AsPegKind {
    override  def asPeg: asPeg = self
    override type asPeg        = self

    override  def seq[that <: Peg](that: that): seq[that] = Seq.apply(self, that)
    override type seq[that <: Peg]                        = Seq.apply[self, that]

    override  def or[that <: Peg](that: that): or[that] = Or.apply(self, that)
    override type or[that <: Peg]                       = Or.apply[self, that]

    override  def star: star = Star.apply(self)
    override type star       = Star.apply[self]

    override  def plus: plus = Plus.apply(self)
    override type plus       = Plus.apply[self]

    override  def opt: opt = Opt.apply(self)
    override type opt      = Opt.apply[self]

    override  def and: and = And.apply(self)
    override type and      = And.apply[self]

    override  def not: not = Not.apply(self)
    override type not      = Not.apply[self]

    override  def repeat[n <: Nat, m <: Nat](n: n, m: m): repeat[n, m] = Repeat.apply(self, n, m)
    override type repeat[n <: Nat, m <: Nat]                           = Repeat.apply[self, n, m]

    override  def map[f <: Function1](f: f): map[f] = peg.Map.apply(self, f)
    override type map[f <: Function1]               = peg.Map.apply[self, f]

    override  def matches[xs <: List](xs: xs): matches[xs] = Matches.apply(self, xs)
    override type matches[xs <: List]                      = Matches.apply[self, xs]
}

