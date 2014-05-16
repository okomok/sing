

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


trait DependentImpl2 {
    val c: Context
    protected def dep_term_impl(x: c.Tree, y: c.Tree): c.Tree
    protected def dep_type_impl(x: c.Tree, y: c.Tree): c.Tree

    import c.universe._

    final def term_impl_[x, y](implicit x: c.WeakTypeTag[x], y: c.WeakTypeTag[y]): c.Tree = {
        type_impl(TypeTree(x.tpe), TypeTree(y.tpe))
    }

    final def term_impl(x: c.Tree, y: c.Tree): c.Tree = {
        val v = dep_term_impl(x, y)
        q"${here(c)}.DependentTerm.of($v)"
    }

    final def type_impl(x: c.Tree, y: c.Tree): c.Tree = {
        val t = dep_type_impl(x, y)
        q"${here(c)}.DependentType.of[$t]"
    }
}
