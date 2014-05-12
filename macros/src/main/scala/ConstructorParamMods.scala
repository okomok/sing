

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


// Canonical way?
private object ConstructorParamMods {
    def apply(c: Context): c.Modifiers = {
        import c.universe._

        val ClassDef(_, _, _, Template(_, _, body)) = q"class X(x: Int)"

        body.collect{ case ValDef(mods, TermName("x"), _, _) =>
            mods
        }.head
    }
}
