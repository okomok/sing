

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


trait AssertImpl1 {
    val c: Context
    protected def assert_type_only(x: c.Type): AssertResult = ???
    protected def assert_term_impl(x: c.Tree): AssertResult = assert_type_only(x.tpe)
    protected def assert_type_impl(x: c.Tree): AssertResult = assert_type_only(x.tpe)

    import c.universe._

    final def term_impl_[x](implicit x: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._
        type_impl(TypeTree(x.tpe))
        q"()"
    }

    final def term_impl(x: c.Tree): c.Tree = {
        assert_term_impl(x) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => q"()"
        }
    }

    final def type_impl(x: c.Tree): c.Tree = {
        assert_type_impl(x) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => tq"_root_.scala.Unit"
        }
    }
}
