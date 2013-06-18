

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.annotation.elidable
import scala.annotation.elidable.ALL
import scala.language.experimental.macros
import scala.reflect.macros.Context


object Test {

    // scala.Unit is used to suppress a warning.

    /**
     * Ignores an expression, or places a type in term expressions.
     */
    @elidable(ALL)
     def ignore[x](x: x): ignore[x] = ()
    type ignore[x]                  = scala.Unit

    // Typemethod forms don't work correctly in fact.

    /**
     * Asserts that a condition is true.
     */
    @elidable(ALL)
     def assertTrue[x >: `true` <: `true`](implicit x: x = dummy[x]): assertTrue[`true`] = () // implicit for `assertTrue[x]` to be well-formed.
    type assertTrue[x >: `true` <: `true`]                                               = scala.Unit

    /**
     * Asserts that a condition is false.
     */
    @elidable(ALL)
     def assertFalse[x >: `false` <: `false`](implicit x: x = dummy[x]): assertFalse[`false`] = ()
    type assertFalse[x >: `false` <: `false`]                                                 = scala.Unit
/*
    /**
     * Asserts that a type is Nothing.
     */
    @elidable(ALL)
     def assertNothing[x >: Nothing <: Nothing](implicit x: x = dummy[x]): assertNothing[x] = ()
    type assertNothing[x >: Nothing <: Nothing]                                             = scala.Unit

    /**
     * Asserts that a type isn't Nothing.
     */
     def assertNotNothing[x]: scala.Unit       = macro makro.AssertNotNothing.term_impl_[x]
     def assertNotNothing[x](x: x): scala.Unit = macro makro.AssertNotNothing.term_impl[x]
    type assertNotNothing[x]                   = macro makro.AssertNotNothing.type_impl[x]
*/
    /**
     * Asserts that two types refer to the same type.
     */
    @elidable(ALL)
     def assertSame[x >: y <: y, y](implicit x: x = dummy[x], y: y = dummy[y]): assertSame[x, y] = ()
    type assertSame[x >: y <: y, y]                                                                = scala.Unit

    /**
     * Asserts that two types don't refer to the same type.
     */
    def assertNotSame[x, y]: scala.Unit             = macro makro.AssertNotSame.term_impl_[x, y]
    def assertNotSame[x, y](x: x, y: y): scala.Unit = macro makro.AssertNotSame.term_impl[x, y]
   type assertNotSame[x, y]                         = macro makro.AssertNotSame.type_impl[x, y]

    /**
     * Asserts that <code>x</code> conforms to <code>y</code>.
     */
    @elidable(ALL)
     def assertConforms[x <: y, y](implicit x: x = dummy[x], y: y = dummy[y]): assertConforms[x, y] = Unit
    type assertConforms[x <: y, y]                                                                  = Unit

    /**
     * Asserts that <code>x</code> doesn't conform to <code>y</code>.
     */
     def assertNotConforms[x, y]: scala.Unit             = macro makro.AssertNotConforms.term_impl_[x, y]
     def assertNotConforms[x, y](x: x, y: y): scala.Unit = macro makro.AssertNotConforms.term_impl[x, y]
    type assertNotConforms[x, y]                         = macro makro.AssertNotConforms.type_impl[x, y]

    /**
     * Compile-error (any usecase?)
     */
     def error: scala.Unit = macro makro.Error.type_impl
    type error             = macro makro.Error.term_impl

    /**
     * Expects a compile-error.
     */
    def expectError(x: _): scala.Unit = macro makro.ExpectError.impl

    /**
     * Prints a type name.
     */
     def echo[x]: scala.Unit       = macro makro.Echo.term_impl_[x]
     def echo[x](x: x): scala.Unit = macro makro.Echo.term_impl[x]
    type echo[x]                   = macro makro.Echo.type_impl[x]
}
