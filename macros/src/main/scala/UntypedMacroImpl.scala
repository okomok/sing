

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait UntypedMacroImpl extends InContext {
    protected def untypedMacroImpl(x: c.Tree): c.Tree

    final def untypedMacro(x: c.Tree): c.Tree = {
        val code = ExtractString(c)(x)
        untypedMacroImpl(c.parse(code))
    }
}
