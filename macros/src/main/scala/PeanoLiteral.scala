

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object PeanoLiteral extends Dependent1Impl[Int] {
    def apply(x: Int): Unspecified = macro impl

    def impl(c: Context)(x: c.Expr[Int]): c.Expr[Unspecified] = dep_impl(c)(x)

    // 2 --> Succ(Succ(Zero))
    def term_impl(c: Context)(x: c.Expr[Int]): c.Expr[Unspecified] = {
        import c.universe._

        RequireConstantLiteral(c)(x)
        val Literal(Constant(i: Int)) = x.tree
        RequireNat(c)(i)

        val zero: c.Tree = q"${sing_(c)}.Zero"
        val succ: c.Tree = q"${sing_(c)}.Succ"

        val res = (0 until i).foldRight(zero) { (_, res) =>
            Apply(succ, List(res))
        }

        c.Expr[Unspecified](res)
    }

    def type_impl(c: Context)(x: c.Expr[Int]): c.Tree = {
        import c.universe._

        RequireConstantLiteral(c)(x)
        val Literal(Constant(i: Int)) = x.tree
        RequireNat(c)(i)

        val zero: c.Tree = tq"${sing_(c)}.Zero"
        val succ: c.Tree = tq"${sing_(c)}.Succ"

        val res = (0 until i).foldRight(zero) { (_, res) =>
            AppliedTypeTree(succ, List(res))
        }

        res
    }
}
