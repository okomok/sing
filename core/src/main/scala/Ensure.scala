

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


// pending
case class Ensure[a <: Any, cond <: Function1, msg](a: a, cond: cond, msg: msg) extends AsFunction0 {
    override type self = Ensure[a, cond, msg]
    override  def apply: apply = `if`(cond.apply(a).asBoolean, Const(a), Ensure(a, cond, msg)).apply
    override type apply        = `if`[cond#apply[a]#asBoolean, Const[a], Ensure[a, cond, msg]]#apply
}
