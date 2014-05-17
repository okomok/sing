

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


/**
 * Asserts that a condition is true.
 */
object AssertTrue {
    def apply[x]           : scala.Unit = macro AssertTrueImpl.termMacro_[x]
    def apply(x: scala.Any): scala.Unit = macro AssertTrueImpl.termMacro
}


final class AssertTrueImpl(override val c: Context) extends AssertionMacroImpl1 {
    import c.universe._

    override protected def assertionTypeOnly(x: c.Type): AssertionResult = {
        if (x =:= weakTypeOf[`true`]) {
            AssertionSuccess
        } else {
            AssertionFailure(show(x.dealias) + " required to be `true`.")
        }
    }
}


/**
 * Asserts that a condition is true.
 */
object AssertFalse {
    def apply[x]           : scala.Unit = macro AssertFalseImpl.termMacro_[x]
    def apply(x: scala.Any): scala.Unit = macro AssertFalseImpl.termMacro
}


final class AssertFalseImpl(override val c: Context) extends AssertionMacroImpl1 {
    import c.universe._
    override protected def assertionTypeOnly(x: c.Type): AssertionResult = {
        if (x =:= weakTypeOf[`false`]) {
            AssertionSuccess
        } else {
            AssertionFailure(show(x.dealias) + " required to be `false`.")
        }
    }
}
