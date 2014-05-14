

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.reflect.macros.whitebox.Context


trait TypedDependentImpl1[T] {
    protected def dep_extract(c: Context)(x: c.Tree): T
    protected def dep_term_impl(c: Context)(x: T): c.Tree
    protected def dep_type_impl(c: Context)(x: T): c.Tree

    final def term_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        val y = dep_extract(c)(x)
        val v = dep_term_impl(c)(y)
        q"${here(c)}.DependentType($v)"
    }
}
