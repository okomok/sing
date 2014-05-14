

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


// Thanks to: https://gist.github.com/travisbrown/5066283


object IsError extends PredicateImpl1 {
    def apply[x]             : Unspecified = macro term_impl_[x]
    def apply(x: Unspecified): Unspecified = macro term_impl

    override protected def pred_term_impl(c: Context)(x: c.Tree): Boolean = _impl(c)(x)
    override protected def pred_type_impl(c: Context)(x: c.Tree): Boolean = _impl(c)(x)

    private def _impl(c: Context)(x: c.Tree): Boolean = {
        import c.universe._
        c.typecheck(x, silent = true) == EmptyTree
    }
}
