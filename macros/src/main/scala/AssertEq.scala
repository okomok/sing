

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object AssertEq {
    def apply[x, y]                          : Unit = macro AssertEqImpl.term_impl_[x, y]
    def apply(x: Unspecified, y: Unspecified): Unit = macro AssertEqImpl.term_impl
}

class AssertEqImpl(override val c: Context) extends AssertImpl2 {
    import c.universe._

    override protected def assert_type_only(x: c.Type, y: c.Type): AssertResult = {
        if (x =:= y) {
            AssertSuccess
        } else {
            AssertFailure(show(x.dealias) + " is required to be equivalent to " + show(y.dealias))
        }
    }
}


object AssertNeq {
    def apply[x, y]            : Unit = macro AssertNeqImpl.term_impl_[x, y]
    def apply[x, y](x: x, y: y): Unit = macro AssertNeqImpl.term_impl
}

class AssertNeqImpl(override val c: Context) extends AssertImpl2 {
    import c.universe._

    def apply[x, y]            : Unit = macro term_impl_[x, y]
    def apply[x, y](x: x, y: y): Unit = macro term_impl

    override protected def assert_type_only(x: c.Type, y: c.Type): AssertResult = {
        if (!(x =:= y)) {
            AssertSuccess
        } else {
            AssertFailure(show(x.dealias) + " is required not to be equivalent to " + show(y.dealias))
        }
    }
}
