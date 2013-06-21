

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


// Thanks to: https://gist.github.com/travisbrown/5066283


object IsError {
    def apply(x: _) = macro impl

    def impl(c: Context)(x: c.Tree): c.Expr[Any] = {
        import c.universe._

        val res = if (_impl(c)(x)) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }

        c.Expr[Any](res)
    }

    def _impl(c: Context)(x: c.Tree): Boolean = {
        import c.universe._
        c.typeCheck(x, silent = true) == EmptyTree
    }
}
