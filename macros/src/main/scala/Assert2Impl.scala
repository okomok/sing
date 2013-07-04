

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


trait Assert2Impl {
    protected def inTerm(c: Context)(xx: Duo[c.type], yy: Duo[c.type]): AssertResult = inType(c)(xx.tpe, yy.tpe)

    protected def inType(c: Context)(x: c.Type, y: c.Type): AssertResult

    final def term_impl_[x, y](c: Context)(implicit tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): c.Expr[Unit] = {
        import c.universe._

        _type_impl(c)(tx, ty)
        c.literalUnit
    }

    final def term_impl[x, y](c: Context)(x: c.Expr[x], y: c.Expr[y])(implicit tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): c.Expr[Unit] = {
        import c.universe._

        _term_impl(c)(x, y)(tx, ty)
        c.literalUnit
    }

    final def type_impl[x, y](c: Context)(implicit tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): c.Tree = {
        import c.universe._

        _type_impl(c)(tx, ty)
        tq"_root_.scala.Unit"
    }

    final def _type_impl[x, y](c: Context)(tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): Unit = {
        import c.universe._

        inType(c)(tx.tpe, ty.tpe) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => ()
        }
    }

    final def _term_impl[x, y](c: Context)(x: c.Expr[x], y: c.Expr[y])(tx: c.WeakTypeTag[x], ty: c.WeakTypeTag[y]): Unit = {
        import c.universe._

        val xx = Duo[c.type](x, tx.tpe)
        val yy = Duo[c.type](y, ty.tpe)
        inTerm(c)(xx, yy) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => ()
        }
    }
}
