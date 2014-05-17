

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object NoSuchElement {
    def apply(x: String): scala.Any = macro NoSuchElementImpl.termMacro
}


final class NoSuchElementImpl(override val c: Context) extends TypeThrowMacroImpl {
    import c.universe._

    override protected def what: c.Tree = {
        tq"_root_.java.util.NoSuchElementException"
    }
}
