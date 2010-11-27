

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

    final  def compose[that <: Function1](that: that): compose[that] = Compose.Impl(self, that)
    final type compose[that <: Function1]                            = Compose.Impl[self, that]

    final  def andThen[that <: Function1](that: that): andThen[that] = Compose.Impl(that, self)
    final type andThen[that <: Function1]                            = Compose.Impl[that, self]

    final  def not: not = Not1.Impl(self)
    final type not      = Not1.Impl[self]
}
