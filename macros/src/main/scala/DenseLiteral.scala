

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object DenseLiteral {
     def apply(x: Int) = macro term_impl
    type apply(x: Int) = macro type_impl

    def term_impl(c: Context)(x: c.Expr[Int]): c.Expr[Any] = {
        import c.universe._

        val Literal(Constant(i: Int)) = x.tree
        CheckNat(c)(i)

        term_fromBinaryString(c)(Integer.toBinaryString(i))
    }

    def type_impl(c: Context)(x: c.Expr[Int]): c.Tree = {
        import c.universe._

        val Literal(Constant(i: Int)) = x.tree
        CheckNat(c)(i)

        type_fromBinaryString(c)(Integer.toBinaryString(i))
    }

    // "0010..." --> ...DCons(`false`, DCons(`true`, DNil))
    def term_fromBinaryString(c: Context)(bs: String): c.Expr[Any] = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"

        val nil: c.Tree = q"$singlib.DNil"
        val cons: c.Tree = q"$singlib.DCons"
        val t: c.Tree = q"$singlib.`true`"
        val f: c.Tree = q"$singlib.`false`"

        val res = bs.dropWhile(_ == '0').reverse.map {
            case '1' => t
            case '0' => f
            case w => c.abort(c.enclosingPosition, "invalid binary literal: " + w.toString)
        }.foldRight(nil) { (tf, res) =>
            Apply(cons, List(tf, res))
        }

        c.Expr[Any](res)
    }

    def type_fromBinaryString(c: Context)(bs: String): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"

        val nil: c.Tree = tq"$singlib.DNil"
        val cons: c.Tree = tq"$singlib.DCons"
        val t: c.Tree = tq"$singlib.`true`"
        val f: c.Tree = tq"$singlib.`false`"

        val res = bs.dropWhile(_ == '0').reverse.map {
            case '1' => t
            case '0' => f
            case w => c.abort(c.enclosingPosition, "invalid binary literal: " + w.toString)
        }.foldRight(nil) { (tf, res) =>
            AppliedTypeTree(cons, List(tf, res))
        }

        res
    }
}
