

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object NoSuchElement extends TypeThrow {
     def apply(msg: String) = macro term_impl
    type apply(msg: String) = macro type_impl

    override protected def what(c: Context): c.Tree = {
        import c.universe._
        tq"_root_.java.util.NoSuchElementException"
    }
}
