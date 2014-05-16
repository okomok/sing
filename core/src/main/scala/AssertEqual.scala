

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import scala.reflect.macros.TypecheckException


/**
 * Asserts that <code>x.equal(y)</code>.
 */
object AssertEqual {
    def apply[x, y]                      : scala.Unit = macro AssertEqualImpl.termMacro_[x, y]
    def apply(x: scala.Any, y: scala.Any): scala.Unit = macro AssertEqualImpl.termMacro
}


class AssertEqualImpl(override val c: Context) extends AssertionMacro2 {
    import c.universe._

    override protected def assertionTermImpl(x: c.Tree, y: c.Tree): AssertionResult = {
        val expr =  q"${sing_(c)}.AssertTrue($x.equal($y))"

        try {
            c.typecheck(expr)
            AssertionSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertionFailure(show(x) + " is not equal to " + show(y))
            }
        }
    }

    override protected def assertionTypeImpl(x: c.Tree, y: c.Tree): AssertionResult = {
        // Note a type-tree isn't checkable.
        val expr = q"${sing_(c)}.AssertTrue[$x#equal[$y]]"

        try {
            c.typecheck(expr)
            AssertionSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertionFailure(show(x.tpe.dealias) + " is required to be equal to " + show(y.tpe.dealias))
            }
        }
    }
}


/**
 * Asserts that <code>x.nequal(y)</code>.
 */
object AssertNequal {
    def apply[x, y]                      : scala.Unit = macro AssertNequalImpl.termMacro_[x, y]
    def apply(x: scala.Any, y: scala.Any): scala.Unit = macro AssertNequalImpl.termMacro
}


class AssertNequalImpl(override val c: Context) extends AssertionMacro2 {
    import c.universe._

    override protected def assertionTermImpl(x: c.Tree, y: c.Tree): AssertionResult = {
        val expr =  q"${sing_(c)}.AssertTrue($x.nequal($y))"

        try {
            c.typecheck(expr)
            AssertionSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertionFailure(show(x) + " is not equal to " + show(y))
            }
        }
    }

    override protected def assertionTypeImpl(x: c.Tree, y: c.Tree): AssertionResult = {
        // Note a type-tree isn't checkable.
        val expr = q"${sing_(c)}.AssertTrue[$x#nequal[$y]]"

        try {
            c.typecheck(expr)
            AssertionSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertionFailure(show(x.tpe.dealias) + " is required not to be equal to " + show(y.tpe.dealias))
            }
        }
    }
}
