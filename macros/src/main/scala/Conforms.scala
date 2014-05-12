

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Conforms extends Predicate2Impl {
    def apply[x, y](x: x, y: y): Unspecified = macro term_impl[x, y]

    override protected def impl(c: Context)(x: c.Type, y: c.Type): Boolean = {
        x <:< y
    }
}
