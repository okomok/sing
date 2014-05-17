

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Binary_ {
    def apply(x: String): scala.Any = macro BinaryLiteralImpl.termMacro
}


final class BinaryLiteralImpl(val c: Context) {
    import c.universe._

    def termMacro(x: c.Tree): c.Tree = {
        Dense_.term_fromBinaryString(c)(ExtractString(c)(x))
    }

    def typeMacroI(x: c.Tree): c.Tree = {
        import c.universe._
        Dense_.type_fromBinaryString(c)(ExtractString(c)(x))
    }
}
