

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object NewKind {

    type apply = macro impl

    def impl(c: Context): c.Tree = {
        import c.universe._
        val singlib: c.Tree = q"com.github.okomok.sing"
        HasKindId._impl(c)(tq"$singlib.Any")
    }
}
