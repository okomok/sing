

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object AsKind {

    type apply = macro apply

    def apply(c: Context): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"
        impl(c)(tq"$singlib.AnyKind")
    }

    def impl(c: Context)(zuper: c.Tree): c.Tree = {
        import c.universe._

        val fullName = c.enclosingImpl.symbol.fullName.toString
        val (vkid, tkid) = KindId(c)(fullName)

        val vdef = q"override lazy val kindId: kindId = $vkid"
        val tdef = q"override     type kindId         = $tkid"

        Mixin(c)(zuper, List(vdef, tdef))
    }
}