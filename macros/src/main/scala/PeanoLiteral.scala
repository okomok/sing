

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Peano_ {
    def apply(x: Int): scala.Any = macro PeanoLiteralImpl.termMacro
}


final class PeanoLiteralImpl(val c: Context) {
    import c.universe._

    // 2 --> Succ(Succ(Zero))
    def termMacro(x: c.Tree): c.Tree = {
        val zero: c.Tree = q"${sing_(c)}.Zero"
        val succ: c.Tree = q"${sing_(c)}.Succ"

        (0 until ExtractNat(c)(x)).foldRight(zero) { (_, res) =>
            Apply(succ, scala.List(res))
        }
    }

    def typeMacro(x: c.Tree): c.Tree = {
        val zero: c.Tree = tq"${sing_(c)}.Zero"
        val succ: c.Tree = tq"${sing_(c)}.Succ"

        (0 until ExtractNat(c)(x)).foldRight(zero) { (_, res) =>
            AppliedTypeTree(succ, scala.List(res))
        }
    }
}
