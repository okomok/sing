

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait UntypedMacro extends InContext {
    protected def untypedImpl(x: c.Tree): c.Tree

    import c.universe._

    final def untyped(x: c.Tree): c.Tree = {
        val code = ExtractString(c)(x)
        untypedImpl(c.parse(code))
    }
}
