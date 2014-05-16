

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object BinaryLiteral  {
    def apply(x: String): Unspecified = macro BinaryLiteralImpl.term_impl
}

class BinaryLiteralImpl(override val c: Context) extends DependentImpl1 {
    import c.universe._

    override protected def dep_term_impl(x: c.Tree): c.Tree = {
        DenseLiteral.term_fromBinaryString(c)(ExtractString(c)(x))
    }

    override protected def dep_type_impl(x: c.Tree): c.Tree = {
        import c.universe._
        DenseLiteral.type_fromBinaryString(c)(ExtractString(c)(x))
    }
}
