

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.annotation.elidable
import scala.annotation.elidable.ALL
import scala.language.experimental.macros
import scala.reflect.macros.Context


import _test._


object Test {
    // Unit is used to suppress a warning.
    import scala.Unit

    /**
     * Places a type in term expressions.
     */
    def place[x]: Unit = ()

    /**
     * Asserts that a condition is true. `c` represents "Concrete".
     */
     def assertTrue[x]: Unit       = macro AssertTrue.term_impl_[x]
     def assertTrue[x](x: x): Unit = macro AssertTrue.term_impl[x]
    type assertTrue[x]             = macro AssertTrue.type_impl[x]

    /**
     * Asserts that a condition is false.
     */
     def assertFalse[x]: Unit       = macro AssertFalse.term_impl_[x]
     def assertFalse[x](x: x): Unit = macro AssertFalse.term_impl[x]
    type assertFalse[x]             = macro AssertFalse.type_impl[x]

    /**
     * Asserts that two types refer to the same type.
     */
     def assertEq[x, y]: Unit             = macro makro.AssertEq.term_impl_[x, y]
     def assertEq[x, y](x: x, y: y): Unit = macro makro.AssertEq.term_impl[x, y]
    type assertEq[x, y]                   = macro makro.AssertEq.type_impl[x, y]

    /**
     * Asserts that two types refer not to the same type.
     */
     def assertNeq[x, y]: Unit             = macro makro.AssertNeq.term_impl_[x, y]
     def assertNeq[x, y](x: x, y: y): Unit = macro makro.AssertNeq.term_impl[x, y]
    type assertNeq[x, y]                   = macro makro.AssertNeq.type_impl[x, y]

    /**
     * Asserts that <code>x</code> conforms to <code>y</code>.
     */
     def assertConforms[x, y]: Unit             = macro makro.AssertConforms.term_impl_[x, y]
     def assertConforms[x, y](x: x, y: y): Unit = macro makro.AssertConforms.term_impl[x, y]
    type assertConforms[x, y]                   = macro makro.AssertConforms.type_impl[x, y]

    /**
     * Asserts that <code>x.equal(y)</code>.
     */
     def assertEqual[x, y]: Unit             = macro AssertEqual.term_impl_[x, y]
     def assertEqual[x, y](x: x, y: y): Unit = macro AssertEqual.term_impl[x, y]
    type assertEqual[x, y]                   = macro AssertEqual.type_impl[x, y]

    /**
     * Asserts that <code>x.nequal(y)</code>.
     */
     def assertNequal[x, y]: Unit             = macro AssertNequal.term_impl_[x, y]
     def assertNequal[x, y](x: x, y: y): Unit = macro AssertNequal.term_impl[x, y]
    type assertNequal[x, y]                   = macro AssertNequal.type_impl[x, y]

    /**
     * Compile-error (any usecase?)
     */
     def error: Unit = macro makro.Error.term_impl
    type error       = macro makro.Error.type_impl

    /**
     * Expects a compile-error.
     */
    def expectError(r: String)(x: _): Unit = macro makro.ExpectError.impl

    /**
     * Compile-error codes
     */
    val CompileError = makro.CompileError

    /**
     * Prints a type name.
     */
     def echo[x]: Unit       = macro makro.Echo.term_impl_[x]
     def echo[x](x: x): Unit = macro makro.Echo.term_impl[x]
    type echo[x]             = macro makro.Echo.type_impl[x]

    /**
     * @return `true` if x conforms to y. `false` otherwise.
     */
     def conforms[x, y](x: x, y: y) = macro makro.Conforms.term_impl[x, y]
    type conforms[x, y]             = macro makro.Conforms.type_impl[x, y]

    /**
     * @return `true` if x is equivalent to y. `false` otherwise.
     */
     def isEq[x, y](x: x, y: y) = macro makro.IsEq.term_impl[x, y]
    type isEq[x, y]             = macro makro.IsEq.type_impl[x, y]
}
