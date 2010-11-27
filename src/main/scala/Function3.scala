

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


import function._


trait Function3 extends Any with ReferenceEquality {
    type self <: Function3

    final override  def asFunction3: asFunction3 = self
    final override type asFunction3              = self

     def apply[v1 <: Any, v2 <: Any, v3 <: Any](v1: v1, v2: v2, v3: v3): apply[v1, v2, v3]
    type apply[v1 <: Any, v2 <: Any, v3 <: Any] <: Any

    final  def curried: curried = Curried3.Impl(self)
    final type curried          = Curried3.Impl[self]

    final  def tupled: tupled = Tupled3.Impl(self)
    final type tupled         = Tupled3.Impl[self]

    final  def tupledLeft: tupledLeft = TupledLeft3.Impl(self)
    final type tupledLeft             = TupledLeft3.Impl[self]

    final  def not: not = Not3.Impl(self)
    final type not      = Not3.Impl[self]
}
