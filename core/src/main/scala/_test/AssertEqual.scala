

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _test


import scala.language.experimental.macros
import scala.reflect.macros.{Context, TypecheckException}
import makro._


private[sing]
object AssertEqual extends Assert2Impl {
    override protected def inTerm(c: Context)(xx: Duo[c.type], yy: Duo[c.type]): AssertResult = {
        import c.universe._

        val x = xx.term
        val y = yy.term

        val expr =  q"${sing_(c)}.Test.assertTrue($x.equal($y))"

        try {
            c.typeCheck(expr)
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
            c.typeCheck(expr)
            AssertSuccess
        } catch {
            case e: TypecheckException if (e.getMessage.matches(CompileError.AssertError)) => {
                AssertFailure(show(x.normalize) + " is not equal to " + show(y.normalize))
            }
        }
    }
}
