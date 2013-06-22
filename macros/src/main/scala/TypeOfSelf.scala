

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


// Special thanks to: https://github.com/leonardschneider/macrogen


import scala.language.experimental.macros
import scala.reflect.macros.Context


object TypeOfSelf {
    type apply = macro impl

    def impl(c: Context): c.Tree = {
        import c.universe._
        tq"${here(c)}.WeakTypeOf.apply(this)"
    }
}
