

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


trait DependentImpl2 {
    val c: Context
    protected def dep_term_impl(x: c.Tree, y: c.Tree): c.Tree
    protected def dep_type_impl(x: c.Tree, y: c.Tree): c.Tree

    import c.universe._

    final def term_impl(x: c.Tree, y: c.Tree): c.Tree = {
        val v = dep_term_impl(x, y)
        q"${here(c)}.DependentType($v)"
    }
}
