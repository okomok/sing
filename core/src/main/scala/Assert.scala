

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


private[sing]
object Assert {
      def apply[c <: Boolean](c: c): apply[c] = `if`(c, Const(Unit), Else(c)).apply
     type apply[c <: Boolean]                 = `if`[c, Const[Unit], Else[c]]#apply

     case class Else[c <: Boolean](c: c) extends AsFunction0 {
         override type self = Else[c]
         override  def apply: apply = throw new AssertionError("sing.assert")
         override type apply = Nothing // Assert.apply[c]
     }
}
