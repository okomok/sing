

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.reflect.macros.whitebox.Context


trait TypeThrowImpl extends DependentImpl1 {
    protected def what: c.Tree

    import c.universe._

    final override protected def dep_term_impl(msg: c.Tree): c.Tree = {
        val ret = dep_type_impl(msg)
        q"""
            (throw new ${what}(${msg})): $ret
        """
    }

    final override protected def dep_type_impl(msg: c.Tree): c.Tree = {
        tq"""
            _root_.scala.Nothing with ${what}
        """
        // with ${ConstantTypeOf.term_impl(c)(msg)}
    }
}
