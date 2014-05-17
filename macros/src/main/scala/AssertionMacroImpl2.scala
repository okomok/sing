

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait AssertionMacroImpl2 extends InContext {
    protected def assertionTypeOnly(x: c.Type, y: c.Type): AssertionResult = ???
    protected def assertionTermImpl(x: c.Tree, y: c.Tree): AssertionResult = assertionTypeOnly(x.tpe, y.tpe)
    protected def assertionTypeImpl(x: c.Tree, y: c.Tree): AssertionResult = assertionTypeOnly(x.tpe, y.tpe)

    import c.universe._

    final def termMacro_[x, y](implicit x: c.WeakTypeTag[x], y: c.WeakTypeTag[y]): c.Tree = {
        assertionTypeImpl(TypeTree(x.tpe), TypeTree(y.tpe)) match {
            case AssertionFailure(msg) => CompileError.assertError(c)(msg)
            case _ => q"_root_.scala.Unit"
        }
    }

    final def termMacro(x: c.Tree, y: c.Tree): c.Tree = {
        assertionTermImpl(x, y) match {
            case AssertionFailure(msg) => CompileError.assertError(c)(msg)
            case _ => q"()"
        }
    }

    final def typeMacro(x: c.Tree, y: c.Tree): c.Tree = {
        assertionTypeImpl(x, y) match {
            case AssertionFailure(msg) => CompileError.assertError(c)(msg)
            case _ => tq"_root_.scala.Unit"
        }
    }
}
