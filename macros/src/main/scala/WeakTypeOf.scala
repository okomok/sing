

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object WeakTypeOf extends DependentImpl1 {
    def apply(x: Unspecified): Unspecified = macro term_impl

    override protected def dep_term_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        c.typecheck(x)
        x
    }

    override protected def dep_type_impl(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._

        c.typecheck(x)
        TypeTree(x.tpe)
    }
}
