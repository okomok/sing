

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


trait AssertImpl2 {
    protected def assert_type_only(c: Context)(x: c.Type, y: c.Type): AssertResult = ???
    protected def assert_term_impl(c: Context)(x: c.Tree, y: c.Tree): AssertResult = assert_type_only(c)(x.tpe, y.tpe)
    protected def assert_type_impl(c: Context)(x: c.Tree, y: c.Tree): AssertResult = assert_type_only(c)(x.tpe, y.tpe)

    final def term_impl_[x, y](c: Context)(implicit x: c.WeakTypeTag[x], y: c.WeakTypeTag[y]): c.Tree = {
        import c.universe._
        type_impl(c)(TypeTree(x.tpe), TypeTree(y.tpe))
        q"()"
    }

    final def term_impl(c: Context)(x: c.Tree, y: c.Tree): c.Tree = {
        import c.universe._

        assert_term_impl(c)(x, y) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => q"()"
        }
    }

    final def type_impl(c: Context)(x: c.Tree, y: c.Tree): c.Tree = {
        import c.universe._

        assert_type_impl(c)(x, y) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => tq"_root_.scala.Unit"
        }
    }
}
