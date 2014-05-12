

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object AssertEq extends Assert2Impl {
    def apply[x, y]: Unit             = macro term_impl_[x, y]
    def apply[x, y](x: x, y: y): Unit = macro term_impl[x, y]

    override protected def inType(c: Context)(x: c.Type, y: c.Type): AssertResult = {
        import c.universe._

        if (x =:= y) {
            AssertSuccess
        } else {
            AssertFailure(show(x.dealias) + " is not equivalent to " + show(y.dealias))
        }
    }
}


object AssertNeq extends Assert2Impl {
    def apply[x, y]: Unit             = macro term_impl_[x, y]
    def apply[x, y](x: x, y: y): Unit = macro term_impl[x, y]

    override protected def inType(c: Context)(x: c.Type, y: c.Type): AssertResult = {
        import c.universe._

        if (!(x =:= y)) {
            AssertSuccess
        } else {
            AssertFailure(show(x.dealias) + " is equivalent to " + show(y.dealias))
        }
    }
}
