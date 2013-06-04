

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

        val selfdef: c.Tree = q"type self = ${TypeOfSelf(c)}"

        val Template(parents, self, body) = c.enclosingTemplate

        Template(Sings.removeMacro(c)(parents), self, selfdef :: body)
    }
}
