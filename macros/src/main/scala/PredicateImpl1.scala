

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


trait PredicateImpl1 extends DependentImpl1 {
    protected def pred_type_only(c: Context)(x: c.Type): Boolean = ???
    protected def pred_term_impl(c: Context)(x: c.Tree): Boolean = pred_type_only(c)(x.tpe)
    protected def pred_type_impl(c: Context)(x: c.Tree): Boolean = pred_type_only(c)(x.tpe)

    final def term_impl_[x](c: Context)(implicit x: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._

        if (pred_type_impl(c)(TypeTree(x.tpe))) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }
    }

    final override protected def dep_term_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        if (pred_term_impl(c)(x)) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }
    }

    final override protected def dep_type_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        if (pred_type_impl(c)(x)) {
            tq"${sing_(c)}.`true`"
        } else {
            tq"${sing_(c)}.`false`"
        }
    }
}
