

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait AssertionMacro1 extends SingMacro1 {
    protected def assertionTypeOnly(x: c.Type): AssertionResult = ???
    protected def assertionTermImpl(x: c.Tree): AssertionResult = assertionTypeOnly(x.tpe)
    protected def assertionTypeImpl(x: c.Tree): AssertionResult = assertionTypeOnly(x.tpe)

    import c.universe._

    final def termMacro_[x](implicit x: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._
        typeMacro(TypeTree(x.tpe))
        q"()"
    }

    final override protected def termMacroImpl(x: c.Tree): c.Tree = {
        assertionTermImpl(x) match {
            case AssertionFailure(msg) => CompileError.assertError(c)(msg)
            case _ => q"()"
        }
    }

    final override protected def typeMacroImpl(x: c.Tree): c.Tree = {
        assertionTypeImpl(x) match {
            case AssertionFailure(msg) => CompileError.assertError(c)(msg)
            case _ => tq"_root_.scala.Unit"
        }
    }
}
