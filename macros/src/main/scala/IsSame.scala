

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object IsSame {
    def apply[x, y](x: x, y: y) = macro term_impl[x, y]
   type apply[x, y]             = macro type_impl[x, y]

    def term_impl[x, y](c: Context)(x: c.Expr[x], y: c.Expr[y])(implicit tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): c.Expr[Any] = {
        import c.universe._

        val res = if (_impl(c)(tx, ty)) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }

        c.Expr[Any](res)
    }

    def type_impl[x, y](c: Context)(implicit tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): c.Tree = {
        import c.universe._

        val res = if (_impl(c)(tx, ty)) {
            tq"${sing_(c)}.`true`"
        } else {
            tq"${sing_(c)}.`false`"
        }

        res
    }

    def _impl[x, y](c: Context)(tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): Boolean = {
        import c.universe._
        weakTypeOf(tx) =:= weakTypeOf(ty)
    }
}
