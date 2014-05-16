

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Check {
    def apply[x]             : Unspecified = macro CheckImpl.term_impl_[x]
    def apply(x: Unspecified): Unspecified = macro CheckImpl.term_impl
}

class CheckImpl(val c: Context) {
    import c.universe._

    final def term_impl_[x](implicit x: c.WeakTypeTag[x]): c.Tree = type_impl(TypeTree(x.tpe))
    final def term_impl(x: c.Tree): c.Tree = _type_only(x)
    final def type_impl(x: c.Tree): c.Tree = _type_only(x)

    private def _type_only(x: c.Tree): c.Tree = {
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
