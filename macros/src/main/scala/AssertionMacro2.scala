

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait AssertionMacro2 extends SingMacro2 {
    protected def assertionTypeOnly(x: c.Type, y: c.Type): AssertionResult = ???
    protected def assertionTermImpl(x: c.Tree, y: c.Tree): AssertionResult = assertionTypeOnly(x.tpe, y.tpe)
    protected def assertionTypeImpl(x: c.Tree, y: c.Tree): AssertionResult = assertionTypeOnly(x.tpe, y.tpe)

    import c.universe._

    final def termMacro_[x, y](implicit x: c.WeakTypeTag[x], y: c.WeakTypeTag[y]): c.Tree = {
        typeMacro(TypeTree(x.tpe), TypeTree(y.tpe))
        q"()"
    }

    final override protected def termMacroImpl(x: c.Tree, y: c.Tree): c.Tree = {
        assertionTermImpl(x, y) match {
            case AssertionFailure(msg) => CompileError.assertError(c)(msg)
            case _ => q"()"
        }
    }

    final override protected def typeMacroImpl(x: c.Tree, y: c.Tree): c.Tree = {
        assertionTypeImpl(x, y) match {
            case AssertionFailure(msg) => CompileError.assertError(c)(msg)
            case _ => tq"_root_.scala.Unit"
        }
    }
}
