

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import function._


trait Function3 extends Any with ReferenceEquality {
    type self <: Function3

    final override  def asFunction3: asFunction3 = self
    final override type asFunction3              = self

     def apply[v1 <: Any, v2 <: Any, v3 <: Any](v1: v1, v2: v2, v3: v3): apply[v1, v2, v3]
    type apply[v1 <: Any, v2 <: Any, v3 <: Any] <: Any

    @deprecated("use Function3.curried instead", "0.1.1")
    final  def curried: curried = Curried3.Impl(self)
    final type curried          = Curried3.Impl[self]

    @deprecated("use Function3.tupled instead", "0.1.1")
    final  def tupled: tupled = Tupled3.Impl(self)
    final type tupled         = Tupled3.Impl[self]

    @deprecated("use Function3.tupledLeft instead", "0.1.1")
    final  def tupledLeft: tupledLeft = TupledLeft3.Impl(self)
    final type tupledLeft             = TupledLeft3.Impl[self]

    @deprecated("use Function3.not instead", "0.1.1")
    final  def not: not = Not3.Impl(self)
    final type not      = Not3.Impl[self]
}


object Function3 {

     def curried[self <: Function3](self: self): curried[self] = Curried3.Impl(self)
    type curried[self <: Function3]                           = Curried3.Impl[self]

     def tupled[self <: Function3](self: self): tupled[self] = Tupled3.Impl(self)
    type tupled[self <: Function3]                           = Tupled3.Impl[self]

     def tupledLeft[self <: Function3](self: self): tupledLeft[self] = TupledLeft3.Impl(self)
    type tupledLeft[self <: Function3]                               = TupledLeft3.Impl[self]

     def not[self <: Function3](self: self): not[self] = Not3.Impl(self)
    type not[self <: Function3]                        = Not3.Impl[self]

}
