

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.language.experimental.macros


import _test._


object Test {
    // scala.Unit is used to suppress a warning.
    import scala.Unit
    import makro.Unspecified

    /**
     * Places a type in term expressions.
     */
    def place[x]: Unit = ()

    /**
     * Asserts that a condition is true. `c` represents "Concrete".
     */
    def assertTrue[x]      : Unit = macro AssertTrue.term_impl_[x]
    def assertTrue[x](x: x): Unit = macro AssertTrue.term_impl[x]

    /**
     * Asserts that a condition is false.
     */
    def assertFalse[x]      : Unit = macro AssertFalse.term_impl_[x]
    def assertFalse[x](x: x): Unit = macro AssertFalse.term_impl[x]

    /**
     * Asserts that two types refer to the same type.
     */
    def assertEq[x, y]            : Unit = macro makro.AssertEq.term_impl_[x, y]
    def assertEq[x, y](x: x, y: y): Unit = macro makro.AssertEq.term_impl[x, y]

    /**
     * Asserts that two types refer not to the same type.
     */
    def assertNeq[x, y]            : Unit = macro makro.AssertNeq.term_impl_[x, y]
    def assertNeq[x, y](x: x, y: y): Unit = macro makro.AssertNeq.term_impl[x, y]

    /**
     * Asserts that <code>x</code> conforms to <code>y</code>.
     */
    def assertConforms[x, y]            : Unit = macro makro.AssertConforms.term_impl_[x, y]
    def assertConforms[x, y](x: x, y: y): Unit = macro makro.AssertConforms.term_impl[x, y]

    /**
     * Asserts that <code>x.equal(y)</code>.
     */
    def assertEqual[x, y]            : Unit = macro AssertEqual.term_impl_[x, y]
    def assertEqual[x, y](x: x, y: y): Unit = macro AssertEqual.term_impl[x, y]

    /**
     * Asserts that <code>x.nequal(y)</code>.
     */
    def assertNequal[x, y]            : Unit = macro AssertNequal.term_impl_[x, y]
    def assertNequal[x, y](x: x, y: y): Unit = macro AssertNequal.term_impl[x, y]

    /**
     * Compile-error (any usecase?)
     */
    def error: Unit = macro makro.Error.term_impl

    /**
     * Expects a compile-error.
     */
    def expectError(r: String)(x: String): Unit = macro makro.ExpectError.impl

    /**
     * Compile-error codes
     */
    val CompileError = makro.CompileError

    /**
     * Prints a type name.
     */
    def echo[x]      : Unit = macro makro.Echo.term_impl_[x]
    def echo[x](x: x): Unit = macro makro.Echo.term_impl[x]

    /**
     * Prints a raw type name.
     */
    def echoRaw[x]      : Unit = macro makro.EchoRaw.term_impl_[x]
    def echoRaw[x](x: x): Unit = macro makro.EchoRaw.term_impl[x]

    /**
     * @return `true` if x conforms to y. `false` otherwise.
     */
    def conforms[x, y]            : Unspecified = macro makro.Conforms.term_impl_[x, y]
    def conforms[x, y](x: x, y: y): Unspecified = macro makro.Conforms.term_impl[x, y]

    /**
     * @return `true` if x is equivalent to y. `false` otherwise.
     */
    def isEq[x, y]            : Unspecified = macro makro.IsEq.term_impl_[x, y]
    def isEq[x, y](x: x, y: y): Unspecified = macro makro.IsEq.term_impl[x, y]
}
