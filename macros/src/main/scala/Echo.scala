

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Echo extends AssertImpl1 {
    def apply[x]             : Unit = macro term_impl_[x]
    def apply(x: Unspecified): Unit = macro term_impl

    override protected def assert_term_impl(c: Context)(x: c.Tree): AssertResult = {
        import c.universe._

        c.echo(NoPosition, show(x) + ": " + show(x.tpe.dealias))
        AssertSuccess
    }

    override protected def assert_type_impl(c: Context)(x: c.Tree): AssertResult = {
        import c.universe._

        c.echo(NoPosition, show(x.tpe.dealias))
        AssertSuccess
    }
}


object EchoRaw extends AssertImpl1 {
    def apply[x]             : Unit = macro term_impl_[x]
    def apply(x: Unspecified): Unit = macro term_impl

    override protected def assert_term_impl(c: Context)(x: c.Tree): AssertResult = {
        import c.universe._

        c.echo(NoPosition, showRaw(x) + ": " + showRaw(x.tpe.dealias))
        AssertSuccess
    }

    override protected def assert_type_impl(c: Context)(x: c.Tree): AssertResult = {
        import c.universe._

        c.echo(NoPosition, showRaw(x.tpe.dealias))
        AssertSuccess
    }
}
