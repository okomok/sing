

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import scala.language.experimental.macros
import scala.reflect.macros.Context


// Must be placed in top-level for implicit lookup?

trait BoxKind[A] extends AnyKind {
     val self: self = this
    type self = this.type // K.type seems broken.

     def box(x: A): box = new Box[A, self](x, self)
    type box = Box[A, self]
}


object BoxKind {

    implicit def _ofScalaAny[A]: BoxKind[A] = macro _ofScalaAnyImpl[A]

    def _ofScalaAnyImpl[A: c.WeakTypeTag](c: Context): c.Expr[BoxKind[A]] = {
        import c.universe._

        val fullName = weakTypeOf[A].typeSymbol.fullName.toString
        val (vkid, tkid) = makro.KindId(c)(fullName)

        val res = q"""
            new BoxKind[${weakTypeOf[A]}] {
                override lazy val kindId: kindId = $vkid
                override     type kindId         = $tkid
            }
        """
        c.Expr[BoxKind[A]](c.typeCheck(res))
    }
}
