

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Error {
    def apply: Unit = macro ErrorImpl.term_impl
}

class ErrorImpl(val c: Context) {
    import c.universe._

    def term_impl: c.Tree = {
        _impl()
        q"()"
    }

    def type_impl: c.Tree = {
        _impl()
        tq"_root_.scala.Unit"
    }

    private def _impl(): c.Tree = {
        c.abort(c.enclosingPosition, "compile-error expectedly")
    }
}
