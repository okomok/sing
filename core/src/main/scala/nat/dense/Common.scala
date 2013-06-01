

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package nat; package dense


private[sing]
class Common extends CommonLiteral {
    @Annotation.returnThis
    val Literal: CommonLiteral = this

    @Annotation.equivalentTo("new Nil{}")
    val Nil: Nil = _Dense.Nil

    @Annotation.aliasOf("Cons")
     val :: = Cons
    type ::[x <: Boolean, xs <: Dense] = Cons[x, xs]
}
