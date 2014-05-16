

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


/**
 * @return `true` if x conforms to y. `false` otherwise.
 */
object Conforms {
    def apply[x, y]                      : scala.Any = macro ConformsImpl.termMacro_[x, y]
    def apply(x: scala.Any, y: scala.Any): scala.Any = macro ConformsImpl.termMacro
}


class ConformsImpl(override val c: Context) extends PredicateMacro2 {
    import c.universe._
    override protected def predicateTypeOnly(x: c.Type, y: c.Type): scala.Boolean = x <:< y
}
