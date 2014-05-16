

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


trait PredicateImpl1 extends DependentImpl1 {
    val c: Context
    protected def pred_type_only(x: c.Type): Boolean = ???
    protected def pred_term_impl(x: c.Tree): Boolean = pred_type_only(x.tpe)
    protected def pred_type_impl(x: c.Tree): Boolean = pred_type_only(x.tpe)

    import c.universe._

    final def term_impl_[x](implicit x: c.WeakTypeTag[x]): c.Tree = {
        if (pred_type_impl(TypeTree(x.tpe))) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }
    }

    final override protected def dep_term_impl(x: c.Tree): c.Tree = {
        import c.universe._

        if (pred_term_impl(x)) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }
    }

    final override protected def dep_type_impl(x: c.Tree): c.Tree = {
        import c.universe._

        if (pred_type_impl(x)) {
            tq"${sing_(c)}.`true`"
        } else {
            tq"${sing_(c)}.`false`"
        }
    }
}
