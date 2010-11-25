

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package sing


trait Function0 extends Any {
    type self <: Function0

    final override  def asFunction0: asFunction0 = self
    final override type asFunction0              = self

     def apply: apply
    type apply <: Any

    override  val unsung: unsung = () => apply.unsung
    override type unsung         = () => apply#unsung

    override def canEqual(that: scala.Any) = that.isInstanceOf[Function0]
}
