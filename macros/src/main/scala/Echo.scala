

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


/**
 * Prints a tree.
 */
object Echo {
    def apply[x]           : scala.Unit = macro EchoImpl.termMacro_[x]
    def apply(x: scala.Any): scala.Unit = macro EchoImpl.termMacro
}


final class EchoImpl(override val c: Context) extends AssertionMacroImpl1 {
    import c.universe._

    override protected def assertionTermImpl(x: c.Tree): AssertionResult = {
        c.echo(NoPosition, show(x) + ": " + show(x.tpe.dealias))
        AssertionSuccess
    }

    override protected def assertionTypeImpl(x: c.Tree): AssertionResult = {
        c.echo(NoPosition, show(x.tpe.dealias))
        AssertionSuccess
    }
}


/**
 * Prints a raw tree.
 */
object EchoRaw {
    def apply[x]           : scala.Unit = macro EchoRawImpl.termMacro_[x]
    def apply(x: scala.Any): scala.Unit = macro EchoRawImpl.termMacro
}


final class EchoRawImpl(override val c: Context) extends AssertionMacroImpl1 {
    import c.universe._

    override protected def assertionTermImpl(x: c.Tree): AssertionResult = {
        c.echo(NoPosition, showRaw(x) + ": " + showRaw(x.tpe.dealias))
        AssertionSuccess
    }

    override protected def assertionTypeImpl(x: c.Tree): AssertionResult = {
        c.echo(NoPosition, showRaw(x.tpe.dealias))
        AssertionSuccess
    }
}
