

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


object IsAbstract {
    def apply[x]           : scala.Any = macro IsAbstractImpl.termMacro_[x]
    def apply(x: scala.Any): scala.Any = macro IsAbstractImpl.termMacro
}


class IsAbstractImpl(override val c: Context) extends PredicateMacro1 {
    override protected def predicateTypeOnly(x: c.Type): scala.Boolean = IsAbstractType(c)(x)
}
