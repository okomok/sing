

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.

// See: https://github.com/leonardschneider/macrogen


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object New {

    type apply[T] = macro apply[T]

    def apply[T: c.WeakTypeTag](c: Context): c.Tree = {
        import c.universe._

        val name = weakTypeOf[T].typeSymbol.name.toString
        val implName = TypeName("As" + name)

        val singlib: c.Tree = q"com.github.okomok.sing"

        val zuper: c.Tree = tq"$singlib.$implName"
        val selfdef: c.Tree = q"override type self = ${TypeOfSelf(c)}"

        Mixin(c)(zuper, List(selfdef))
    }
}
