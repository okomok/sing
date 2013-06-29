

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
     * Asserts that a condition is true. `c` represents "Concrete".
     */
    @elidable(ALL) // implicit for `cassert[x]` to be well-formed.
     def cassert[x >: `true` <: `true`](implicit x: x = dummy[x]): cassert[x] = ()
    type cassert[x >: `true` <: `true`]                                       = scala.Unit

    /**
     * Asserts that a condition is false.
     */
    @elidable(ALL)
     def cassertNot[x >: `false` <: `false`](implicit x: x = dummy[x]): cassertNot[x] = ()
    type cassertNot[x >: `false` <: `false`]                                          = scala.Unit

    /**
     * Asserts that two types refer to the same type.
     */
    @elidable(ALL)
     def cassertEq[x, y]: scala.Unit             = macro makro.AssertEq.term_impl_[x, y]
     def cassertEq[x, y](x: x, y: y): scala.Unit = macro makro.AssertEq.term_impl[x, y]
    type cassertEq[x, y]                         = macro makro.AssertEq.type_impl[x, y]

    /**
     * Asserts that <code>x</code> conforms to <code>y</code>.
     */
    @elidable(ALL)
     def cassertConforms[x, y]: scala.Unit             = macro makro.AssertConforms.term_impl_[x, y]
     def cassertConforms[x, y](x: x, y: y): scala.Unit = macro makro.AssertConforms.term_impl[x, y]
    type cassertConforms[x, y]                         = macro makro.AssertConforms.type_impl[x, y]

    /**
     * Asserts that <code>x</code> is <code>Nothing</code> type.
     */
    @elidable(ALL)
     def cassertNothing[x >: Nothing <: Nothing](implicit x: x = dummy[x]): cassertNothing[x] = ()
    type cassertNothing[x >: Nothing <: Nothing]                                              = scala.Unit

     def conforms[x, y](x: x, y: y) = macro makro.Conforms.term_impl[x, y]
    type conforms[x, y]             = macro makro.Conforms.type_impl[x, y]

     def isEq[x, y](x: x, y: y) = macro makro.IsEq.term_impl[x, y]
    type isEq[x, y]             = macro makro.IsEq.type_impl[x, y]

    /**
     * Compile-error (any usecase?)
     */
     def error: scala.Unit = macro makro.Error.term_impl
    type error             = macro makro.Error.type_impl

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
