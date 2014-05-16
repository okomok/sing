

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait TermMacro2 extends InContext {
    protected def termMacroImpl(x: c.Tree, y: c.Tree): c.Tree

    import c.universe._

    final def termMacro(x: c.Tree, y: c.Tree): c.Tree = {
        val v = termMacroImpl(x, y)
        q"${sing_(c)}.TermWrapper.of($v)"
    }
}
