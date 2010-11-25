

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


import function._


trait Function2 extends Any with ReferenceEquality {
    type self <: Function2

    final override  def asFunction2: asFunction2 = self
    final override type asFunction2              = self

     def apply[v1 <: Any, v2 <: Any](v1: v1, v2: v2): apply[v1, v2]
    type apply[v1 <: Any, v2 <: Any] <: Any

    final  def curried: curried = Curried2.Impl(self)
    final type curried          = Curried2.Impl[self]

    final  def tupled: tupled = Tupled2.Impl(self)
    final type tupled         = Tupled2.Impl[self]

    final  def not: not = Not2.Impl(self)
    final type not      = Not2.Impl[self]
}
