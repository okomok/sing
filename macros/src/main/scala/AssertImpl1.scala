

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


trait AssertImpl1 {
    protected def assert_type_only(c: Context)(x: c.Type): AssertResult = ???
    protected def assert_term_impl(c: Context)(x: c.Tree): AssertResult = assert_type_only(c)(x.tpe)
    protected def assert_type_impl(c: Context)(x: c.Tree): AssertResult = assert_type_only(c)(x.tpe)

    final def term_impl_[x](c: Context)(implicit x: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._
        type_impl(c)(TypeTree(x.tpe))
        q"()"
    }

    final def term_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        assert_term_impl(c)(x) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => q"()"
        }
    }

    final def type_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        assert_type_impl(c)(x) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => tq"_root_.scala.Unit"
        }
    }
}
