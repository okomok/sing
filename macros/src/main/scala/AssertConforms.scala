

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


/**
 * Asserts that <code>x</code> conforms to <code>y</code>.
 */
object AssertConforms {
    def apply[x, y]                      : scala.Unit = macro AssertConformsImpl.termMacro_[x, y]
    def apply(x: scala.Any, y: scala.Any): scala.Unit = macro AssertConformsImpl.termMacro
}


class AssertConformsImpl(override val c: Context) extends AssertionMacro2 {
    import c.universe._

    final override protected def assertionTypeOnly(x: c.Type, y: c.Type): AssertionResult = {
        if (x <:< y) {
            AssertionSuccess
        } else {
            AssertionFailure(show(x.dealias) + " does not conform to " + show(y.dealias))
        }
    }
}
