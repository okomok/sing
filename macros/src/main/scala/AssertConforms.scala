

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object AssertConforms {
    def apply[x, y]                          : Unit = macro AssertConformsImpl.term_impl_[x, y]
    def apply(x: Unspecified, y: Unspecified): Unit = macro AssertConformsImpl.term_impl
}

class AssertConformsImpl(override val c: Context) extends AssertImpl2 {
    import c.universe._

    final override protected def assert_type_only(x: c.Type, y: c.Type): AssertResult = {
        if (x <:< y) {
            AssertSuccess
        } else {
            AssertFailure(show(x.dealias) + " does not conform to " + show(y.dealias))
        }
    }
}
