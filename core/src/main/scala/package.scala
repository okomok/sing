

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok


import scala.annotation.elidable
import scala.annotation.elidable.ASSERTION
import scala.language.experimental.macros


package object sing {


    type `null` = scala.Nothing


// Boolean

     val `true`: `true` = _TermOfTrue.apply
     val `false`: `false` = _TermOfFalse.apply

    @Annotation.equivalentTo("c.`if`(_then, _else)")
     def `if`[c <: Boolean, _then <: Function0, _else <: Function0](c: c, _then: _then, _else: _else): `if`[c, _then, _else] = c.`if`(_then, _else)
    type `if`[c <: Boolean, _then <: Function0, _else <: Function0]                                                          = c#`if`[_then, _else]


// Function

    @Annotation.aliasOf("Function.const0")
     def const0[v <: Any](v: => v): const0[v] = Function.const0(v)
    type const0[v <: Any]                     = Function.const0[v]

    @Annotation.aliasOf("Function.throw0")
     def throw0(x: Throwable) = Function.throw0(x)
    type throw0[_]            = Function.throw0[_]


// List

    val Nil: Nil = _TermOfNil.apply

    @Annotation.aliasOf("Cons")
    val :: = Cons

    @Annotation.equivalentTo("x# ::[xs]")
    type ::[x <: Any, xs <: List] = xs# ::[x]


// Dense

    val DNil: DNil = _TermOfDNil.apply


// Peano

    val Zero: Zero = _TermOfZero.apply


// Option

    val None: None = _TermOfNone.apply


// Ordering

    val LT: LT = _TermOfLT.apply
    val GT: GT = _TermOfGT.apply
    val EQ: EQ = _TermOfEQ.apply


// Product

    @Annotation.aliasOf("Tuple2")
     val Pair = Tuple2
    type Pair[v1 <: Any, v2 <: Any] = Tuple2[v1, v2]


// Unit

    @Annotation.equivalentTo("new Unit{}")
    val Unit: Unit = _TermOfUnit.apply


// misc

    @Annotation.equivalentTo("AsT with Self")
    type New[T] = macro makro.New.impl[T]

    /**
     * The type of a term
     */
    type typeOf[x](x: x) = macro makro.WeakTypeOf.impl[x]

    /**
     * The term of a type
     */
    def termOf[x <: Any](implicit _x: _TermOf[x]): x = _x.apply

    /**
     * A sort of `declval` in C++
     */
    def unused[x] = null.asInstanceOf[x]

    /**
     * Checks a type concrete, compile-error otherwise.
     */
     def check[x](x: x) = macro makro.Check.term_impl[x]
    type check[x]       = macro makro.Check.type_impl[x]


// assertions

    /**
     * assertion (typemethod is not implemented yet.)
     */
    @elidable(ASSERTION)
     def assert[c <: Boolean](c: c): assert[c] = Assert.apply(c)
    type assert[c <: Boolean]                  = Assert.apply[c]

    @elidable(ASSERTION)
    @Annotation.equivalentTo("assert(c.not)")
     def assertNot[c <: Boolean](c: c): assertNot[c] = assert(c.not)
    type assertNot[c <: Boolean]                     = assert[c#not]

}
