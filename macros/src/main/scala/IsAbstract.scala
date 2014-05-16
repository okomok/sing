

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing.makro


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object IsAbstract {
    def apply[x]             : Unspecified = macro IsAbstractImpl.term_impl_[x]
    def apply(x: Unspecified): Unspecified = macro IsAbstractImpl.term_impl
}

class IsAbstractImpl(override val c: Context) extends PredicateImpl1 {
    import c.universe._
    override protected def pred_type_only(x: c.Type): Boolean = IsAbstractType(c)(x)
}
