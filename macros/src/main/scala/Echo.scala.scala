

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Echo {

    def apply[T] = macro impl[T]

    def impl[T: c.WeakTypeTag](c: Context): c.Expr[Unit] = {
        import c.universe._

        val s = weakTypeOf[T].normalize.toString
        c.echo(c.enclosingPosition, s)
        reify(())
    }
}
