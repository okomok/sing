

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing; package nat; package peano


private[sing]
class Common extends CommonLiteral {
    @annotation.returnThis
    val Literal: CommonLiteral = this

    @annotation.equivalentTo("new Zero{}")
    val Zero = _Peano.Zero
}
