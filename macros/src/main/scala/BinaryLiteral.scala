

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object BinaryLiteral {
     def apply(x: String) = macro term_impl
    type apply(x: String) = macro type_impl

    def term_impl(c: Context)(x: c.Expr[String]): c.Expr[Any] = {
        import c.universe._

        RequireConstantLiteral(c)(x)
        val Literal(Constant(s: String)) = x.tree
        DenseLiteral.term_fromBinaryString(c)(s)
    }

    def type_impl(c: Context)(x: c.Expr[String]): c.Tree = {
        import c.universe._

        RequireConstantLiteral(c)(x)
        val Literal(Constant(s: String)) = x.tree
        DenseLiteral.type_fromBinaryString(c)(s)
    }
}
