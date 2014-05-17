

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait PredicateMacroImpl1 extends InContext {
    protected def predicateTypeOnly(x: c.Type): scala.Boolean = ???
    protected def predicateTermImpl(x: c.Tree): scala.Boolean = predicateTypeOnly(x.tpe)
    protected def predicateTypeImpl(x: c.Tree): scala.Boolean = predicateTypeOnly(x.tpe)

    import c.universe._

    final def termMacro_[x](implicit x: c.WeakTypeTag[x]): c.Tree = {
        if (predicateTypeImpl(TypeTree(x.tpe))) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }
    }

    final def termMacro(x: c.Tree): c.Tree = {
        if (predicateTermImpl(x)) {
            q"${sing_(c)}.`true`"
        } else {
            q"${sing_(c)}.`false`"
        }
    }

    final def typeMacro(x: c.Tree): c.Tree = {
        if (predicateTypeImpl(x)) {
            tq"${sing_(c)}.`true`"
        } else {
            tq"${sing_(c)}.`false`"
        }
    }
}
