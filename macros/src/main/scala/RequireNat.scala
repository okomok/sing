

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


private object RequireNat {
    def apply(c: Context)(i: Int): Unit = {
        if (i < 0) {
            CompileError.illegalArgument(c)(i.toString + "is negative.")
        }
    }
}
