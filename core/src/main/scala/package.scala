

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok


import scala.annotation.elidable
import scala.annotation.elidable.ASSERTION
import scala.language.experimental.macros


package object sing {


    import Annotation._
    import makro.Unspecified


// Boolean

     val `true`: `true` = _TermOfTrue.apply
     val `false`: `false` = _TermOfFalse.apply

    @equivalentTo("c.`if`(_then, _else)")
     def `if`[c <: Boolean, _then <: Function0, _else <: Function0](c: c, _then: _then, _else: _else): `if`[c, _then, _else] = c.`if`(_then, _else)
    type `if`[c <: Boolean, _then <: Function0, _else <: Function0]                                                          = c#`if`[_then, _else]


// Function

    val Identity: Identity = _TermOfIdentity.apply


// List

    val Nil: Nil = _TermOfNil.apply

     val :: = Cons
    type ::[x <: Any, xs <: List] = xs# ::[x]


// Nat

    val Nat_ = makro.DenseLiteral


// Dense

    val DNil: DNil = _TermOfDNil.apply

     val D_:: = DCons
    type D_::[b <: Boolean, bs <: Dense] = bs# D_::[b]

    val Dense_ = makro.DenseLiteral
    val Binary_ = makro.BinaryLiteral


// Peano

    val Zero: Zero = _TermOfZero.apply

    val Peano_ = makro.PeanoLiteral


// Option

    val None: None = _TermOfNone.apply


// Ordering

    val LT: LT = _TermOfLT.apply
    val GT: GT = _TermOfGT.apply
    val EQ: EQ = _TermOfEQ.apply


// Product

    @aliasOf("Tuple2")
     val Pair = Tuple2
    type Pair[v1 <: Any, v2 <: Any] = Tuple2[v1, v2]


// Unit

    @equivalentTo("new Unit{}")
    val Unit: Unit = _TermOfUnit.apply


// misc

    /**
     * Keeps methods from being dependent.
     */
    @inline
     def id[x](x: x): x = x
    type id[x]          = x

    /**
     * The type of a term
     */
    val typeOf = makro.WeakTypeOf

    /**
     * The term of a type
     */
    def termOf[x <: Any](implicit _x: _TermOf[x]): x = _x.apply

    /**
     * A sort of `declval` in C++
     */
    def dummy[x]: x = null.asInstanceOf[x]

    /**
     * Checks a type concrete, compile-error otherwise.
     */
    def check(x: Unspecified): Unspecified = macro makro.Check.term_impl

    @equivalentTo("AsT with Self")
    type New = makro.New


// assertions

    /**
     * assertion (typemethod is not implemented yet.)
     */
    @elidable(ASSERTION)
     def assert[c <: Boolean](c: c): assert[c] = Assert.apply(c)
    type assert[c <: Boolean]                  = Assert.apply[c]

    @elidable(ASSERTION)
    @equivalentTo("assert(c.not)")
     def assertNot[c <: Boolean](c: c): assertNot[c] = assert(c.not)
    type assertNot[c <: Boolean]                     = assert[c#not]

}
