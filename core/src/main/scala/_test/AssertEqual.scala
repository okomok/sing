

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _test


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import scala.reflect.macros.TypecheckException
import makro._


private[sing]
object AssertEqual extends AssertImpl2 {
    override protected def inTerm(c: Context)(xx: Duo[c.type], yy: Duo[c.type]): AssertResult = {
        import c.universe._

        val x = xx.term
        val y = yy.term

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

    override protected def inType(c: Context)(x: c.Type, y: c.Type): AssertResult = {
        import c.universe._

        // Note a type-tree isn't checkable.
        val expr = q"${sing_(c)}.Test.place[ ${sing_(c)}.Test.assertTrue[$x#equal[$y]] ]"

        try {
            c.typecheck(expr)
            AssertSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertFailure(show(x.dealias) + " is not equal to " + show(y.dealias))
            }
        }
    }
}


private[sing]
object AssertNequal extends AssertImpl2 {
    override protected def inTerm(c: Context)(xx: Duo[c.type], yy: Duo[c.type]): AssertResult = {
        import c.universe._

        val x = xx.term
        val y = yy.term

        val expr =  q"${sing_(c)}.Test.assertTrue($x.nequal($y))"

        try {
            c.typecheck(expr)
            AssertSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertFailure(show(x) + " is equal to " + show(y))
            }
        }
    }

    override protected def inType(c: Context)(x: c.Type, y: c.Type): AssertResult = {
        import c.universe._

        // Note a type-tree isn't checkable.
        val expr = q"${sing_(c)}.Test.place[ ${sing_(c)}.Test.assertTrue[$x#nequal[$y]] ]"

        try {
            c.typecheck(expr)
            AssertSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertFailure(show(x.dealias) + " is equal to " + show(y.dealias))
            }
        }
    }
}
