

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing; package _list


private[sing]
object CaseNil {
     def apply[xs <: List, ifNil <: Function0, _else <: Function2](xs: xs, ifNil: ifNil, _else: _else): apply[xs, ifNil, _else] = `if`(id(xs).isEmpty, ifNil, Else(xs, _else))
    type apply[xs <: List, ifNil <: Function0, _else <: Function2]                                                              = `if`[id[xs]#isEmpty, ifNil, Else[xs, _else]]

    case class Else[xs <: List, _else <: Function2](xs: xs, _else: _else) extends AsFunction0 {
        override type self = Else[xs, _else]
        override  def apply: apply = _else.apply(xs.head, xs.tail)
        override type apply        = _else#apply[xs#head, xs#tail]
    }
}
