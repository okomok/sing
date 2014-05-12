

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


object WeakTypeTagOf {
    def apply(c: Context)(x: c.Expr[Unspecified]): c.WeakTypeTag[Any] = c.WeakTypeTag[Any](x.tree.tpe)
}
