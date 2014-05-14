

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object IsAbstract extends PredicateImpl1 {
    def apply[x]             : Unspecified = macro term_impl_[x]
    def apply(x: Unspecified): Unspecified = macro term_impl

    override protected def pred_type_only(c: Context)(x: c.Type): Boolean = IsAbstractType(c)(x)
}
