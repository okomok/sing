

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Binary_ {
    def apply(x: String): scala.Any = macro BinaryLiteralImpl.termMacro
}


class BinaryLiteralImpl(override val c: Context) extends DepMacro1 {
    import c.universe._

    override protected def termMacroImpl(x: c.Tree): c.Tree = {
        Dense_.term_fromBinaryString(c)(ExtractString(c)(x))
    }

    override protected def typeMacroImpl(x: c.Tree): c.Tree = {
        import c.universe._
        Dense_.type_fromBinaryString(c)(ExtractString(c)(x))
    }
}
