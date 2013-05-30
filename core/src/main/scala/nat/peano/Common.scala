

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat; package peano


private[sing]
class Common extends CommonLiteral {
    @annotation.returnThis
    val Literal: CommonLiteral = this

    @annotation.equivalentTo("new Zero{}")
    val Zero = _Peano.Zero
}
