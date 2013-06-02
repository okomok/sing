

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


object Mixin {

    def apply(c: Context)(zuper: c.Tree, body: List[c.Tree]): c.Tree = {
        import c.universe._

        val Template(parents, _, oldbody) = c.enclosingTemplate
        Template(replace(c)(parents, zuper), emptyValDef, oldbody ++ body)
    }

    def replace(c: Context)(parents: List[c.Tree], zuper: c.Tree): List[c.Tree] = {
        parents.map { x =>
            if (x.equalsStructure(c.macroApplication)) zuper else x
        }
    }
}
