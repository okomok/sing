

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object PeanoLiteral {
     def apply(x: Int) = macro term_impl
    type apply(x: Int) = macro type_impl

    // 2 --> Succ(Succ(Zero))
    def term_impl(c: Context)(x: c.Expr[Int]): c.Expr[Any] = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"

        val zero: c.Tree = q"$singlib.Zero"
        val succ: c.Tree = q"$singlib.Succ"

        val Literal(Constant(i: Int)) = x.tree
        CheckNat(c)(i)

        val res = (0 until i).foldRight(zero) { (_, res) =>
            Apply(succ, List(res))
        }

        c.Expr[Any](res)
    }

    def type_impl(c: Context)(x: c.Expr[Int]): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"

        val zero: c.Tree = tq"$singlib.Zero"
        val succ: c.Tree = tq"$singlib.Succ"

        val Literal(Constant(i: Int)) = x.tree
        CheckNat(c)(i)

        val res = (0 until i).foldRight(zero) { (_, res) =>
            AppliedTypeTree(succ, List(res))
        }

        res
    }
}
