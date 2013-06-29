

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

    /**
     * Asserts that a condition is true. `c` represents "Concrete".
     */
     def cassert[x]: scala.Unit       = macro CAssert.term_impl_[x]
     def cassert[x](x: x): scala.Unit = macro CAssert.term_impl[x]
    type cassert[x]                   = macro CAssert.type_impl[x]

    private object CAssert extends makro.Assert1Impl {
        override protected def impl(c: Context)(x: c.Type): scala.Unit = {
            import c.universe._
            if (!(x =:= weakTypeOf[`true`])) {
                c.abort(c.enclosingPosition, show(x.normalize) + " is not `true`")
            }
        }
    }

    /**
     * Asserts that a condition is false.
     */
     def cassertNot[x]: scala.Unit       = macro CAssertNot.term_impl_[x]
     def cassertNot[x](x: x): scala.Unit = macro CAssertNot.term_impl[x]
    type cassertNot[x]                   = macro CAssertNot.type_impl[x]

    private object CAssertNot extends makro.Assert1Impl {
        override protected def impl(c: Context)(x: c.Type): scala.Unit = {
            import c.universe._
            if (!(x =:= weakTypeOf[`false`])) {
                c.abort(c.enclosingPosition, show(x.normalize) + " is not `false`")
            }
        }
    }

    /**
     * Asserts that two types refer to the same type.
     */
     def cassertEq[x, y]: scala.Unit             = macro makro.AssertEq.term_impl_[x, y]
     def cassertEq[x, y](x: x, y: y): scala.Unit = macro makro.AssertEq.term_impl[x, y]
    type cassertEq[x, y]                         = macro makro.AssertEq.type_impl[x, y]

    /**
     * Asserts that <code>x</code> conforms to <code>y</code>.
     */
     def cassertConforms[x, y]: scala.Unit             = macro makro.AssertConforms.term_impl_[x, y]
     def cassertConforms[x, y](x: x, y: y): scala.Unit = macro makro.AssertConforms.term_impl[x, y]
    type cassertConforms[x, y]                         = macro makro.AssertConforms.type_impl[x, y]

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
