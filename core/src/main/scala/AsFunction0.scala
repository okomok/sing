

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait AsFunction0 extends Function0 with AsAny with UnsingEquals {
    override  def asFunction0: asFunction0 = self
    override type asFunction0              = self

    override  val unsing: unsing = () => apply.unsing
    override type unsing         = () => apply#unsing

    override def canEqual(that: scala.Any) = that.isInstanceOf[Function0]
}
