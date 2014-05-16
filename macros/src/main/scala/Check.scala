

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


/**
 * Ensures an expression to be non-abstract.
 */
object Check {
    def apply[x]           : scala.Any = macro CheckImpl.termMacro_[x]
    def apply(x: scala.Any): scala.Any = macro CheckImpl.termMacro
}


class CheckImpl(val c: Context) {
    import c.universe._

    final def termMacro_[x](implicit x: c.WeakTypeTag[x]): c.Tree = typeMacro(TypeTree(x.tpe))

    final def termMacro(x: c.Tree): c.Tree = {
        _check(x)
        q"${sing_(c)}.TermWrapper.of($x)"
    }

    final def typeMacro(x: c.Tree): c.Tree = {
        _check(x)
        q"${sing_(c)}.TypeWrapper.of[$x]"
    }

    private def _check(x: c.Tree): scala.Unit = {
        val t = x.tpe
        if (t <:< weakTypeOf[Nothing]) {
            CompileError.nothingType (c)(show(t) + ", which is expanded to " + show(t.dealias))
        } else if (IsAbstractType(c)(t)) {
            CompileError.abstractType(c)(show(t) + ", which is expanded to " + show(t.dealias))
        }
    }
}
