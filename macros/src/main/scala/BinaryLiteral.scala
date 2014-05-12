

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object BinaryLiteral extends Dependent1Impl[String] {
    def apply(x: String): Unspecified = macro impl

    def impl(c: Context)(x: c.Expr[String]): c.Expr[Unspecified] = dep_impl(c)(x)

    override protected def term_impl(c: Context)(x: c.Expr[String]): c.Expr[Unspecified] = {
        import c.universe._

        RequireConstantLiteral(c)(x)
        val Literal(Constant(s: String)) = x.tree
        DenseLiteral.term_fromBinaryString(c)(s)
    }

    override protected def type_impl(c: Context)(x: c.Expr[String]): c.Tree = {
        import c.universe._

        RequireConstantLiteral(c)(x)
        val Literal(Constant(s: String)) = x.tree
        DenseLiteral.type_fromBinaryString(c)(s)
    }
}
