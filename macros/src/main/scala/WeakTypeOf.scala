

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object WeakTypeOf {
    def apply(x: Unspecified): Unspecified = macro WeakTypeOfImpl.term_impl
}

class WeakTypeOfImpl(override val c: Context) extends DependentImpl1 {
    import c.universe._

    override protected def dep_term_impl(x: c.Tree): c.Tree = x
    override protected def dep_type_impl(x: c.Tree): c.Tree = TypeTree(x.tpe)
}
