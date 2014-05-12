

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Unsupported extends Dependent1Impl[String] with TypeThrow {
    def apply(x: String): Unspecified = macro impl

    def impl(c: Context)(x: c.Expr[String]): c.Expr[Unspecified] = dep_impl(c)(x)

    override protected def what(c: Context): c.Tree = {
        import c.universe._
        tq"_root_.java.lang.UnsupportedOperationException"
    }
}
