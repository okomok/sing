

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


trait DependentImpl1 {
    protected def dep_term_impl(c: Context)(x: c.Tree): c.Tree
    protected def dep_type_impl(c: Context)(x: c.Tree): c.Tree

    final def dep_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        val v = dep_term_impl(c)(x)
        val t = dep_type_impl(c)(x)

        q"""
            new ${here(c)}.DependentType {
                override  val apply: apply = $v
                override type apply        = $t
            }
        """
    }
}
