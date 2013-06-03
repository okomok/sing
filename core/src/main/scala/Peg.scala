

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import peg._


object Peg extends AsPegKind {

    /**
     * Epsilon, the empty string
     */
     val eps: eps = new Eps
    type eps      =     Eps

    /**
     * Always fails.
     */
     val fail: fail = new Fail
    type fail       =     Fail

    /**
     * Always throws.
     */
     val error: error = new Error
    type error        =     Error

    /**
     * Terminal
     */
     def term[y <: Any](y: y): term[y] = Term.apply(y)
    type term[y <: Any]                = Term.apply[y]

    /**
     * Dot, which matches any character.
     */
     val dot: dot = Dot.apply
    type dot      = Dot.apply

    /**
     * Matches only the given list.
     */
     def fromList[ys <: List](ys: ys): fromList[ys] = FromList.apply(ys)
    type fromList[ys <: List]                       = FromList.apply[ys]
}


trait Peg extends Any with ReferenceEquality {
    type self <: Peg

    /**
     * The parse method
     */
     def parse[xs <: List](xs: xs): parse[xs]
    type parse[xs <: List] <: PegResult

    /**
     * Returns a mathced width.
     */
     def width: width = unsupported("Peg.width is not constant.")
    type width <: Nat

    /**
     * Sequence
     */
     def seq[that <: Peg](that: that): seq[that]
    type seq[that <: Peg] <: Peg

    /**
     * Ordered choice
     */
     def or[that <: Peg](that: that): or[that]
    type or[that <: Peg] <: Peg

    /**
     * Zero-or-more
     */
     def star: star
    type star <: Peg

    /**
     * One-or-more
     */
     def plus: plus
    type plus <: Peg

    /**
     * Optional
     */
     def opt: opt
    type opt <: Peg

    /**
     * And-predicate
     */
     def and: and
    type and <: Peg

    /**
     * Not-predicate
     */
     def not: not
    type not <: Peg

    /**
     * Repeats at least n and at most m
     */
     def repeat[n <: Nat, m <: Nat](n: n, m: m): repeat[n, m]
    type repeat[n <: Nat, m <: Nat] <: Peg

    /**
     * Associates a semantic action.
     */
     def map[f <: Function1](f: f): map[f]
    type map[f <: Function1] <: Peg

    /**
     * Returns true iif full match.
     */
     def matches[xs <: List](xs: xs): matches[xs]
    type matches[xs <: List] <: Boolean
}
