

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object AssertConforms extends AssertImpl2 {
    def apply[x, y]                          : Unit = macro term_impl_[x, y]
    def apply(x: Unspecified, y: Unspecified): Unit = macro term_impl

    override protected def assert_type_only(c: Context)(x: c.Type, y: c.Type): AssertResult = {
        import c.universe._

        if (x <:< y) {
            AssertSuccess
        } else {
            AssertFailure(show(x.dealias) + " does not conform to " + show(y.dealias))
        }
    }
}
