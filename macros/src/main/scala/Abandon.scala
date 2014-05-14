

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Abandon extends UntypedImpl {
    def apply(x: String): Unspecified = macro term_impl

    override protected def untyped_term_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._
        q"()"
    }
}
