

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


// Canonical way?
object RemoveDefaultConstructor {

    def apply(c: Context)(from: List[c.Tree]): List[c.Tree] = {
        import c.universe._

        val ClassDef(_, _, _, Template(_, _, body)) = q"class X"

        from.filter { t =>
            !t.equalsStructure(body.head)
        }
    }
}
