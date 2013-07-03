

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object WeakTypeOf {
    type apply[x](x: x) = macro impl[x]

    def impl[x](c: Context)(x: c.Expr[x])(implicit tx: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._
        TypeTree(tx.tpe)
    }
}
