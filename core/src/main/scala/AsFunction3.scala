

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import function._


trait AsFunction3 extends Function3 with AsAny with RefEquals {
    override  def asFunction3: asFunction3 = self
    override type asFunction3              = self

    override  def apply[v1 <: Any, v2 <: Any, v3 <: Any](v1: v1, v2: v2, v3: v3): apply[v1, v2, v3]
    override type apply[v1 <: Any, v2 <: Any, v3 <: Any] <: Any

    override  def curried: curried = Curried3.Impl(self)
    override type curried          = Curried3.Impl[self]

    override  def tupled: tupled = Tupled3.Impl(self)
    override type tupled         = Tupled3.Impl[self]

    override  def tupledLeft: tupledLeft = TupledLeft3.Impl(self)
    override type tupledLeft             = TupledLeft3.Impl[self]

    override  def not: not = Not3.Impl(self)
    override type not      = Not3.Impl[self]
}
