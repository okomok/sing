

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


import function._


trait Function1 extends Any with ReferenceEquality {
    type self <: Function1

    final override  def asFunction1: asFunction1 = self
    final override type asFunction1              = self

     def apply[v1 <: Any](v1: v1): apply[v1]
    type apply[v1 <: Any] <: Any

    @deprecated("use Function1.compose instead", "0.1.1")
    final  def compose[that <: Function1](that: that): compose[that] = Compose.Impl(self, that)
    final type compose[that <: Function1]                            = Compose.Impl[self, that]

    @deprecated("use Function1.andThen instead", "0.1.1")
    final  def andThen[that <: Function1](that: that): andThen[that] = Compose.Impl(that, self)
    final type andThen[that <: Function1]                            = Compose.Impl[that, self]

    @deprecated("use Function1.not instead", "0.1.1")
    final  def not: not = Not1.Impl(self)
    final type not      = Not1.Impl[self]
}


object Function1 {

    // A metamethod call `f#not` doesn't compile in complicated expressions.
    // We should have provided `AbstractFunction1`...

     def compose[self <: Function1, that <: Function1](self: self, that: that): compose[self, that] = Compose.Impl(self, that)
    type compose[self <: Function1, that <: Function1]                                               = Compose.Impl[self, that]

     def andThen[self <: Function1, that <: Function1](self:self, that: that): andThen[self, that] = Compose.Impl(that, self)
    type andThen[self <: Function1, that <: Function1]                                             = Compose.Impl[that, self]

     def not[self <: Function1](self: self): not[self] = Not1.Impl(self)
    type not[self <: Function1]                        = Not1.Impl[self]

}
