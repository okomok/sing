

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import function._


trait AsFunction1 extends Function1 with AsAny with RefEquals {
    override  def asFunction1: asFunction1 = self
    override type asFunction1              = self

    override  def compose[that <: Function1](that: that): compose[that] = Compose.Impl(self, that)
    override type compose[that <: Function1]                            = Compose.Impl[self, that]

    override  def andThen[that <: Function1](that: that): andThen[that] = Compose.Impl(that, self)
    override type andThen[that <: Function1]                            = Compose.Impl[that, self]

    override  def not: not = Not1.Impl(self)
    override type not      = Not1.Impl[self]
}
