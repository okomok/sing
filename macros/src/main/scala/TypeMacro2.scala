

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait TypeMacro2 extends InContext {
    protected def typeMacroImpl(x: c.Tree, y: c.Tree): c.Tree

    import c.universe._

    final def typeMacro(x: c.Tree, y: c.Tree): c.Tree = {
        val t = typeMacroImpl(x, y)
        q"${sing_(c)}.TypeWrapper.of[$t]"
    }
}
