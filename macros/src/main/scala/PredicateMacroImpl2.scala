

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait PredicateMacroImpl2 extends InContext {
    protected def predicateTypeOnly(x: c.Type, y: c.Type): scala.Boolean = ???
    protected def predicateTermImpl(x: c.Tree, y: c.Tree): scala.Boolean = predicateTypeOnly(x.tpe, y.tpe)
    protected def predicateTypeImpl(x: c.Tree, y: c.Tree): scala.Boolean = predicateTypeOnly(x.tpe, y.tpe)

    import c.universe._

    final def termMacro_[x, y](implicit x: c.WeakTypeTag[x], y: c.WeakTypeTag[y]): c.Tree = {
        if (predicateTypeImpl(TypeTree(x.tpe), TypeTree(y.tpe))) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }
    }

    final def termMacro(x: c.Tree, y: c.Tree): c.Tree = {
        if (predicateTermImpl(x, y)) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }
    }

    final def typeMacro(x: c.Tree, y: c.Tree): c.Tree = {
        if (predicateTypeImpl(x, y)) {
            tq"${sing_(c)}.`true`"
        } else {
            tq"${sing_(c)}.`false`"
        }
    }
}
