

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


// See: https://gist.github.com/travisbrown/5066283


object AssertError {

    def apply(x: _): Unit = macro impl

    def impl(c: Context)(x: c.Tree): c.Expr[Unit] = {
        import c.universe._

        if (c.typeCheck(x, silent = true) != EmptyTree) {
            c.error(c.enclosingPosition, show(x) + " compiles unexpectedly.")
        }

        reify(())
    }
}
