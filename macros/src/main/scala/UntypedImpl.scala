

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context
import scala.reflect.macros.TypecheckException


trait UntypedImpl {
    protected def untyped_term_impl(c: Context)(x: c.Tree): c.Tree

    final def term_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        val code = ExtractString(c)(x)
        untyped_term_impl(c)(c.parse(code))
    }
}
