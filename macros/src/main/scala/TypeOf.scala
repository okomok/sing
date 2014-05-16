

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context


/**
 * Weak type of an expression
 */
object TypeOf {
    def apply(x: scala.Any): scala.Any = macro TypeOfImpl.termMacro
}


class TypeOfImpl(override val c: Context) extends DepMacro1 {
    import c.universe._
    override protected def termMacroImpl(x: c.Tree): c.Tree = x
    override protected def typeMacroImpl(x: c.Tree): c.Tree = TypeTree(x.tpe)
}
