

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


object CheckNat {
    def apply(c: Context)(i: Int) {
        if (i < 0) {
            c.abort(c.enclosingPosition, "natural number literal can't be negative: " + i.toString)
        }
    }
}
