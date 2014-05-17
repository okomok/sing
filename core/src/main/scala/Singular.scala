

// Copyright Shunsuke Sogame 2008-2014.
// Distributed under the New BSD license.


package com.github.okomok.sing


trait Singular extends AsAny with RefEquals {
    override  def unsing: unsing = self
    override type unsing         = self
}
