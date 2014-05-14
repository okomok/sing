

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Check {
    def apply[x]             : Unspecified = macro term_impl_[x]
    def apply(x: Unspecified): Unspecified = macro term_impl

    final def term_impl_[x](c: Context)(implicit x: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._
        type_impl(c)(TypeTree(x.tpe))
    }

    final def term_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._
        _type_only(c)(x)
    }

    final def type_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._
        _type_only(c)(x)
    }

    private def _type_only(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        // order matters
        val t = x.tpe
        if (t <:< weakTypeOf[Nothing]) {
            CompileError.nothingType (c)(show(t) + ", which is expanded to " + show(t.dealias))
        } else if (IsAbstractType(c)(t)) {
            CompileError.abstractType(c)(show(t) + ", which is expanded to " + show(t.dealias))
        }

        x
    }
}
