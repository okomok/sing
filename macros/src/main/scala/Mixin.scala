

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


object Mixin {

    def apply(c: Context)(zuper: c.Tree, body: List[c.Tree]): c.Tree = {
        import c.universe._

        val Template(parents, self, oldbody) = c.enclosingTemplate
        Template(ReplaceMacro(c)(parents, zuper), self, oldbody ++ body)
    }
}
