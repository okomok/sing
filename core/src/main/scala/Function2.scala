

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import function._


trait Function2 extends Any with ReferenceEquality {
    type self <: Function2

    final override  def asFunction2: asFunction2 = self
    final override type asFunction2              = self

     def apply[v1 <: Any, v2 <: Any](v1: v1, v2: v2): apply[v1, v2]
    type apply[v1 <: Any, v2 <: Any] <: Any

    @deprecated("use Function2.curried instead", "0.1.1")
    final  def curried: curried = Curried2.Impl(self)
    final type curried          = Curried2.Impl[self]

    @deprecated("use Function2.tupled instead", "0.1.1")
    final  def tupled: tupled = Tupled2.Impl(self)
    final type tupled         = Tupled2.Impl[self]

    @deprecated("use Function2.not instead", "0.1.1")
    final  def not: not = Not2.Impl(self)
    final type not      = Not2.Impl[self]
}


object Function2 {

     def curried[self <: Function2](self: self): curried[self] = Curried2.Impl(self)
    type curried[self <: Function2]                            = Curried2.Impl[self]

     def tupled[self <: Function2](self: self): tupled[self] = Tupled2.Impl(self)
    type tupled[self <: Function2]                           = Tupled2.Impl[self]

     def not[self <: Function2](self: self): not[self] = Not2.Impl(self)
    type not[self <: Function2]                        = Not2.Impl[self]

}
