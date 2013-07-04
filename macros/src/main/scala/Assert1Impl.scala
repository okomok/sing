

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


trait Assert1Impl {
    protected def inTerm(c: Context)(xx: Duo[c.type]): AssertResult = inType(c)(xx.typ)

    protected def inType(c: Context)(x: c.Type): AssertResult

    final def term_impl_[x](c: Context)(implicit tx: c.WeakTypeTag[x]): c.Expr[Unit] = {
        import c.universe._

        _type_impl(c)(tx)
        c.literalUnit
    }

    final def term_impl[x](c: Context)(x: c.Expr[x])(implicit tx: c.WeakTypeTag[x]): c.Expr[Unit] = {
        import c.universe._

        _term_impl(c)(x)(tx)
        c.literalUnit
    }

    final def type_impl[x](c: Context)(implicit tx: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._

        _type_impl(c)(tx)
        tq"_root_.scala.Unit"
    }

    final def _type_impl[x](c: Context)(tx: c.WeakTypeTag[x]): Unit = {
        import c.universe._

        inType(c)(tx.tpe) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => ()
        }
    }

    final def _term_impl[x](c: Context)(x: c.Expr[x])(tx: c.WeakTypeTag[x]): Unit = {
        import c.universe._

        val xx = Duo[c.type](x, tx.tpe)
        inTerm(c)(xx) match {
            case AssertFailure(msg) => CompileError.assertError(c)(msg)
            case _ => ()
        }
    }
}
