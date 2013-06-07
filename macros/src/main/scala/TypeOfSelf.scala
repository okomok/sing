

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


// Special thanks to: https://github.com/leonardschneider/macrogen


import scala.language.experimental.macros
import scala.reflect.macros.Context


object TypeOfSelf {

    type apply = macro impl

    def impl(c: Context): c.Tree = {
        import c.universe._

        c.enclosingImpl match {
            case ClassDef(_, name, tparams, _) if tparams.length > 0 => {
                val targs = tparams.map(t => tq"${t.name}")
                tq"$name[..$targs]"
            }
            case ClassDef(_, name, _, _) => {
                tq"$name"
            }
            case ModuleDef(_, name, _) => {
                tq"$name.type"
            }
        }
    }
}
