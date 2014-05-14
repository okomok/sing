

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


trait TypeThrow extends DependentImpl1 {
    protected def what(c: Context): c.Tree

    final override protected def dep_term_impl(c: Context)(msg: c.Tree): c.Tree = {
        import c.universe._

        val ret = dep_type_impl(c)(msg)

        q"""
            (throw new ${what(c)}(${msg})): $ret
        """
    }

    final override protected def dep_type_impl(c: Context)(msg: c.Tree): c.Tree = {
        import c.universe._

        tq"""
            _root_.scala.Nothing with ${what(c)}
        """
        // with ${ConstantTypeOf.term_impl(c)(msg)}
    }
}
