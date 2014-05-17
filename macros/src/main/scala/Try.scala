

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import scala.reflect.macros.TypecheckException


object Try {
    def apply[T](code: String)(catcher: scala.PartialFunction[Throwable, T]): T = macro TryImpl.impl[T]
}


class TryImpl(val c: Context) {
    import c.universe._

    final def impl[T](code: c.Tree)(catcher: c.Expr[scala.PartialFunction[Throwable, T]]): c.Tree = {
        val code_ = ExtractString(c)(code)
        val catcher_ = c.eval( c.Expr[scala.PartialFunction[Throwable, String]](c.untypecheck(catcher.tree)) )

        try {
            c.typecheck(c.parse(code_))
        } catch {
            case e: Throwable => q"${catcher_(e)}"
        }
    }
}
