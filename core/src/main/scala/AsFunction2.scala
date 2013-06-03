

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


import function._


trait AsFunction2 extends Function2 with AsAny with RefEquals {
    override  def asFunction2: asFunction2 = self
    override type asFunction2              = self

    override  def curried: curried = Curried2.Impl(self)
    override type curried          = Curried2.Impl[self]

    override  def tupled: tupled = Tupled2.Impl(self)
    override type tupled         = Tupled2.Impl[self]

    override  def not: not = Not2.Impl(self)
    override type not      = Not2.Impl[self]
}
