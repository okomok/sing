

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object BinaryLiteral extends TypedDependentImpl1[String] {
    def apply(x: String): Unspecified = macro dep_impl

    override protected def dep_extract(c: Context)(x: c.Tree): String = ExtractString(c)(x)

    override protected def dep_term_impl(c: Context)(x: String): c.Tree = {
        import c.universe._
        DenseLiteral.term_fromBinaryString(c)(x)
    }

    override protected def dep_type_impl(c: Context)(x: String): c.Tree = {
        import c.universe._
        DenseLiteral.type_fromBinaryString(c)(x)
    }
}
