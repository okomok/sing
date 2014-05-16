

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Echo {
    def apply[x]             : Unit = macro EchoImpl.term_impl_[x]
    def apply(x: Unspecified): Unit = macro EchoImpl.term_impl
}

class EchoImpl(override val c: Context) extends AssertImpl1 {
    import c.universe._

    override protected def assert_term_impl(x: c.Tree): AssertResult = {
        c.echo(NoPosition, show(x) + ": " + show(x.tpe.dealias))
        AssertSuccess
    }

    override protected def assert_type_impl(x: c.Tree): AssertResult = {
        c.echo(NoPosition, show(x.tpe.dealias))
        AssertSuccess
    }
}


object EchoRaw {
    def apply[x]             : Unit = macro EchoRawImpl.term_impl_[x]
    def apply(x: Unspecified): Unit = macro EchoRawImpl.term_impl
}

class EchoRawImpl(override val c: Context) extends AssertImpl1 {
    import c.universe._

    override protected def assert_term_impl(x: c.Tree): AssertResult = {
        c.echo(NoPosition, showRaw(x) + ": " + showRaw(x.tpe.dealias))
        AssertSuccess
    }

    override protected def assert_type_impl(x: c.Tree): AssertResult = {
        c.echo(NoPosition, showRaw(x.tpe.dealias))
        AssertSuccess
    }
}
