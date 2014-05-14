

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object DenseLiteral extends DependentImpl1 {
    def apply(x: Int): Unspecified = macro term_impl

    override protected def dep_term_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._
        term_fromBinaryString(c)(Integer.toBinaryString(ExtractNat(c)(x)))
    }

    override protected def dep_type_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._
        type_fromBinaryString(c)(Integer.toBinaryString(ExtractNat(c)(x)))
    }

    // "0010..." --> ...DCons(`false`, DCons(`true`, DNil))
    def term_fromBinaryString(c: Context)(bs: String): c.Tree = {
        import c.universe._

        val nil: c.Tree = q"${sing_(c)}.DNil"
        val cons: c.Tree = q"${sing_(c)}.DCons"
        val t: c.Tree = q"${sing_(c)}.`true`"
        val f: c.Tree = q"${sing_(c)}.`false`"

        bs.dropWhile(_ == '0').reverse.map {
            case '1' => t
            case '0' => f
            case w => CompileError.illegalArgument(c)(w.toString + " is illformed")
        }.foldRight(nil) { (tf, res) =>
            Apply(cons, List(tf, res))
        }
    }

    def type_fromBinaryString(c: Context)(bs: String): c.Tree = {
        import c.universe._

        val nil: c.Tree = tq"${sing_(c)}.DNil"
        val cons: c.Tree = tq"${sing_(c)}.DCons"
        val t: c.Tree = tq"${sing_(c)}.`true`"
        val f: c.Tree = tq"${sing_(c)}.`false`"

        bs.dropWhile(_ == '0').reverse.map {
            case '1' => t
            case '0' => f
            case w => CompileError.illegalArgument(c)(w.toString + " is illformed")
        }.foldRight(nil) { (tf, res) =>
            AppliedTypeTree(cons, List(tf, res))
        }
    }
}
