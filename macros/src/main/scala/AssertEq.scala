

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


/**
 * Asserts that two types refer to the same type.
 */
object AssertEq {
    def apply[x, y]                      : scala.Unit = macro AssertEqImpl.termMacro_[x, y]
    def apply(x: scala.Any, y: scala.Any): scala.Unit = macro AssertEqImpl.termMacro
}


class AssertEqImpl(override val c: Context) extends AssertionMacro2 {
    import c.universe._

    override protected def assertionTypeOnly(x: c.Type, y: c.Type): AssertionResult = {
        if (x =:= y) {
            AssertionSuccess
        } else {
            AssertionFailure(show(x.dealias) + " is required to be equivalent to " + show(y.dealias))
        }
    }
}


/**
 * Asserts that two types refer not to the same type.
 */
object AssertNeq {
    def apply[x, y]            : scala.Unit = macro AssertNeqImpl.termMacro_[x, y]
    def apply[x, y](x: x, y: y): scala.Unit = macro AssertNeqImpl.termMacro
}


class AssertNeqImpl(override val c: Context) extends AssertionMacro2 {
    import c.universe._

    def apply[x, y]            : scala.Unit = macro termMacro_[x, y]
    def apply[x, y](x: x, y: y): scala.Unit = macro termMacro

    override protected def assertionTypeOnly(x: c.Type, y: c.Type): AssertionResult = {
        if (!(x =:= y)) {
            AssertionSuccess
        } else {
            AssertionFailure(show(x.dealias) + " is required not to be equivalent to " + show(y.dealias))
        }
    }
}
