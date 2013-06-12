

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Check {

     def apply[x](x: x) = macro term_impl[x]
    type apply[x]       = macro type_impl[x]

    def term_impl[x: c.WeakTypeTag](c: Context)(x: c.Expr[x]): c.Expr[x] = {
        import c.universe._
        AssertConcrete(c)
        x
    }

    def type_impl[x: c.WeakTypeTag](c: Context): c.Tree = {
        import c.universe._
        AssertConcrete(c)
        tq"${weakTypeOf[x]}"
    }
}
