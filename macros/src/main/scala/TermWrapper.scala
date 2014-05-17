

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


import scala.reflect.macros.whitebox.Context


trait TermWrapper extends TypeWrapper {
    def unwrap: unwrap
}


object TermWrapper {
    def apply(c: Context)(x: c.Tree): c.Tree = {
        import c.universe._
        q"${sing_(c)}.TermWrapper.of($x)"
    }

    def of[x](x: x): of[x] = new TermWrapper {
        override  def unwrap: unwrap = x
        override type unwrap         = x
    }

    type of[x] = TermWrapper {
        type unwrap = x
    }
}
