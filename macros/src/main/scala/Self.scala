

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Self {
    type apply = macro impl

    def impl(c: Context): c.Tree = {
        import c.universe._

        val selfdef: c.Tree = q"type self = ${TypeOfSelf.impl(c)}"

        val Template(parents, self, body) = c.enclosingTemplate
        Template(RemoveMacro(c)(parents), self, selfdef :: body)
    }
}
