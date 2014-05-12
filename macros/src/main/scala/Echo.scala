

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Echo extends Assert1Impl {
    def apply[x]: Unit       = macro term_impl_[x]
    def apply[x](x: x): Unit = macro term_impl[x]

    override protected def inTerm(c: Context)(xx: Duo[c.type]): AssertResult = {
        import c.universe._

        val x = xx.term.
            tree // removes "Expr[]".
        val _x = xx.tpe.dealias

        c.echo(NoPosition, show(x) + ": " + show(_x))
        AssertSuccess
    }

    override protected def inType(c: Context)(x: c.Type): AssertResult = {
        import c.universe._

        c.echo(NoPosition, show(x.dealias))
        AssertSuccess
    }
}


object EchoRaw extends Assert1Impl {
    def apply[x]: Unit       = macro term_impl_[x]
    def apply[x](x: x): Unit = macro term_impl[x]

    override protected def inTerm(c: Context)(xx: Duo[c.type]): AssertResult = {
        import c.universe._

        c.echo(NoPosition, showRaw(xx.term) + ": " + showRaw(xx.tpe.dealias))
        AssertSuccess
    }

    override protected def inType(c: Context)(x: c.Type): AssertResult = {
        import c.universe._

        c.echo(NoPosition, showRaw(x.dealias))
        AssertSuccess
    }
}
