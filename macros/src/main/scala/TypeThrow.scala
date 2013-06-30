

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.Context


trait TypeThrow {
    protected def what(c: Context): c.Tree

    final def term_impl(c: Context)(msg: c.Expr[String]): c.Expr[Nothing] = {
        import c.universe._

        // val ret = type_impl(c)(msg)

        val res = q"""
            throw new ${what(c)}(${msg.tree})//.asInstanceOf[ret] ~ crash.
        """

        c.Expr[Nothing](res)
    }

    final def type_impl(c: Context)(msg: c.Expr[String]): c.Tree = {
        import c.universe._

        tq"""
            _root_.scala.Nothing with ${what(c)} with ${ConstantTypeOf.impl(c)(msg)}
        """
    }
}
