

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok


import scala.annotation.elidable
import scala.annotation.elidable.ASSERTION
import scala.language.experimental.macros
import scala.reflect.macros.Context


package object sing {


// Boolean

    @annotation.equivalentTo("new `true`{}")
     val `true` = _Boolean.`true`

    @annotation.equivalentTo("new `false`{}")
     val `false` = _Boolean.`false`

    @annotation.equivalentTo("c.`if`(_then, _else)")
     def `if`[c <: Boolean, _then <: Function0, _else <: Function0](c: c, _then: _then, _else: _else): `if`[c, _then, _else] = c.`if`(_then, _else)
    type `if`[c <: Boolean, _then <: Function0, _else <: Function0]                                                       = c#`if`[_then, _else]


// Function

    @annotation.aliasOf("function.const0")
     def const0[v <: Any](v: => v): const0[v] = function.const0(v)
    type const0[v <: Any]                     = function.const0[v]

    @annotation.aliasOf("function.throw0")
     def throw0(x: Throwable) = function.throw0(x)
    type throw0[_]            = function.throw0[_]


// List

    @annotation.aliasOf("list.List")
     val List = list.List
    type List = list.List

    @annotation.aliasOf("list.Nil")
     val Nil = list.Nil
    type Nil = list.Nil

    @annotation.aliasOf("list.::")
     val :: = list.::
    type ::[x <: Any, xs <: List] = list.::[x, xs]


// Map

    @annotation.aliasOf("map.Map")
     val Map = map.Map
    type Map = map.Map


// Nat

    @annotation.aliasOf("nat.Nat")
     val Nat = nat.Nat
    type Nat = nat.Nat


// Option

    @annotation.equivalentTo("new None{}")
     val None = _Option.None


// Ordering

    @annotation.aliasOf("ordering.Ordering")
     val Ordering = ordering.Ordering
    type Ordering = ordering.Ordering


// Peg

    @annotation.aliasOf("peg.Peg")
     val Peg = peg.Peg
    type Peg = peg.Peg


// Product

    @annotation.aliasOf("Tuple2")
     val Pair = Tuple2
    type Pair[v1 <: Any, v2 <: Any] = Tuple2[v1, v2]


// Set

    @annotation.aliasOf("set.Set")
     val Set = set.Set
    type Set = set.Set


// Unit

    @annotation.equivalentTo("new Unit{}")
    val Unit: Unit = _Unit.value


// assertions

    /**
     * assertion (metamethod is not implemented yet.)
     */
    @elidable(ASSERTION)
     def assert[c <: Boolean](c: c): assert[c] = Assert.apply(c)
    type assert[c <: Boolean]                  = Assert.apply[c]

    @elidable(ASSERTION)
    @annotation.equivalentTo("assert(c.not)")
     def assertNot[c <: Boolean](c: c): assertNot[c] = assert(c.not)
    type assertNot[c <: Boolean]                     = assert[c#not]


// util

    /**
     * Returns corresponding runtime value.
     */
     def unmeta[x <: Any](implicit _unmeta: Unmeta[x]): x = _unmeta.apply


// New

    // type New = macro Macros.NewImpl

}
