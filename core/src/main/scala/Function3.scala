

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait Function3 extends Any {
    override type self <: Function3

    override  def asFunction3: asFunction3 = self
    override type asFunction3              = self

     def apply[v1 <: Any, v2 <: Any, v3 <: Any](v1: v1, v2: v2, v3: v3): apply[v1, v2, v3]
    type apply[v1 <: Any, v2 <: Any, v3 <: Any] <: Any

     def curried: curried
    type curried <: Function1

     def tupled: tupled
    type tupled <: Function1

     def tupledLeft: tupledLeft
    type tupledLeft <: Function1

     def not: not
    type not <: Function3
}
