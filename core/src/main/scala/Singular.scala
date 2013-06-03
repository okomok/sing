

// Copyright Shunsuke Sogame 2008-2013.
// Distributed under the New BSD license.


package com.github.okomok
package sing


trait Singular extends Any with RefEquals {
    override  def unsing: unsing = self
    override type unsing         = self
}
