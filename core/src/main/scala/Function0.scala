

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


object Function0 extends AsKind


trait Function0 extends Any {
    override type self <: Function0

     def apply: apply
    type apply <: Any
}


trait AsFunction0 extends Function0Impl {
    override  def kind: kind = Function0
    override type kind       = Function0.type
}


trait Function0Impl extends Function0 with AnyImpl with UnsingEquals {
    override  def asFunction0: asFunction0 = self
    override type asFunction0              = self

    override  def unsing: unsing = () => apply.unsing
    override type unsing         = () => apply#unsing

    override def canEqual(that: scala.Any) = that.isInstanceOf[Function0]
}
