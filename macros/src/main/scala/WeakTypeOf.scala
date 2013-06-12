

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


// Special thanks to: https://github.com/leonardschneider/macrogen


import scala.language.experimental.macros
import scala.reflect.macros.Context


object WeakTypeOf {

    type apply[T](x: T) = macro impl[T]

    def impl[T: c.WeakTypeTag](c: Context)(x: c.Expr[T]): c.Tree = {
        import c.universe._
        tq"${weakTypeOf[T]}"
    }
}
