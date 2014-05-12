

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


object LiteralUnit {
    def apply(c: Context): c.Expr[Unit] = {
        import c.universe._
        c.Expr[Unit](q"()")
    }
}
