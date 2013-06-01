

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok


import scala.annotation.elidable
import scala.annotation.elidable.ASSERTION


package object sing {


// Boolean

    @Annotation.equivalentTo("new `true`{}")
     val `true` = _Boolean.`true`

    @Annotation.equivalentTo("new `false`{}")
     val `false` = _Boolean.`false`

    @Annotation.equivalentTo("c.`if`(_then, _else)")
     def `if`[c <: Boolean, _then <: Function0, _else <: Function0](c: c, _then: _then, _else: _else): `if`[c, _then, _else] = c.`if`(_then, _else)
    type `if`[c <: Boolean, _then <: Function0, _else <: Function0]                                                       = c#`if`[_then, _else]


// Function

    @Annotation.aliasOf("Function.const0")
     def const0[v <: Any](v: => v): const0[v] = Function.const0(v)
    type const0[v <: Any]                     = Function.const0[v]

    @Annotation.aliasOf("Function.throw0")
     def throw0(x: Throwable) = Function.throw0(x)
    type throw0[_]            = Function.throw0[_]


// List

    @Annotation.equivalentTo("new Nil{}")
     val Nil: Nil = new Nil{}

    @Annotation.aliasOf("Cons")
     val :: = Cons
    type ::[x <: Any, xs <: List] = Cons[x, xs]


// Nat

    @Annotation.aliasOf("nat.Nat")
     val Nat = nat.Nat
    type Nat = nat.Nat


// Option

    @Annotation.equivalentTo("new None{}")
     val None: None = new None{}


// Peg

    @Annotation.aliasOf("peg.Peg")
     val Peg = peg.Peg
    type Peg = peg.Peg


// Product

    @Annotation.aliasOf("Tuple2")
     val Pair = Tuple2
    type Pair[v1 <: Any, v2 <: Any] = Tuple2[v1, v2]


// Unit

    @Annotation.equivalentTo("new Unit{}")
     val Unit: Unit = new Unit{}


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
