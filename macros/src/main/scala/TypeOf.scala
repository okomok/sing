

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


final class TypeOfImpl(val c: Context) {
    def termMacro(x: c.Tree): c.Tree = TermWrapper(c)(x)
}
