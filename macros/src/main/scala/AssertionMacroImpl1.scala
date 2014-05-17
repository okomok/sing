

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait AssertionMacroImpl1 extends InContext {
    protected def assertionTypeOnly(x: c.Type): AssertionResult = ???
    protected def assertionTermImpl(x: c.Tree): AssertionResult = assertionTypeOnly(x.tpe)
    protected def assertionTypeImpl(x: c.Tree): AssertionResult = assertionTypeOnly(x.tpe)

    import c.universe._

    final def termMacro_[x](implicit x: c.WeakTypeTag[x]): c.Tree = {
        assertionTypeImpl(TypeTree(x.tpe)) match {
            case AssertionFailure(msg) => CompileError.assertError(c)(msg)
            case _ => q"()"
        }
    }

    final def termMacro(x: c.Tree): c.Tree = {
        assertionTermImpl(x) match {
            case AssertionFailure(msg) => CompileError.assertError(c)(msg)
            case _ => q"()"
        }
    }

    final def typeMacro(x: c.Tree): c.Tree = {
        assertionTypeImpl(x) match {
            case AssertionFailure(msg) => CompileError.assertError(c)(msg)
            case _ => tq"_root_.scala.Unit"
        }
    }
}
