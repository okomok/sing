

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Echo extends Assert1Impl {
     def apply[x]: Unit       = macro term_impl_[x]
     def apply[x](x: x): Unit = macro term_impl[x]
    type apply[x]             = macro type_impl[x]

    override protected def impl(c: Context)(x: c.Type): AssertResult = {
        import c.universe._
        c.echo(c.enclosingPosition, show(x.normalize))
        AssertSuccess
    }
}
