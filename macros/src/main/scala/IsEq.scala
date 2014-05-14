

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object IsEq extends PredicateImpl2 {
    def apply[x, y]                          : Unspecified = macro term_impl_[x, y]
    def apply(x: Unspecified, y: Unspecified): Unspecified = macro term_impl

    override protected def pred_type_only(c: Context)(x: c.Type, y: c.Type): Boolean = {
        x <:< y && y <:< x
    }
}
