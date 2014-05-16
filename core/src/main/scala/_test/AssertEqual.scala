

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _test


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import scala.reflect.macros.TypecheckException
import makro._


class AssertEqualImpl(override val c: Context) extends AssertImpl2 {
    import c.universe._

    override protected def assert_term_impl(x: c.Tree, y: c.Tree): AssertResult = {
        val expr =  q"${sing_(c)}.Test.assertTrue($x.equal($y))"

        try {
            c.typecheck(expr)
            AssertSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertFailure(show(x) + " is not equal to " + show(y))
            }
        }
    }

    override protected def assert_type_impl(x: c.Tree, y: c.Tree): AssertResult = {
        // Note a type-tree isn't checkable.
        val expr = q"${sing_(c)}.Test.assertTrue[$x#equal[$y]]"

        try {
            c.typecheck(expr)
            AssertSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertFailure(show(x.tpe.dealias) + " is required to be equal to " + show(y.tpe.dealias))
            }
        }
    }
}


class AssertNequalImpl(override val c: Context) extends AssertImpl2 {
    import c.universe._

    override protected def assert_term_impl(x: c.Tree, y: c.Tree): AssertResult = {
        val expr =  q"${sing_(c)}.Test.assertTrue($x.nequal($y))"

        try {
            c.typecheck(expr)
            AssertSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertFailure(show(x) + " is not equal to " + show(y))
            }
        }
    }

    override protected def assert_type_impl(x: c.Tree, y: c.Tree): AssertResult = {
        // Note a type-tree isn't checkable.
        val expr = q"${sing_(c)}.Test.assertTrue[$x#nequal[$y]]"

        try {
            c.typecheck(expr)
            AssertSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertFailure(show(x.tpe.dealias) + " is required not to be equal to " + show(y.tpe.dealias))
            }
        }
    }
}
