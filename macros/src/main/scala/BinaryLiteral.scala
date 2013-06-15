

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object BinaryLiteral {

    // "0010..." --> ...DCons(`false`, DCons(`true`, DNil))

     def apply(x: String) = macro term_impl
    type apply(x: String) = macro type_impl

    def term_impl(c: Context)(x: c.Expr[String]): c.Expr[Any] = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"

        val nil: c.Tree = q"$singlib.DNil"
        val cons: c.Tree = q"$singlib.DCons"
        val t: c.Tree = q"$singlib.`true`"
        val f: c.Tree = q"$singlib.`false`"

        val Literal(Constant(str: String)) = x.tree

        val res = str.dropWhile(_ == '0').reverse.map {
            case '1' => t
            case '0' => f
            case w => c.abort(c.enclosingPosition, "invalid binary literal: " + w.toString)
        }.foldRight(nil) { (tf, x) =>
            Apply(cons, List(tf, x))
        }

        c.Expr[Any](res)
    }

    def type_impl(c: Context)(x: c.Expr[String]): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"

        val nil: c.Tree = tq"$singlib.DNil"
        val cons: c.Tree = tq"$singlib.DCons"
        val t: c.Tree = tq"$singlib.`true`"
        val f: c.Tree = tq"$singlib.`false`"

        val Literal(Constant(str: String)) = x.tree

        val res = str.dropWhile(_ == '0').reverse.map {
            case '1' => t
            case '0' => f
            case w => c.abort(c.enclosingPosition, "invalid binary literal: " + w.toString)
        }.foldRight(nil) { (tf, x) =>
            AppliedTypeTree(cons, List(tf, x))
        }

        res
    }
}
