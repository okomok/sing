

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Unsupported {
    def apply(x: String): scala.Any = macro UnsupportedImpl.termMacro
}


final class UnsupportedImpl(override val c: Context) extends TypeThrowMacroImpl {
    import c.universe._

    override protected def what: c.Tree = {
        tq"_root_.java.lang.UnsupportedOperationException"
    }
}
