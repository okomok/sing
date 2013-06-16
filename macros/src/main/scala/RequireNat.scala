

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


private object RequireNat {
    def apply(c: Context)(i: Int): Unit = {
        if (i < 0) {
            c.abort(c.enclosingPosition, "natural number literal can't be negative: " + i.toString)
        }
    }
}
