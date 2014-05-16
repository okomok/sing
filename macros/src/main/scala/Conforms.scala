

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object Conforms {
    def apply[x, y]                          : Unspecified = macro ConformsImpl.term_impl_[x, y]
    def apply(x: Unspecified, y: Unspecified): Unspecified = macro ConformsImpl.term_impl
}

class ConformsImpl(override val c: Context) extends PredicateImpl2 {
    import c.universe._
    override protected def pred_type_only(x: c.Type, y: c.Type): Boolean = x <:< y
}
