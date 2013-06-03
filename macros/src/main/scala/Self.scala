

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Self {

    type apply = macro apply

    def apply(c: Context): c.Tree = {
        import c.universe._

        val singlib: c.Tree = q"com.github.okomok.sing"
        val zuper: c.Tree = tq"$singlib.Any"

        val selfdef: c.Tree = q"override type self = ${TypeOfSelf(c)}"

        Mixin(c)(zuper, List(selfdef))
    }
}
