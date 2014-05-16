

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


trait AssertImpl2 {
    val c: Context
    protected def assert_type_only(x: c.Type, y: c.Type): AssertResult = ???
    protected def assert_term_impl(x: c.Tree, y: c.Tree): AssertResult = assert_type_only(x.tpe, y.tpe)
    protected def assert_type_impl(x: c.Tree, y: c.Tree): AssertResult = assert_type_only(x.tpe, y.tpe)

    import c.universe._

    final def term_impl_[x, y](implicit x: c.WeakTypeTag[x], y: c.WeakTypeTag[y]): c.Tree = {
        type_impl(TypeTree(x.tpe), TypeTree(y.tpe))
        q"()"
    }

    final def term_impl(x: c.Tree, y: c.Tree): c.Tree = {
        assert_term_impl(x, y) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => q"()"
        }
    }

    final def type_impl(x: c.Tree, y: c.Tree): c.Tree = {
        assert_type_impl(x, y) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => tq"_root_.scala.Unit"
        }
    }
}
