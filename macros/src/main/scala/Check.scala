

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro_


import scala.language.experimental.macros
import scala.reflect.macros.Context


object CheckType {

    type apply[T] = macro impl[T]

    def impl[T: c.WeakTypeTag](c: Context): c.Tree = {
        import c.universe._

        val t = weakTypeOf[T]
        if (t.typeSymbol.asType.isAbstractType) {
            c.error(c.enclosingPosition, show(t) + " is abstract.")
        }
        tq"$t"
    }
}


object CheckTerm {

    def apply[T](x: T) = macro impl[T]

    def impl[T: c.WeakTypeTag](c: Context)(x: c.Expr[T]): c.Expr[T] = {
        import c.universe._

        val t = weakTypeOf[T]
        if (t.typeSymbol.asType.isAbstractType) {
            c.error(c.enclosingPosition, show(t) + " is abstract.")
        }
        x
    }
}
