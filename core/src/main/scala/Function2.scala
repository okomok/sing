

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait Function2 extends Any with RefEquals {
    override type self <: Function2

     def apply[v1 <: Any, v2 <: Any](v1: v1, v2: v2): apply[v1, v2]
    type apply[v1 <: Any, v2 <: Any] <: Any

     def curried: curried
    type curried <: Function1

     def tupled: tupled
    type tupled  <: Function1

     def not: not
    type not <: Function2
}
