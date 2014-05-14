

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object PeanoLiteral extends DependentImpl1 {
    def apply(x: Int): Unspecified = macro term_impl

    // 2 --> Succ(Succ(Zero))
    override protected def dep_term_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        val zero: c.Tree = q"${sing_(c)}.Zero"
        val succ: c.Tree = q"${sing_(c)}.Succ"

        (0 until ExtractNat(c)(x)).foldRight(zero) { (_, res) =>
            Apply(succ, List(res))
        }
    }

    override protected def dep_type_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        val zero: c.Tree = tq"${sing_(c)}.Zero"
        val succ: c.Tree = tq"${sing_(c)}.Succ"

        (0 until ExtractNat(c)(x)).foldRight(zero) { (_, res) =>
            AppliedTypeTree(succ, List(res))
        }
    }
}
