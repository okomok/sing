

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


object ExtractNat {
    def apply(c: Context)(x: c.Tree): Int = {
        import c.universe._

        x match {
            case Literal(Constant(y: Int)) if (y >= 0) => y
            case _ => CompileError.illegalArgument(c)(show(x) + " is required to be non-negative Int literal.")
        }
    }
}
