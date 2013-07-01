

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object DenseLiteral {
     def apply(x: Int) = macro term_impl
    type apply(x: Int) = macro type_impl

    def term_impl(c: Context)(x: c.Expr[Int]): c.Expr[Any] = {
        import c.universe._

        RequireConstantLiteral(c)(x)
        val Literal(Constant(i: Int)) = x.tree
        RequireNat(c)(i)

        term_fromBinaryString(c)(Integer.toBinaryString(i))
    }

    def type_impl(c: Context)(x: c.Expr[Int]): c.Tree = {
        import c.universe._

        RequireConstantLiteral(c)(x)
        val Literal(Constant(i: Int)) = x.tree
        RequireNat(c)(i)

        type_fromBinaryString(c)(Integer.toBinaryString(i))
    }

    // "0010..." --> ...DCons(`false`, DCons(`true`, DNil))
    def term_fromBinaryString(c: Context)(bs: String): c.Expr[Any] = {
        import c.universe._

        val nil: c.Tree = q"${sing_(c)}.DNil"
        val cons: c.Tree = q"${sing_(c)}.DCons"
        val t: c.Tree = q"${sing_(c)}.`true`"
        val f: c.Tree = q"${sing_(c)}.`false`"

        val res = bs.dropWhile(_ == '0').reverse.map {
            case '1' => t
            case '0' => f
            case w => CompileError.illegalArgument(c)(w.toString + " is illformed")
        }.foldRight(nil) { (tf, res) =>
            Apply(cons, List(tf, res))
        }

        c.Expr[Any](res)
    }

    def type_fromBinaryString(c: Context)(bs: String): c.Tree = {
        import c.universe._

        val nil: c.Tree = tq"${sing_(c)}.DNil"
        val cons: c.Tree = tq"${sing_(c)}.DCons"
        val t: c.Tree = tq"${sing_(c)}.`true`"
        val f: c.Tree = tq"${sing_(c)}.`false`"

        val res = bs.dropWhile(_ == '0').reverse.map {
            case '1' => t
            case '0' => f
            case w => CompileError.illegalArgument(c)(w.toString + " is illformed")
        }.foldRight(nil) { (tf, res) =>
            AppliedTypeTree(cons, List(tf, res))
        }

        res
    }
}
