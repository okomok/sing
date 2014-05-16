

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


/**
 * Compile-error (any usecase?)
 */
object Error {
    def apply(): scala.Unit = macro ErrorImpl.termMacro
}


class ErrorImpl(val c: Context) {
    import c.universe._

    def termMacro(): c.Tree = {
        _impl()
        q"()"
    }

    def typeMacro(): c.Tree = {
        _impl()
        tq"_root_.scala.Unit"
    }

    private def _impl(): c.Tree = {
        c.abort(c.enclosingPosition, "compile-error expectedly")
    }
}
