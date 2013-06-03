

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait Function1 extends Any with RefEquals {
    override type self <: Function1

     def apply[v1 <: Any](v1: v1): apply[v1]
    type apply[v1 <: Any] <: Any

     def compose[that <: Function1](that: that): compose[that]
    type compose[that <: Function1] <: Function1

     def andThen[that <: Function1](that: that): andThen[that]
    type andThen[that <: Function1] <: Function1

     def not: not
    type not <: Function1
}
