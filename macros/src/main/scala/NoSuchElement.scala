

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object NoSuchElement extends TypeThrow {
    def apply(x: String): Unspecified = macro term_impl

    override protected def what(c: Context): c.Tree = {
        import c.universe._
        tq"_root_.java.util.NoSuchElementException"
    }
}
