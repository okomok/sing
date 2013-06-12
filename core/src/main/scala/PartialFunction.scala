

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object PartialFunction {

    final class empty extends AsPartialFunction {
        override type self = empty
        override  def isDefinedAt[x <: Any](x: x): isDefinedAt[x] = `false`
        override type isDefinedAt[x <: Any]                       = `false`
        override  def apply[x <: Any](x: x): apply[x] = unsupported("PartialFunction.empty.apply")
        override type apply[x <: Any] <: Nothing
    }
    lazy val empty: empty = new empty
}


trait PartialFunction extends Function1 {
    override type self <: PartialFunction

     def isDefinedAt[x <: Any](x: x): isDefinedAt[x]
    type isDefinedAt[x <: Any] <: Boolean

     def orElse[that <: PartialFunction](that: that): orElse[that]
    type orElse[that <: PartialFunction] <: PartialFunction

     def lift: lift
    type lift <: Function1

     def applyOrElse[x <: Any, d <: Function1](x: x, d: d): applyOrElse[x, d]
    type applyOrElse[x <: Any, d <: Function1] <: Any

    override type andThen[that <: Function1] <: PartialFunction
    override type not <: PartialFunction
}
