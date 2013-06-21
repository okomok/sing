

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


// See: http://stackoverflow.com/questions/15898037/how-to-check-if-weaktypetag-or-type-represents-concrete-type


object IsAbstract {
     def apply[x](x: x) = macro term_impl[x]
    type apply[x]       = macro type_impl[x]

    def term_impl[x](c: Context)(x: c.Expr[x])(implicit tx: c.WeakTypeTag[x]): c.Expr[Any] = {
        import c.universe._

        val res = if (_impl(c)(tx)) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }

        c.Expr[Any](res)
    }

    def type_impl[x](c: Context)(implicit tx: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._

        val res = if (_impl(c)(tx)) {
            tq"${sing_(c)}.`true`"
        } else {
            tq"${sing_(c)}.`false`"
        }

        res
    }

    def _impl[x](c: Context)(tx: c.WeakTypeTag[x]): Boolean = {
        import c.universe._
        weakTypeOf(tx).typeSymbol.asType.isAbstractType
    }
}
