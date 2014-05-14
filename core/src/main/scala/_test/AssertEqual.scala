

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing
package _test


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import scala.reflect.macros.TypecheckException
import makro._


private[sing]
object AssertEqual extends AssertImpl2 {
    def apply[x, y]                          : Unit = macro term_impl_[x, y]
    def apply(x: Unspecified, y: Unspecified): Unit = macro term_impl

    override protected def assert_term_impl(c: Context)(x: c.Tree, y: c.Tree): AssertResult = {
        import c.universe._

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

    override protected def assert_type_impl(c: Context)(x: c.Tree, y: c.Tree): AssertResult = {
        import c.universe._

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


private[sing]
object AssertNequal extends AssertImpl2 {
    def apply[x, y]                          : Unit = macro term_impl_[x, y]
    def apply(x: Unspecified, y: Unspecified): Unit = macro term_impl

    override protected def assert_term_impl(c: Context)(x: c.Tree, y: c.Tree): AssertResult = {
        import c.universe._

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

    override protected def assert_type_impl(c: Context)(x: c.Tree, y: c.Tree): AssertResult = {
        import c.universe._

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
