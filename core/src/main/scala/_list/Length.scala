

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _list


import Dense._0

private[sing]
object Length {
     def apply[xs <: List](xs: xs): apply[xs] = `if`(xs.isEmpty, Const(_0), Else(xs)).apply.asNat
    type apply[xs <: List]                    = `if`[xs#isEmpty, Const[_0], Else[xs]]#apply#asNat

    case class Else[xs <: List](xs: xs) extends AsFunction0 {
        override type self = Else[xs]
        override  def apply: apply = Length.apply(id(xs).tail).increment
        override type apply        = Length.apply[id[xs]#tail]#increment
    }
}
