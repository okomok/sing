

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Unsupported {
    def apply(x: String): Unspecified = macro UnsupportedImpl.term_impl
}

class UnsupportedImpl(override val c: Context) extends TypeThrowImpl {
    import c.universe._

    override protected def what: c.Tree = {
        tq"_root_.java.lang.UnsupportedOperationException"
    }
}
