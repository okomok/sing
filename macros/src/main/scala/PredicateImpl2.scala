

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


trait PredicateImpl2 extends DependentImpl2 {
    val c: Context
    protected def pred_type_only(x: c.Type, y: c.Type): Boolean = ???
    protected def pred_term_impl(x: c.Tree, y: c.Tree): Boolean = pred_type_only(x.tpe, y.tpe)
    protected def pred_type_impl(x: c.Tree, y: c.Tree): Boolean = pred_type_only(x.tpe, y.tpe)

    import c.universe._

    final override protected def dep_term_impl(x: c.Tree, y: c.Tree): c.Tree = {
        if (pred_term_impl(x, y)) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }
    }

    final override protected def dep_type_impl(x: c.Tree, y: c.Tree): c.Tree = {
        if (pred_type_impl(x, y)) {
            tq"${sing_(c)}.`true`"
        } else {
            tq"${sing_(c)}.`false`"
        }
    }
}
